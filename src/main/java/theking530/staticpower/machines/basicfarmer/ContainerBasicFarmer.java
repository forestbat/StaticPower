package theking530.staticpower.machines.basicfarmer;

import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import theking530.staticpower.client.gui.widgets.SlotFilter;
import theking530.staticpower.handlers.crafting.registries.InfuserRecipeRegistry;
import theking530.staticpower.items.itemfilter.ItemFilter;
import theking530.staticpower.items.tools.ISolderingIron;
import theking530.staticpower.items.upgrades.BaseUpgrade;
import theking530.staticpower.machines.solderingtable.SlotSolderingTableInput;

public class ContainerBasicFarmer extends Container {
	
	private TileEntityBasicFarmer FARMER;
	private int PROCESSING_TIME;
	private int FLUID_AMOUNT;
	private int lastItemInfusionTime;
	
	public ContainerBasicFarmer(InventoryPlayer invPlayer, TileEntityBasicFarmer teFarmer) {
		FLUID_AMOUNT = 0;
		
		FARMER = teFarmer;
		
        for (int l = 0; l < 3; ++l) {
            for (int i1 = 0; i1 < 3; ++i1){
                this.addSlotToContainer(new Slot(teFarmer, i1 + l * 3, 68 + i1 * 18, 30 + l * 18));
            }
        }
		this.addSlotToContainer(new Slot(teFarmer, 9, 71, 8) {
			@Override
	        public boolean isItemValid(ItemStack itemStack) {
		          return itemStack.getItem() instanceof ItemHoe;
		        }
		});
		this.addSlotToContainer(new Slot( teFarmer, 10, 101, 8) {
			@Override
	        public boolean isItemValid(ItemStack itemStack) {
		          return itemStack.getItem() instanceof ItemAxe;
		        }
		});
		this.addSlotToContainer(new Slot(teFarmer, 11, 37, 8) {
			@Override
	        public boolean isItemValid(ItemStack itemStack) {
		          return itemStack.getItem() instanceof ItemBucket;
		        }
		});
		this.addSlotToContainer(new Slot(teFarmer, 12, 37, 30) {
			@Override
	        public boolean isItemValid(ItemStack itemStack) {
		          return false;
		        }
		});
		this.addSlotToContainer(new Slot(teFarmer, 13, 8, 71) {
			@Override
	        public boolean isItemValid(ItemStack itemStack) {
		          return itemStack.getItem() instanceof IEnergyContainerItem;
		        }
		});
		for(int y=0; y<3; y++) {
			this.addSlotToContainer(new Slot(teFarmer, 14+y, 152, 12+(y*20)) {
				@Override
		        public boolean isItemValid(ItemStack itemStack) {
			          return itemStack.getItem() instanceof BaseUpgrade;
			        }
			});
		}
		//Inventory
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 9; j++) {
						this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 90 + i * 18));
					}
				}
				
				//ActionBar
				for(int i = 0; i < 9; i++) {
					this.addSlotToContainer(new Slot(invPlayer, i, 8+ i * 18, 148));
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
	        	if (FurnaceRecipes.instance().getSmeltingResult(itemstack1) != null){
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
		return FARMER.isUseableByPlayer(player);
	}
	
	//Detect Changes
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
	}
	
	//Send Gui Update
	public void updateProgressBar(int i, int j) {		
	}
	
}

