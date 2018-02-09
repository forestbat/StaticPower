	package theking530.staticpower.machines.fermenter;

import api.gui.tab.BaseGuiTab.TabSide;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.fluids.FluidStack;
import theking530.staticpower.assists.GuiTextures;
import theking530.staticpower.client.gui.BaseGuiContainer;
import theking530.staticpower.client.gui.widgets.tabs.GuiMachinePowerInfoTab;
import theking530.staticpower.client.gui.widgets.tabs.GuiRedstoneTab;
import theking530.staticpower.client.gui.widgets.tabs.GuiSideConfigTab;
import theking530.staticpower.client.gui.widgets.valuebars.GuiFluidBar;
import theking530.staticpower.client.gui.widgets.valuebars.GuiFluidBarFromTank;
import theking530.staticpower.client.gui.widgets.valuebars.GuiPowerBarFromEnergyStorage;
import theking530.staticpower.handlers.crafting.registries.FermenterRecipeRegistry;

public class GuiFermenter extends BaseGuiContainer {	

	private TileEntityFermenter fermenter;
	
	public GuiFermenter(InventoryPlayer invPlayer, TileEntityFermenter teCropSqueezer) {
		super(new ContainerFermenter(invPlayer, teCropSqueezer), 214, 172);
		fermenter = teCropSqueezer;

		registerWidget(new GuiPowerBarFromEnergyStorage(teCropSqueezer, 27, 68, 6, 60));
		registerWidget(new GuiFluidBarFromTank(teCropSqueezer.TANK, 37, 68, 16, 60));
		
		getTabManager().registerTab(new GuiRedstoneTab(100, 85, teCropSqueezer));
		getTabManager().registerTab(new GuiSideConfigTab(100, 100, teCropSqueezer));
		
		GuiMachinePowerInfoTab powerInfoTab;
		getTabManager().registerTab(powerInfoTab = new GuiMachinePowerInfoTab(80, 80, teCropSqueezer));
		powerInfoTab.setTabSide(TabSide.LEFT);	
	}
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = I18n.format(this.fermenter.getName());	
		this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2 + 7, 6,4210752 );
		//this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 3, 4210752);
	}
	
	@Override
	protected void drawExtra(float f, int i, int j) {

		Minecraft.getMinecraft().getTextureManager().bindTexture(GuiTextures.FERMENTER_GUI);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		if(fermenter.slotsInternal.getStackInSlot(0) != null) {
			int j1 = fermenter.getProgressScaled(32);
			FluidStack fluid = FermenterRecipeRegistry.Fermenting().getFluidResult(fermenter.slotsInternal.getStackInSlot(0));
			GuiFluidBar.drawFluidBar(fluid, 1000, 1000, guiLeft + 86 - j1, guiTop + 44, 1, j1, 5);
		}
	}
}


