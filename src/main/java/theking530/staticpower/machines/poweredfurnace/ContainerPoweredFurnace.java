package theking530.staticpower.machines.poweredfurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerPoweredFurnace extends Container {
	
	private TileEntityPoweredFurnace SMELTER;

	public ContainerPoweredFurnace(InventoryPlayer invPlayer, TileEntityPoweredFurnace tePoweredSmelter) {
		SMELTER = tePoweredSmelter;
		
		//Input
		this.addSlotToContainer(new SlotItemHandler(tePoweredSmelter.slotsInput, 0, 50, 28));
		
		//Battery
		this.addSlotToContainer(new SlotItemHandler(tePoweredSmelter.slotsInput, 1, 8, 65));
		
		//Output
		this.addSlotToContainer(new SlotWithExperienceOutput(invPlayer.player, tePoweredSmelter.slotsOutput, 0, 109, 32) {
			@Override
	        public boolean isItemValid(ItemStack itemStack) {
		          return !FurnaceRecipes.instance().getSmeltingResult(itemStack).isEmpty();
		    }
		});	
		
		//Upgrades
		this.addSlotToContainer(new SlotItemHandler(tePoweredSmelter.slotsUpgrades, 0, 152, 12));
		this.addSlotToContainer(new SlotItemHandler(tePoweredSmelter.slotsUpgrades, 1, 152, 32));
		this.addSlotToContainer(new SlotItemHandler(tePoweredSmelter.slotsUpgrades, 2, 152, 52));
		
		//Processing
		this.addSlotToContainer(new SlotItemHandler(tePoweredSmelter.slotsInternal, 0, 10000, 10000) {
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
	    ItemStack itemstack = ItemStack.EMPTY;
	    Slot slot = (Slot)this.inventorySlots.get(invSlot);
	
	    if (slot != null && slot.getHasStack()) {
	        ItemStack itemstack1 = slot.getStack();
	        itemstack = itemstack1.copy();
	
	        if (invSlot == 1 || invSlot == 0) {
	            if (!this.mergeItemStack(itemstack1, 6, 42, true)) {
	                return ItemStack.EMPTY;
	            }
	            slot.onSlotChange(itemstack1, itemstack);
	        }else if (invSlot != 1 && invSlot != 0){
	        	if (FurnaceRecipes.instance().getSmeltingResult(itemstack1) != null){
	                if (!this.mergeItemStack(itemstack1, 0, 1, false)){
	                    return ItemStack.EMPTY;
	                }
	            }else if (invSlot >= 6 && invSlot < 33) {
	                if (!this.mergeItemStack(itemstack1, 33, 42, false)) {
	                    return ItemStack.EMPTY;
	                }
	            }else if (invSlot >= 33 && invSlot < 42 && !this.mergeItemStack(itemstack1, 6, 33, false))  {
	                return ItemStack.EMPTY;
	            }
	        }else if (!this.mergeItemStack(itemstack1, 6, 42, false)) {
	            return ItemStack.EMPTY;
	        }
	        if (itemstack1.getCount() == 0){
	            slot.putStack(ItemStack.EMPTY);
	        }else {
	            slot.onSlotChanged();
	        }
	        if (itemstack1.getCount() == itemstack.getCount()){
	            return ItemStack.EMPTY;
	        }
	        slot.onTake(player, itemstack1);
	    }
	    return itemstack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return SMELTER.isUseableByPlayer(player);
	}
	public void detectAndSendChanges(){
        super.detectAndSendChanges();
    }
}

