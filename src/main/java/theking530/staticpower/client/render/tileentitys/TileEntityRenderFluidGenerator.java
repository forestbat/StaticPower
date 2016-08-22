package theking530.staticpower.client.render.tileentitys;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import theking530.staticpower.assists.Reference;
import theking530.staticpower.client.model.ModelBlock;
import theking530.staticpower.machines.fluidgenerator.TileEntityFluidGenerator;
import theking530.staticpower.utils.RenderUtil;
import theking530.staticpower.utils.SideModeList.Mode;

public class TileEntityRenderFluidGenerator extends TileEntitySpecialRenderer {

	ResourceLocation side = new ResourceLocation(Reference.MODID, "textures/blocks/MachineSide.png");
	ResourceLocation sideIn = new ResourceLocation(Reference.MODID, "textures/blocks/MachineSideIn.png");
	ResourceLocation sideOut = new ResourceLocation(Reference.MODID, "textures/blocks/MachineSideOut.png");
	ResourceLocation frontOn = new ResourceLocation(Reference.MODID, "textures/blocks/FluidGeneratorFrontOn.png");
	ResourceLocation front = new ResourceLocation(Reference.MODID, "textures/blocks/FluidGeneratorFrontOff.png");
	
	static float texel = 1F/16F;
	static float width = 1F;
	float height = 1F;
	
	public void renderTileEntityAt(TileEntity tileentity, double translationX, double translationY, double translationZ, float f, int dest) {
		TileEntityFluidGenerator fGen = (TileEntityFluidGenerator)tileentity;			
		EnumFacing facing = EnumFacing.getHorizontal(tileentity.getBlockMetadata());
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
		if(fGen.TANK.getFluid() != null) {	
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			drawLiquidBar(tileentity, fGen.TANK.getFluid());
			GL11.glDisable(GL11.GL_BLEND);
		}
		drawEnergyBar(tileentity);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-translationX, -translationY, -translationZ);	
		GL11.glColor3f(1.0F, 1.0F, 1.0F);	
		GL11.glPopMatrix();

	}
	
	public void checkAndRenderSides(TileEntity tileentity, int side) {
		TileEntityFluidGenerator fGen = (TileEntityFluidGenerator)tileentity;	
		ModelBlock block = new ModelBlock();
		if(side != 3) {
			if(fGen.getModeFromInt(side) == Mode.Regular) {
				this.bindTexture(this.side);
			}
			if(fGen.getModeFromInt(side) == Mode.Input) {
				this.bindTexture(sideIn);
			}
			if(fGen.getModeFromInt(side) == Mode.Output) {
				this.bindTexture(sideOut);
			}
			if(fGen.getModeFromInt(side) == Mode.Disabled) {
				this.bindTexture(this.side);
			}
			block.drawBlock(side);
		}
		if(side == 3) {
			if(fGen.hasFuel() && fGen.STORAGE.getEnergyStored() < fGen.STORAGE.getMaxEnergyStored()) {
				this.bindTexture(frontOn);
					}else{
				this.bindTexture(front);
			}
			block.drawBlock(3);
		}
	}
		
	public static void drawLiquidBar(TileEntity tileentity, FluidStack fluidStack) {
		TileEntityFluidGenerator fGen = (TileEntityFluidGenerator)tileentity;
		float height = fGen.getAdjustedVolume() > 0 ? fGen.getAdjustedVolume() : 0;	
		final Fluid fluid = fluidStack.getFluid();
		RenderUtil.drawFluidInWorld(fluidStack, 10.5F*texel, 2.5F*texel, 1.001F, 3F*texel, height+3.25F*texel);
	}

	public static void drawEnergyBar(TileEntity tileentity) {
		TileEntityFluidGenerator fGen = (TileEntityFluidGenerator)tileentity;
		float height = ((float)(fGen.STORAGE.getEnergyStored()/(float)fGen.STORAGE.getMaxEnergyStored())) > 0 ? ((float)(fGen.STORAGE.getEnergyStored()/(float)fGen.STORAGE.getMaxEnergyStored())) : 0;	
		RenderUtil.drawPowerBarInWorld(height, 2.5F*texel, 2.5F*texel, 1.0005F, 3F*texel, .69F);
	}
}