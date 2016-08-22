package theking530.staticpower.client.render.tileentitys;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import theking530.staticpower.assists.Reference;
import theking530.staticpower.client.model.ModelBlock;
import theking530.staticpower.machines.BaseMachine;
import theking530.staticpower.utils.SideModeList.Mode;

public class MachineTileEntityRenderer extends TileEntitySpecialRenderer {


	ResourceLocation side = new ResourceLocation(Reference.MODID, "textures/blocks/MachineSide.png");
	ResourceLocation sideIn = new ResourceLocation(Reference.MODID, "textures/blocks/MachineSideIn.png");
	ResourceLocation sideOut = new ResourceLocation(Reference.MODID, "textures/blocks/MachineSideOut.png");
	
	ModelBlock BLOCK = new ModelBlock();
	
	static float texel = 1F/16F;
	
	@Override
    public void renderTileEntityAt(TileEntity tileentity, double translationX, double translationY, double translationZ, float partialTicks, int destroyStage) {	
		int i = tileentity.getBlockMetadata();	
		GL11.glPushMatrix();
		GL11.glTranslated(translationX, translationY, translationZ);
		if(i == 2) {
			GL11.glRotated(180, 0, 1, 0);
			GL11.glTranslated(-1, 0, -1);
			}
		if(i == 4) {
			GL11.glRotated(-90, 0, 1, 0);
			GL11.glTranslated(0, 0, -1);
			}
		if(i == 5) {
			GL11.glRotated(90, 0, 1, 0);
			GL11.glTranslated(-1, 0, 0);
			}
		GL11.glDisable(GL11.GL_LIGHTING);		
		checkAndRenderSides(tileentity, 0);
		checkAndRenderSides(tileentity, 1);
		checkAndRenderSides(tileentity, 2);
		checkAndRenderSides(tileentity, 4);
		checkAndRenderSides(tileentity, 5);

		renderOther(tileentity);

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-translationX, -translationY, -translationZ);	
		GL11.glColor3f(1.0F, 1.0F, 1.0F);	
		GL11.glPopMatrix();

	}
	
	public void checkAndRenderSides(TileEntity tileentity, int side) {
		BaseMachine machine = (BaseMachine)tileentity;	
		
		if(side != 3) {
			if(machine.getModeFromInt(side) == Mode.Regular) {
				this.bindTexture(this.side);
			}
			if(machine.getModeFromInt(side) == Mode.Input) {
				this.bindTexture(sideIn);
			}
			if(machine.getModeFromInt(side) == Mode.Output) {
				this.bindTexture(sideOut);
			}
			if(machine.getModeFromInt(side) == Mode.Disabled) {
				this.bindTexture(this.side);
			}
			BLOCK.drawBlock(side);
		}
	}
	
	public void renderOther(TileEntity tileentity) {
		
	}
	public static ResourceLocation getFluidSheet(FluidStack liquid) {
		if (liquid == null) return TextureMap.LOCATION_BLOCKS_TEXTURE;
		return getFluidSheet(liquid.getFluid());
	}
	
	public static ResourceLocation getFluidSheet(Fluid liquid) {
		return TextureMap.LOCATION_BLOCKS_TEXTURE;
	}
}
