package theking530.staticpower.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import theking530.staticpower.assists.Reference;
import theking530.staticpower.blocks.ModBlocks;
import theking530.staticpower.items.ModItems;

public class ItemRenderRegistry {

	public static void initItemRenderers() {
		ItemRenderRegistry.registerItem(ModItems.StaticHelmet);
		ItemRenderRegistry.registerItem(ModItems.StaticChestplate);
		ItemRenderRegistry.registerItem(ModItems.StaticLeggings);
		ItemRenderRegistry.registerItem(ModItems.StaticBoots);
		ItemRenderRegistry.registerItem(ModItems.EnergizedHelmet);
		ItemRenderRegistry.registerItem(ModItems.EnergizedChestplate);
		ItemRenderRegistry.registerItem(ModItems.EnergizedLeggings);
		ItemRenderRegistry.registerItem(ModItems.EnergizedBoots);
		
		ItemRenderRegistry.registerItem(ModItems.SilverDust);
		ItemRenderRegistry.registerItem(ModItems.CopperDust);
		ItemRenderRegistry.registerItem(ModItems.IronDust);
		ItemRenderRegistry.registerItem(ModItems.GoldDust);
		ItemRenderRegistry.registerItem(ModItems.SilverDust);
		ItemRenderRegistry.registerItem(ModItems.TinDust);
		ItemRenderRegistry.registerItem(ModItems.LeadDust);
		ItemRenderRegistry.registerItem(ModItems.PlatinumDust);
		ItemRenderRegistry.registerItem(ModItems.StaticDust);
		ItemRenderRegistry.registerItem(ModItems.EnergizedDust);
		ItemRenderRegistry.registerItem(ModItems.LumumDust);
		ItemRenderRegistry.registerItem(ModItems.InertInfusionBlend);
		ItemRenderRegistry.registerItem(ModItems.RedstoneAlloyDust);
		
		ItemRenderRegistry.registerItem(ModItems.StaticNugget);
		ItemRenderRegistry.registerItem(ModItems.EnergizedNugget);
		ItemRenderRegistry.registerItem(ModItems.LumumNugget);
		
		ItemRenderRegistry.registerItem(ModItems.SilverIngot);
		ItemRenderRegistry.registerItem(ModItems.CopperIngot);
		ItemRenderRegistry.registerItem(ModItems.TinIngot);
		ItemRenderRegistry.registerItem(ModItems.LeadIngot);
		ItemRenderRegistry.registerItem(ModItems.PlatinumIngot);
		ItemRenderRegistry.registerItem(ModItems.StaticIngot);
		ItemRenderRegistry.registerItem(ModItems.EnergizedIngot);
		ItemRenderRegistry.registerItem(ModItems.LumumIngot);
		ItemRenderRegistry.registerItem(ModItems.InertIngot);
		ItemRenderRegistry.registerItem(ModItems.RedstoneAlloyIngot);
		
		ItemRenderRegistry.registerItem(ModItems.StaticWrench);
		ItemRenderRegistry.registerItem(ModItems.SolderingIron);
<<<<<<< HEAD
		ItemRenderRegistry.registerItem(ModItems.CoordinateMarker);
		ItemRenderRegistry.registerItem(ModItems.StaticBook);
		
		ItemRenderRegistry.registerItem(ModItems.BasicCircuit);
		ItemRenderRegistry.registerItem(ModItems.StaticCircuit);
		ItemRenderRegistry.registerItem(ModItems.EnergizedCircuit);
		ItemRenderRegistry.registerItem(ModItems.LumumCircuit);
=======
		ItemRenderRegistry.registerItem(ModItems.ElectricSolderingIron);
		ItemRenderRegistry.registerItem(ModItems.CoordinateMarker);
		ItemRenderRegistry.registerItem(ModItems.StaticBook);
		
		ItemRenderRegistry.registerItem(ModItems.BasicCircuit);
		ItemRenderRegistry.registerItem(ModItems.StaticCircuit);
		ItemRenderRegistry.registerItem(ModItems.EnergizedCircuit);
		ItemRenderRegistry.registerItem(ModItems.LumumCircuit);
		
		ItemRenderRegistry.registerItem(ModItems.BasicBattery);
		ItemRenderRegistry.registerItem(ModItems.StaticBattery);
		ItemRenderRegistry.registerItem(ModItems.EnergizedBattery);
		ItemRenderRegistry.registerItem(ModItems.LumumBattery);
>>>>>>> branch '1.10.2' of https://github.com/Theking5301/StaticPower.git
		
		ItemRenderRegistry.registerItem(ModItems.Rubber);
		ItemRenderRegistry.registerItem(ModItems.IOPort);
		
		ItemRenderRegistry.registerItem(ModItems.BasicPowerUpgrade);
		ItemRenderRegistry.registerItem(ModItems.BasicSpeedUpgrade);
		ItemRenderRegistry.registerItem(ModItems.BasicTankUpgrade);
		ItemRenderRegistry.registerItem(ModItems.StaticPowerUpgrade);
		ItemRenderRegistry.registerItem(ModItems.StaticSpeedUpgrade);
		ItemRenderRegistry.registerItem(ModItems.StaticTankUpgrade);
		ItemRenderRegistry.registerItem(ModItems.StaticQuarryingUpgrade);
		ItemRenderRegistry.registerItem(ModItems.EnergizedPowerUpgrade);
		ItemRenderRegistry.registerItem(ModItems.EnergizedSpeedUpgrade);
		ItemRenderRegistry.registerItem(ModItems.EnergizedTankUpgrade);
		ItemRenderRegistry.registerItem(ModItems.EnergizedQuarryingUpgrade);
		ItemRenderRegistry.registerItem(ModItems.LumumPowerUpgrade);
		ItemRenderRegistry.registerItem(ModItems.LumumSpeedUpgrade);
		ItemRenderRegistry.registerItem(ModItems.LumumTankUpgrade);
		ItemRenderRegistry.registerItem(ModItems.LumumQuarryingUpgrade);
		
		ItemRenderRegistry.registerItem(ModItems.StaticCrop);
		ItemRenderRegistry.registerItem(ModItems.EnergizedCrop);
		ItemRenderRegistry.registerItem(ModItems.LumumCrop);
		ItemRenderRegistry.registerItem(ModItems.DepletedCrop);
		ItemRenderRegistry.registerItem(ModItems.StaticSeeds);
		ItemRenderRegistry.registerItem(ModItems.EnergizedSeeds);
		ItemRenderRegistry.registerItem(ModItems.LumumSeeds);
		
		ItemRenderRegistry.registerItem(ModItems.BasicItemFilter);
		ItemRenderRegistry.registerItem(ModItems.UpgradedItemFilter);
		ItemRenderRegistry.registerItem(ModItems.AdvancedItemFilter);
		
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.MachineBlock));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.StaticBattery));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.EnergizedBattery));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.LumumBattery));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.CropSqueezer));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.FluidGenerator));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.FluidInfuser));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.FusionFurnace));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.PoweredFurnace));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.PoweredGrinder));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.SolderingTable));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.Quarry));
		
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.SilverOre));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.CopperOre));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.TinOre));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.LeadOre));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.PlatinumOre));
		
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.StaticPlanks));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.EnergizedPlanks));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.LumumPlanks));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.StaticCobblestone));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.EnergizedCobblestone));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.LumumCobblestone));

		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.StaticBlock));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.EnergizedBlock));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.LumumBlock));
		
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.StaticLamp));
		
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.VacuumChest));
		
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.ItemConduit));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.StaticConduit));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.FluidConduit));
		
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.ObsidianGlass));
		
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.StaticWood));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.EnergizedWood));
		ItemRenderRegistry.registerItem(Item.getItemFromBlock(ModBlocks.LumumWood));
	}
    public static void registerItem(Item item, int metadata) {
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        .register(item, metadata, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
    public static void registerItem(Item item) {
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        .register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
    public static void registerBlock(Block block, int metadata) {
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        .register(Item.getItemFromBlock(block), metadata, new ModelResourceLocation(Reference.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }
    public static void registerBlock(Block block) {
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }
}