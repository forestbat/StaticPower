package theking530.staticpower.tileentity.staticchest;

import net.minecraft.nbt.NBTTagCompound;
import theking530.staticpower.tileentity.TileEntityBaseChest;

public class TileEntityStaticChest extends TileEntityBaseChest{

	public TileEntityStaticChest() {
		initializeBasicTileEntity(45, null, null);
	}

	//NBT
	@Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
    }		
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        return nbt;
	}	  	    

    public boolean receiveClientEvent(int i, int j) {
        if (i == 1) {
            this.numPlayersUsing = j;
            return true;
        }else{
            return super.receiveClientEvent(i, j);
        }
    }
   
    //IInventory
	@Override
	public String getName() {
		return "container.StaticChest";
		
	}	
}