package theking530.staticpower.machines.quarry;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import theking530.staticpower.client.gui.widgets.CustomGuiContainer;
import theking530.staticpower.client.gui.widgets.GuiDrawItem;
import theking530.staticpower.client.gui.widgets.buttons.ArrowButton;
import theking530.staticpower.client.gui.widgets.tabs.GuiSideConfigTab;
import theking530.staticpower.client.gui.widgets.valuebars.GuiFluidBarFromTank;
import theking530.staticpower.client.gui.widgets.valuebars.GuiPowerBarFromEnergyStorage;
import theking530.staticpower.handlers.PacketHandler;
import theking530.staticpower.items.ModItems;
import theking530.staticpower.machines.machinecomponents.DrainToBucketComponent.FluidContainerInteractionMode;
import theking530.staticpower.utils.GUIUtilities;
import theking530.staticpower.utils.GuiTextures;
import theking530.staticpower.utils.WorldUtilities;

public class GuiQuarry extends CustomGuiContainer{
	
	private GuiPowerBarFromEnergyStorage POWERBAR;
	private GuiFluidBarFromTank FLUIDBAR;
	public GuiSideConfigTab SIDE_TAB;
	private TileEntityQuarry QUARRY;

	public GuiQuarry(InventoryPlayer invPlayer, TileEntityQuarry teQuarry) {
		super(new ContainerQuarry(invPlayer, teQuarry));
		QUARRY = teQuarry;	
		POWERBAR = new GuiPowerBarFromEnergyStorage(teQuarry);
		FLUIDBAR = new GuiFluidBarFromTank(teQuarry.TANK);
		SIDE_TAB = new GuiSideConfigTab(guiLeft, guiTop, teQuarry);
		xSize = 214;
		ySize = 173;

	}
	@Override
	public void initGui() {
		super.initGui();
	 	int j = (width - xSize) / 2;
	    int k = (height - ySize) / 2;

	    this.buttonList.add(new ArrowButton(1, j+7, k+35, 16, 10, "<"));
	    
	    if(QUARRY.DRAIN_COMPONENT.getMode() == FluidContainerInteractionMode.FillFromContainer) {
	    	buttonList.get(0).displayString = ">";
	    }else{
	    	buttonList.get(0).displayString = "<";
	    }
	}
	@Override
	protected void actionPerformed(GuiButton B) {
		if(B.id == 1) {
			IMessage msg = new PacketQuarryContainerMode(QUARRY.DRAIN_COMPONENT.getInverseMode(), QUARRY.getPos());
			PacketHandler.net.sendToServer(msg);
			QUARRY.DRAIN_COMPONENT.setMode(QUARRY.DRAIN_COMPONENT.getInverseMode());
			
		    if(QUARRY.DRAIN_COMPONENT.getMode() == FluidContainerInteractionMode.FillFromContainer) {
		    	buttonList.get(0).displayString = ">";
		    }else{
		    	buttonList.get(0).displayString = "<";
		    }
		}
	}	
	@Override
	public void updateScreen() {
		SIDE_TAB.updateTab(width+38, height, xSize, ySize, fontRenderer, QUARRY);
	}
	@Override
	public void drawScreen(int par1, int par2, float par3) {
    	super.drawScreen(par1, par2, par3);
    	int var1 = (this.width - this.xSize) / 2;
        int var2 = (this.height - this.ySize) / 2;  
		this.zLevel = -1.0f;
		this.drawDefaultBackground();	
		this.zLevel = 0.0f;
		drawRect(guiLeft + 82, guiTop + 38, 176, 69, 3394815);
		
		if(par1 >= 27 + var1 && par2 >= 8 + var2 && par1 <= 42 + var1 && par2 <= 68 + var2) {	
			drawHoveringText(FLUIDBAR.drawText(), par1, par2, fontRenderer); 
		}    
		if(par1 >= 46 + var1 && par2 >= 8 + var2 && par1 <= 52 + var1 && par2 <= 68 + var2) {
			drawHoveringText(POWERBAR.drawText(), par1, par2, fontRenderer); 
		}	
		this.renderHoveredToolTip(par1, par2);
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = I18n.format(this.QUARRY.getName());
		fontRenderer.drawString(name, xSize / 2 - fontRenderer.getStringWidth(name) / 2 + 3, 7, 255 << 24 | 255 << 16 | 255 << 8 | 255);

		float scale = 0.7F;
		String currentPosition = QUARRY.CURRENT_COORD.toString().substring(9, QUARRY.CURRENT_COORD.toString().length()-1);
		String area = "Area: " + WorldUtilities.getAreaBetweenCorners(QUARRY.STARTING_COORD, QUARRY.ENDING_COORD);
		String tutorial = "� Right click on the Quarry";
		String tutorial2 = "block with a populated";
		String tutorial3 = "Coordinate Marker to start";
		String tutorial4 = "quarrying!";
		String tutorial5 = "� Place a chest on";
		String tutorial6 = "top to collect items!";
		String tutorial7 = "� Power with RF Power.";
		String speed = "Ticks per Operation: " + QUARRY.PROCESSING_TIME;
		String blocks = "Blocks per Operation: " + QUARRY.BLOCKS_PER_TICK;
		String energy = "RF per Block: " + QUARRY.PROCESSING_ENERGY_MULT * 100;
		String fortune = "Fortune Level: " + QUARRY.getFortuneMultiplier();
		
		GL11.glScalef(scale, scale, scale);
		if(!QUARRY.isAbleToMine()) {
			fontRenderer.drawString(tutorial, xSize / 2 - 20, 30, GUIUtilities.getColor(200, 200, 200));
			fontRenderer.drawString(tutorial2, xSize / 2 - 20, 40, GUIUtilities.getColor(200, 200, 200));
			fontRenderer.drawString(tutorial3, xSize / 2 - 20, 50, GUIUtilities.getColor(200, 200, 200));
			fontRenderer.drawString(tutorial4, xSize / 2 - 20, 60, GUIUtilities.getColor(200, 200, 200));
			fontRenderer.drawString(tutorial5, xSize / 2 - 20, 75, GUIUtilities.getColor(200, 200, 200));
			fontRenderer.drawString(tutorial6, xSize / 2 - 20, 85, GUIUtilities.getColor(200, 200, 200));
			fontRenderer.drawString(tutorial7, xSize / 2 - 20, 100, GUIUtilities.getColor(200, 200, 200));
		}else if(QUARRY.isDoneMining()) {
			fontRenderer.drawString("Quarrying Completed!", xSize / 2 - 26, 30, GUIUtilities.getColor(200, 200, 200));
		}else{
			fontRenderer.drawString("Current Position: ", xSize / 2 - fontRenderer.getStringWidth("Current Position: ") / 2 + 23, 30, GUIUtilities.getColor(200, 200, 200));
			fontRenderer.drawString("� " + currentPosition, xSize / 2 - 20, 40, GUIUtilities.getColor(200, 200, 200));
			fontRenderer.drawString("� " + area, xSize / 2 - 20, 55, GUIUtilities.getColor(200, 200, 200));
			fontRenderer.drawString("� " + speed, xSize / 2 - 20, 65, GUIUtilities.getColor(200, 200, 200));
			fontRenderer.drawString("� " + blocks, xSize / 2 - 20, 75, GUIUtilities.getColor(200, 200, 200));
			fontRenderer.drawString("� " + energy, xSize / 2 - 20, 85, GUIUtilities.getColor(200, 200, 200));
			fontRenderer.drawString("� " + fortune, xSize / 2 - 20, 95, GUIUtilities.getColor(200, 200, 200));
		}

		GL11.glScalef(1/scale, 1/scale, 1/scale);
	
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(GuiTextures.QUARRY_GUI);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    	GuiDrawItem.drawItem(ModItems.BasicItemFilter, guiLeft, guiTop, 27, 71, zLevel, 0.5f);
		SIDE_TAB.drawTab();	
		POWERBAR.drawPowerBar(guiLeft + 47, guiTop + 66, 6, 60, this.zLevel, f);
		FLUIDBAR.drawFluidBar(guiLeft + 27, guiTop + 66, 16, 60, this.zLevel);
	}
	@Override
	protected void mouseClicked(int x, int y, int button) throws IOException{
	    super.mouseClicked(x, y, button);
	    SIDE_TAB.mouseInteraction(x, y, button);
	}	
	@Override
	protected void mouseClickMove(int x, int y, int button, long time) {
		super.mouseClickMove(x, y, button, time);
		SIDE_TAB.mouseDrag(x, y, button, time);
	}	
}


