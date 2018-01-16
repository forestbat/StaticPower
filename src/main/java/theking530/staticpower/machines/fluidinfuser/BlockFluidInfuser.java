package theking530.staticpower.machines.fluidinfuser;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import theking530.staticpower.StaticPower;
import theking530.staticpower.client.GuiIDRegistry;
import theking530.staticpower.machines.BaseMachineBlock;

public class BlockFluidInfuser extends BaseMachineBlock{
	
	public BlockFluidInfuser() {
		super("FluidInfuser");
		setHardness(3.5f);
	    setResistance(5.0f);
	}
	@Override
		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	if (world.isRemote) {
    		return true;
    	}else if (!player.isSneaking()) {
    		TileEntityFluidInfuser entity = (TileEntityFluidInfuser) world.getTileEntity(pos);
    		if (entity != null) {
    			FMLNetworkHandler.openGui(player, StaticPower.staticpower, GuiIDRegistry.guiIDFluidInfuser, world, pos.getX(), pos.getY(), pos.getZ());

    		}
    		return true;
    	}else{
    		return false;
    	}
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityFluidInfuser();
	}
}
