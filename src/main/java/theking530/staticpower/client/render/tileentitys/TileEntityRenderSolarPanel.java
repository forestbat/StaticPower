package theking530.staticpower.client.render.tileentitys;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.TRSRTransformation;
import theking530.staticpower.assists.Reference;
import theking530.staticpower.client.model.Models;
import theking530.staticpower.machines.solarpanel.TileEntitySolarPanel;

public class TileEntityRenderSolarPanel extends TileEntitySpecialRenderer {
	
	//ResourceLocation model = new ResourceLocation(Reference.MODID, "models/machines/SolarPanel.obj");
	ResourceLocation sTextureOn;
	ResourceLocation sTextureOff;
	
    private IModel panelModel;
    private IBakedModel bakedModel;
	
	static float width = .9F;

    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
    	TileEntitySolarPanel sPanel = (TileEntitySolarPanel)tileEntity;	
    	
    	switch(sPanel.TIER) {
    	case STATIC: sTextureOn = new ResourceLocation(Reference.MODID, "textures/models/machines/SSolarPanelOn.png");
    				 sTextureOff = new ResourceLocation(Reference.MODID, "textures/models/machines/SSolarPanelOff.png");
    		break;
    	case ENERGIZED: sTextureOn = new ResourceLocation(Reference.MODID, "textures/models/machines/ESolarPanelOn.png");
    					sTextureOff = new ResourceLocation(Reference.MODID, "textures/models/machines/ESolarPanelOff.png");
    		break;
    	case LUMUM: sTextureOn = new ResourceLocation(Reference.MODID, "textures/models/machines/LSolarPanelOn.png");
    				sTextureOff = new ResourceLocation(Reference.MODID, "textures/models/machines/LSolarPanelOff.png");
    		break;
    	default: sTextureOn = new ResourceLocation(Reference.MODID, "textures/models/machines/SSolarPanelOn.png");
    			 sTextureOff = new ResourceLocation(Reference.MODID, "textures/models/machines/SSolarPanelOff.png");
    		break;
    	}
    		
        GlStateManager.pushMatrix();

        GlStateManager.translate(.5, 0, .5);
        long angle = (System.currentTimeMillis() / 10) % 360;
        GlStateManager.rotate(angle, 0, 1, 0);

        RenderHelper.disableStandardItemLighting();
        this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        if (Minecraft.isAmbientOcclusionEnabled()) {
            GlStateManager.shadeModel(GL11.GL_SMOOTH);
        } else {
            GlStateManager.shadeModel(GL11.GL_FLAT);
        }

        World world = tileEntity.getWorld();
        // Translate back to local view coordinates so that we can do the acual rendering here
        GlStateManager.translate(-tileEntity.getPos().getX(), -tileEntity.getPos().getY(), -tileEntity.getPos().getZ());

        Tessellator tessellator = Tessellator.getInstance();
        tessellator.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.BLOCK);
        Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelRenderer().renderModel(
                world,
                getBakedModel(),
                world.getBlockState(tileEntity.getPos()),
                tileEntity.getPos(),
                Tessellator.getInstance().getBuffer(), false);
        tessellator.draw();

        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    private IBakedModel getBakedModel() {
        // Since we cannot bake in preInit() we do lazy baking of the model as soon as we need it
        // for rendering
        if (bakedModel == null) {
            try {
            	panelModel = ModelLoaderRegistry.getModel(Models.SOLARPANEL);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            bakedModel = panelModel.bake(TRSRTransformation.identity(), DefaultVertexFormats.ITEM,
                    location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString()));
        }
        return bakedModel;
    }
}
