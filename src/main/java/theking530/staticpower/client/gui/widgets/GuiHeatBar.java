package theking530.staticpower.client.gui.widgets;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import theking530.staticpower.assists.Reference;
import theking530.staticpower.utils.RenderUtil;

public class GuiHeatBar {
	
	private static ResourceLocation powerBar = new ResourceLocation(Reference.MODID + ":" + "textures/gui/PowerBar.png");
	
	public List drawText(int fluidAmount, int maxCapacity) {
		String text = ("Heat" + "=" + NumberFormat.getNumberInstance(Locale.US).format(fluidAmount) + "/" + NumberFormat.getNumberInstance(Locale.US).format(maxCapacity));
		String[] splitMsg = text.split("=");
		return Arrays.asList(splitMsg);
	}

	public static void drawHeatBar(int maxHeat, int heat, double x, double y, double zLevel, double width, double height) {
		    TextureAtlasSprite icon = RenderUtil.getStillTexture(FluidRegistry.LAVA);

		    float ratio = ((float)heat/(float)maxHeat);
		    float renderAmount = ratio * (float) height;
	
		    RenderUtil.bindBlockTexture();	    
		    GlStateManager.enableBlend();    

	        double minU = icon.getMinU();
	        double maxU = icon.getMaxU();
	        double minV = icon.getMinV();
	        double maxV = icon.getMaxV();
	        double diffV = maxV - minV;
	        Tessellator tessellator = Tessellator.getInstance();
	        VertexBuffer tes = tessellator.getBuffer();
	        tes.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
			//Minecraft.getMinecraft().getTextureManager().bindTexture(powerBar);
			tes.pos(x + width, y, zLevel).tex(maxU,minV).endVertex();
			tes.pos(x + width, y - renderAmount, zLevel).tex(maxU, minV+(diffV*ratio)).endVertex();
			tes.pos(x, y - renderAmount, zLevel).tex(minU, minV+(diffV*ratio)).endVertex();
			tes.pos(x, y, zLevel).tex(minU,minV).endVertex();	
	        tessellator.draw();

		    GlStateManager.disableBlend();
	}
}
