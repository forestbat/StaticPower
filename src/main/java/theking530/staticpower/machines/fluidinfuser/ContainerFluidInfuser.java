package theking530.staticpower.machines.fluidinfuser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import theking530.staticpower.handlers.crafting.registries.InfuserRecipeRegistry;

public class ContainerFluidInfuser extends Container {
	
	private TileEntityFluidInfuser Infuser;
	private int PROCESSING_TIME;
	private int FLUID_AMOUNT;
	private int lastItemInfusionTime;
	
	public ContainerFluidInfuser(InventoryPlayer invPlayer, TileEntityFluidInfuser teFluidInfuser) {
		PROCESSING_TIME = 0;
		FLUID_AMOUNT = 0;
		lastItemInfusionTime = 0;
		
		Infuser = teFluidInfuser;
		
		//Input
		this.addSlotToContainer(new Slot(teFluidInfuser, 0, 55, 32));
		
		//Output
		this.addSlotToContainer(new SlotFluidInfuser(invPlayer.player, teFluidInfuser, 1, 112, 32) {
			@Override
	        public boolean isItemValid(ItemStack itemStack) {
		          return InfuserRecipeRegistry.Infusing().getInfusingItemStackResult(itemStack, Infuser.TANK.getFluid()) != null;
		    }
		});
		
		//Upgrades
		this.addSlotToContainer(new Slot(teFluidInfuser, 2, 152, 12));
		this.addSlotToContainer(new Slot(teFluidInfuser, 3, 152, 32));
		this.addSlotToContainer(new Slot(teFluidInfuser, 4, 152, 52));
		
		//Processing
		this.addSlotToContainer(new Slot(teFluidInfuser, 5, 10000, 10000) {
			@Override
	        public boolean isItemValid(ItemStack itemStack) {
		          return false;
		        }
		});
				
		//Inventory
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 9; j++) {
						this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
					}
				}
				
				//ActionBar
				for(int i = 0; i < 9; i++) {
					this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
			}
	}

	//Shift Click Functionality
	public ItemStack transferStackInSlot(EntityPlayer player, int invSlot) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(invSlot);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (invSlot == 1 || invSlot == 0) {
                if (!this.mergeItemStack(itemstack1, 6, 42, true)) {
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            }else if (invSlot != 1 && invSlot != 0){
            	if (InfuserRecipeRegistry.Infusing().getInfusingItemStackResult(itemstack1, Infuser.TANK.getFluid()) != null){
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)){
                        return null;
                    }
                }else if (invSlot >= 6 && invSlot < 33) {
                    if (!this.mergeItemStack(itemstack1, 33, 42, false)) {
                        return null;
                    }
                }else if (invSlot >= 33 && invSlot < 42 && !this.mergeItemStack(itemstack1, 6, 33, false))  {
                    return null;
                }
            }else if (!this.mergeItemStack(itemstack1, 6, 42, false)) {
                return null;
            }
            if (itemstack1.stackSize == 0){
                slot.putStack((ItemStack)null);
            }else {
                slot.onSlotChanged();
            }
            if (itemstack1.stackSize == itemstack.stackSize){
                return null;
            }
            slot.onPickupFromSlot(player, itemstack1);
        }
        return itemstack;
	   }
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return Infuser.isUseableByPlayer(player);
	}
	//Detect Changes
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		this.PROCESSING_TIME = this.Infuser.PROCESSING_TIMER;
	}
	public void updateProgressBar(int i, int j) {
		if (i == 0) {
			Infuser.PROCESSING_TIMER = j;
		}
	}
}
