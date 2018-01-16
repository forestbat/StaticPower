package theking530.staticpower.conduits.staticconduit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import theking530.staticpower.conduits.BaseConduit;

public class BlockStaticConduit extends BaseConduit {

	public BlockStaticConduit() {
		super("StaticConduit");
		this.useNeighborBrightness = true;
	}
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityStaticConduit();
	}
}
