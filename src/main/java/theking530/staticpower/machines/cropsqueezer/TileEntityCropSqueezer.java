package theking530.staticpower.machines.cropsqueezer;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import theking530.staticpower.handlers.crafting.registries.SqueezerRecipeRegistry;
import theking530.staticpower.machines.BaseMachineWithTank;
import theking530.staticpower.machines.machinecomponents.DrainToBucketComponent;
import theking530.staticpower.utils.InventoryUtilities;

public class TileEntityCropSqueezer extends BaseMachineWithTank {

	public int INITIAL_PROCESSING_ENERGY_MULT = 10;
	public int ENERGY_CAPACTIY = 100000;
	public DrainToBucketComponent DRAIN_COMPONENT;
	
	public TileEntityCropSqueezer() {
		initializeBaseMachineWithTank(2, 100, 100000, 80, 50, 1, 2, 2, 5000);
		DRAIN_COMPONENT = new DrainToBucketComponent("BucketDrain", SLOTS_INPUT, 1, SLOTS_OUTPUT, 1, this, TANK, FLUID_TO_CONTAINER_RATE);
	}
	@Override
	public String getName() {
		return "Crop Squeezer";		
	}		
	
    //Process
	@Override
	public ItemStack getResult(ItemStack itemStack) {
		return SqueezerRecipeRegistry.Squeezing().getSqueezingItemResult(itemStack);
	}
	@Override 
	public boolean hasResult(ItemStack itemstack) {
		if(itemstack != null && getResult(itemstack) != null) {
			return true;
		}
		return false;
	}
	public FluidStack getFluidResult(ItemStack itemStack) {
    	if(itemStack != null) {
    		return SqueezerRecipeRegistry.Squeezing().getSqueezingFluidResult(itemStack);
    	}
    	return null;
    }
	@Override
	public boolean canProcess(ItemStack itemstack) {
		FluidStack fluidstack = SqueezerRecipeRegistry.Squeezing().getSqueezingFluidResult(itemstack);
		if(hasResult(itemstack) && fluidstack != null && canSlotAcceptItemstack(getResult(itemstack), SLOTS_OUTPUT.getStackInSlot(0))) {
			if(fluidstack.amount + TANK.getFluidAmount() > TANK.getCapacity()) {
				return false;
			}
			if(STORAGE.getEnergyStored() < getProcessingEnergy(itemstack)) {
				return false;
			}
			if (TANK.getFluid() != null && !fluidstack.isFluidEqual(TANK.getFluid())) {
				return false;
			}
			if(TANK.getFluid() == null) {
				return true;
			}
			if(TANK.getFluidAmount() + fluidstack.amount <= TANK.getCapacity()) {
				return true;
			}
			if(TANK.getFluidAmount() + fluidstack.amount > TANK.getCapacity()) {
				return false;
			}
			if (TANK.getFluid() != null && fluidstack.isFluidEqual(TANK.getFluid())) {
				return true;
			}				
		}
		return false;
	}
	@Override
	public int getProcessingCost() {
		if(SLOTS_INPUT.getStackInSlot(0) != ItemStack.EMPTY) {
			return getProcessingEnergy(SLOTS_INPUT.getStackInSlot(0));
		}else if(SLOTS_INTERNAL.getStackInSlot(0) != ItemStack.EMPTY){
			return getProcessingEnergy(SLOTS_INTERNAL.getStackInSlot(0));
		}
		return 0;
	}
	@Override
	public int getProcessingEnergy(ItemStack itemStack) {
		if(getResult(itemStack) != ItemStack.EMPTY) {
			return INITIAL_POWER_USE*PROCESSING_ENERGY_MULT;
		}
		return 0;
	}	
	public void process() {
		if(!getWorld().isRemote) {
			DRAIN_COMPONENT.update();
			if(SLOTS_INTERNAL.getStackInSlot(0) == ItemStack.EMPTY){
				PROCESSING_TIMER = 0;
			}
			//Start Process
			if(!isProcessing() && !isMoving() && canProcess(SLOTS_INPUT.getStackInSlot(0))) {
				MOVE_TIMER = 1;
			}
			//Start Moving
			if(!isProcessing() && isMoving() && canProcess(SLOTS_INPUT.getStackInSlot(0))) {
				MOVE_TIMER++;
				if(MOVE_TIMER >= MOVE_SPEED) {
					MOVE_TIMER = 0;
					useEnergy(getProcessingEnergy(SLOTS_INPUT.getStackInSlot(0)));
					moveItem(SLOTS_INPUT, 0, SLOTS_INTERNAL, 0);
					PROCESSING_TIMER = 1;	
				}
			}else{
				MOVE_TIMER = 0;
			}
			//Start Processing
			if(isProcessing() && !isMoving() && canProcess(SLOTS_INTERNAL.getStackInSlot(0))) {
				if(PROCESSING_TIMER < PROCESSING_TIME) {
					PROCESSING_TIMER++;
					updateBlock();
				}else{				
					if(InventoryUtilities.canFullyInsertItemIntoSlot(SLOTS_OUTPUT, 0, getResult(SLOTS_INTERNAL.getStackInSlot(0)))) {
						TANK.fill(getFluidResult(SLOTS_INTERNAL.getStackInSlot(0)), true);
						SLOTS_OUTPUT.insertItem(0, getResult(SLOTS_INTERNAL.getStackInSlot(0)).copy(), false);
						SLOTS_INTERNAL.setStackInSlot(0, ItemStack.EMPTY);
						PROCESSING_TIMER = 0;
						updateBlock();
					}
				}
			}	
		}
	}
	@Override
	public int fill(FluidStack resource, boolean doFill) {
		if(!getWorld().isRemote) {
			updateBlock();
		}
		return TANK.fill(resource, doFill);
	}
}


	
