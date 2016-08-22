package theking530.staticpower.utils;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import theking530.staticpower.assists.Reference;
import theking530.staticpower.machines.cropsqueezer.TileEntityCropSqueezer;

public class RenderUtil {
	
	public static final ResourceLocation BLOCK_TEX = TextureMap.LOCATION_BLOCKS_TEXTURE;
	public static final ResourceLocation POWER_BAR_TEXTURE = new ResourceLocation(Reference.MODID, "textures/blocks/BlockEnergyBar.png");
	
	public static TextureAtlasSprite getStillTexture(Fluid fluid) {
		ResourceLocation iconKey = fluid.getStill();
		if (iconKey == null) {
			return null;
		}
		return Minecraft.getMinecraft().getTextureMapBlocks().getTextureExtry(iconKey.toString());
	}
	public static TextureManager engine() {
		return Minecraft.getMinecraft().renderEngine;
	}
	public static void bindBlockTexture() {
	    engine().bindTexture(BLOCK_TEX);
	}
	public static void drawFluidInWorld(FluidStack fluidStack, float x, float y, float z, float width, float height) {
	    TextureAtlasSprite icon = RenderUtil.getStillTexture(fluidStack.getFluid());
		if(icon != null) {
			final double uMin = icon.getMinU();
			final double uMax = icon.getMaxU();
			final double vMin = icon.getMinV();
			final double vMax = icon.getMaxV();
			
			double heightDifferent = (vMax - vMin);
			RenderUtil.bindBlockTexture();
		    int color = fluidStack.getFluid().getColor(fluidStack);
		    
			GL11.glPushMatrix();
			Tessellator tessellator = Tessellator.getInstance();
	        VertexBuffer vertexbuffer = tessellator.getBuffer();
	        vertexbuffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
	
			vertexbuffer.pos(x+width, y+height, z).tex(uMax, vMax).endVertex();
			vertexbuffer.pos(x+width, y, z).tex(uMax, vMin).endVertex();
			vertexbuffer.pos(x, y, z).tex(uMin, vMin).endVertex();
			vertexbuffer.pos(x, y+height, z).tex(uMin, vMax).endVertex();	
				
			tessellator.draw();		
			GL11.glPopMatrix();
		}

	}
	public static void drawPowerBarInWorld(float ratio, float x, float y, float z, float width, float height) {	
		engine().bindTexture(POWER_BAR_TEXTURE);
	    
		GL11.glPushMatrix();
		Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer vertexbuffer = tessellator.getBuffer();
        vertexbuffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
		GL11.glRotated(180, 0, 1, 0);
		GL11.glScaled(1, 1, -1);
		GL11.glTranslated(-1, 0, 0);
		vertexbuffer.pos(x+width, y+(height*ratio), z).tex(1, ratio).endVertex();
		vertexbuffer.pos(x+width, y, z).tex(1, 0).endVertex();
		vertexbuffer.pos(x, y, z).tex(0, 0).endVertex();
		vertexbuffer.pos(x, y+(height*ratio), z).tex(0, ratio).endVertex();	
			
		tessellator.draw();		
		GL11.glPopMatrix();
	}
}