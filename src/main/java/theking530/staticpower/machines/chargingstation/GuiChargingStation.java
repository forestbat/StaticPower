package theking530.staticpower.machines.chargingstation;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import theking530.staticpower.client.gui.widgets.tabs.GuiRedstoneTab;
import theking530.staticpower.client.gui.widgets.tabs.GuiSideConfigTab;
import theking530.staticpower.client.gui.widgets.valuebars.GuiPowerBarFromEnergyStorage;
import theking530.staticpower.utils.GuiTextures;

public class GuiChargingStation extends GuiContainer{
	
	public GuiPowerBarFromEnergyStorage POWER_BAR;
	public GuiSideConfigTab SIDE_TAB;
	public GuiRedstoneTab REDSTONE_TAB;
	
	private TileEntityChargingStation C_STATION;
	
	public GuiChargingStation(InventoryPlayer invPlayer, TileEntityChargingStation teCharging) {
		super(new ContainerChargingStation(invPlayer, teCharging));
		C_STATION = teCharging;
		POWER_BAR = new GuiPowerBarFromEnergyStorage(teCharging);
		REDSTONE_TAB = new GuiRedstoneTab(guiLeft, guiTop, teCharging);
		SIDE_TAB = new GuiSideConfigTab(guiLeft, guiTop, teCharging);
		this.xSize = 197;
		this.ySize = 176;
		
	}
	public void updateScreen() {
		SIDE_TAB.updateTab(width+42, height, xSize, ySize, fontRenderer, C_STATION);
		REDSTONE_TAB.updateTab(width+42, height, xSize, ySize, fontRenderer, C_STATION);
		if(SIDE_TAB.GROWTH_STATE == 1){
			REDSTONE_TAB.RED_TAB.GROWTH_STATE = 2;
		}
		if(REDSTONE_TAB.GROWTH_STATE == 1) {
			SIDE_TAB.BLUE_TAB.GROWTH_STATE = 2;
		}
	}	
	public void drawScreen(int par1, int par2, float par3) {
    	super.drawScreen(par1, par2, par3);
    	
		this.zLevel = -1.0f;
		this.drawDefaultBackground();	
		this.zLevel = 0.0f;
    	
    	int var1 = (this.width - this.xSize) / 2;
        int var2 = (this.height - this.ySize) / 2;  
        if(par1 >= 8 + var1 && par2 >= 8 + var2 && par1 <= 24 + var1 && par2 <= 68 + var2) {
        	int j1 = C_STATION.STORAGE.getEnergyStored();
        	int k1 = C_STATION.STORAGE.getMaxEnergyStored();
        	int i1 = C_STATION.STORAGE.getMaxReceive();
        	String text = ("Max: " + i1 + " RF/t" + "=" + NumberFormat.getNumberInstance(Locale.US).format(j1)  + "/" + NumberFormat.getNumberInstance(Locale.US).format(k1) + " " + "RF");
        	String[] splitMsg = text.split("=");
        	List<String> temp = Arrays.asList(splitMsg);
        	drawHoveringText(temp, par1, par2, fontRenderer); 
        }
		this.renderHoveredToolTip(par1, par2);
	}	

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = I18n.format(this.C_STATION.getName());
	
		this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6,4210752 );
		//this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 3, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(GuiTextures.CHARGING_STATION_GUI);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		//Progress Bar
		int j1 = C_STATION.getProgressScaled(24);
		drawTexturedModalRect(guiLeft + 73, guiTop + 32, 176, 69, j1, 14);	
		//Tabs
		SIDE_TAB.drawTab();		
		REDSTONE_TAB.drawTab();		
		//Energy Bar
		POWER_BAR.drawPowerBar(guiLeft + 8, guiTop + 68, 16, 60, 1, f);
	}
	
	@Override
	protected void mouseClicked(int x, int y, int button) throws IOException {
	    super.mouseClicked(x, y, button);
	    REDSTONE_TAB.mouseInteraction(x, y, button);
	    SIDE_TAB.mouseInteraction(x, y, button);
	}	
	protected void mouseClickMove(int x, int y, int button, long time) {
		super.mouseClickMove(x, y, button, time);
		SIDE_TAB.mouseDrag(x, y, button, time);
	}	
}


