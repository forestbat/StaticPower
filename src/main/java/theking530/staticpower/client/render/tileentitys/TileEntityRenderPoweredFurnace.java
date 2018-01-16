package theking530.staticpower.client.render.tileentitys;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import theking530.staticpower.assists.Reference;
import theking530.staticpower.client.model.ModelBlock;
import theking530.staticpower.machines.poweredfurnace.TileEntityPoweredFurnace;
import theking530.staticpower.utils.SideModeList.Mode;

public class TileEntityRenderPoweredFurnace extends TileEntitySpecialRenderer<TileEntityPoweredFurnace> {

	ResourceLocation side = new ResourceLocation(Reference.MODID, "textures/blocks/MachineSide.png");
	ResourceLocation sideIn = new ResourceLocation(Reference.MODID, "textures/blocks/MachineSideIn.png");
	ResourceLocation sideOut = new ResourceLocation(Reference.MODID, "textures/blocks/MachineSideOut.png");
	ResourceLocation sideDis = new ResourceLocation(Reference.MODID, "textures/blocks/MachineSideDIS.png");
	ResourceLocation front = new ResourceLocation(Reference.MODID, "textures/blocks/PoweredSmelterFront.png");
	ResourceLocation frontOn = new ResourceLocation(Reference.MODID, "textures/blocks/PoweredSmelterFrontOn.png");
	
	@Override
	public void render(TileEntityPoweredFurnace tileentity, double translationX, double translationY, double translationZ, float f, int dest, float alpha) {			
		EnumFacing facing = tileentity.getFacingDirection();
		
		GL11.glPushMatrix();
		GL11.glTranslated(translationX, translationY, translationZ);
		if(facing == EnumFacing.WEST) {
			GL11.glRotated(-90, 0, 1, 0);
			GL11.glTranslated(0, 0, -1);
			}
		if(facing == EnumFacing.NORTH) {
			GL11.glRotated(180, 0, 1, 0);
			GL11.glTranslated(-1, 0, -1);
			}
		if(facing == EnumFacing.EAST) {
			GL11.glRotated(90, 0, 1, 0);
			GL11.glTranslated(-1, 0, 0);
		}
		GL11.glDisable(GL11.GL_LIGHTING);			
		checkAndRenderSides(tileentity, 0);
		checkAndRenderSides(tileentity, 1);
		checkAndRenderSides(tileentity, 2);
		checkAndRenderSides(tileentity, 3);
		checkAndRenderSides(tileentity, 4);
		checkAndRenderSides(tileentity, 5);

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-translationX, -translationY, -translationZ);	
		GL11.glColor3f(1.0F, 1.0F, 1.0F);	
		GL11.glPopMatrix();

	}
	
	public void checkAndRenderSides(TileEntity tileentity, int side) {
		TileEntityPoweredFurnace smelter = (TileEntityPoweredFurnace)tileentity;		
		ModelBlock block = new ModelBlock();
		if(side != 3) {
			if(smelter.getModeFromInt(side) == Mode.Regular) {
				this.bindTexture(this.side);
			}
			if(smelter.getModeFromInt(side) == Mode.Input) {
				this.bindTexture(sideIn);
			}
			if(smelter.getModeFromInt(side) == Mode.Output) {
				this.bindTexture(sideOut);
			}
			if(smelter.getModeFromInt(side) == Mode.Disabled) {
				this.bindTexture(sideDis);
			}
			block.drawBlock(side);
		}
		if(side == 3) {
			if(smelter.isProcessing()) {
				this.bindTexture(frontOn);
				}else{
				this.bindTexture(front);
			}
			block.drawBlock(3);
		}
	}
}