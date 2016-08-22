package theking530.staticpower.items;

import static theking530.staticpower.assists.RegisterHelper.registerItem;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import theking530.staticpower.assists.RegisterHelper;
import theking530.staticpower.assists.Tier;
import theking530.staticpower.blocks.ModBlocks;
import theking530.staticpower.items.armor.EnergizedArmor;
import theking530.staticpower.items.armor.StaticArmor;
import theking530.staticpower.items.book.StaticPowerBook;
import theking530.staticpower.items.itemfilter.FilterTier;
import theking530.staticpower.items.itemfilter.ItemFilter;
import theking530.staticpower.items.materials.BaseDust;
import theking530.staticpower.items.materials.BaseIngot;
import theking530.staticpower.items.materials.BaseNugget;
import theking530.staticpower.items.tools.CoordinateMarker;
<<<<<<< HEAD
import theking530.staticpower.items.tools.SolderingIron;
import theking530.staticpower.items.tools.StaticWrench;
import theking530.staticpower.items.upgrades.BasePowerUpgrade;
import theking530.staticpower.items.upgrades.BaseQuarryingUpgrade;
import theking530.staticpower.items.upgrades.BaseSpeedUpgrade;
import theking530.staticpower.items.upgrades.BaseTankUpgrade;

public class ModItems {
	
	public static ArmorMaterial StaticMaterial = EnumHelper.addArmorMaterial("StaticMaterial", null, 28, new int[] {3, 6, 6, 3}, 25, null, 0);
	public static ArmorMaterial EnergizedMaterial = EnumHelper.addArmorMaterial("EnergizedMaterial", null, 35, new int[] {5, 10, 8, 7}, 35, null, 0);
	
	public static Item Rubber;
	public static Item IOPort;
	
	public static Item BasicCircuit;
	public static Item StaticCircuit;
	public static Item EnergizedCircuit;
	public static Item LumumCircuit;
	
	public static Item BasicSpeedUpgrade;
	public static Item StaticSpeedUpgrade;
	public static Item EnergizedSpeedUpgrade;
	public static Item LumumSpeedUpgrade;
	
	public static Item BasicTankUpgrade;
	public static Item StaticTankUpgrade;
	public static Item EnergizedTankUpgrade;
	public static Item LumumTankUpgrade;
	
	public static Item BasicPowerUpgrade;
	public static Item StaticPowerUpgrade;
	public static Item EnergizedPowerUpgrade;
	public static Item LumumPowerUpgrade;
	
	public static Item StaticQuarryingUpgrade;
	public static Item EnergizedQuarryingUpgrade;
	public static Item LumumQuarryingUpgrade;
	
	public static Item CreativePowerUpgrade;
	public static Item CreativeTankUpgrade;
	public static Item CreativeSpeedUpgrade;
	
	public static Item StaticWrench;
	public static Item SolderingIron;
	public static Item StaticBook;
	public static Item CoordinateMarker;
	
	public static Item BasicItemFilter;
	public static Item UpgradedItemFilter;
	public static Item AdvancedItemFilter;
	public static Item QuarryFilter;
	
	public static Item SilverDust;
	public static Item TinDust;
	public static Item LeadDust;
	public static Item CopperDust;
	public static Item PlatinumDust;
	public static Item IronDust;
	public static Item GoldDust;
	public static Item InertInfusionBlend;
	public static Item StaticDust;
	public static Item EnergizedDust;
	public static Item LumumDust;
	public static Item RedstoneAlloyDust;
	
	public static Item SilverIngot;
	public static Item TinIngot;
	public static Item LeadIngot;
	public static Item CopperIngot;
	public static Item PlatinumIngot;
	public static Item InertIngot;
	public static Item EnergizedIngot;
	public static Item StaticIngot;
	public static Item LumumIngot;
	public static Item RedstoneAlloyIngot;
	
	public static Item EnergizedNugget;
	public static Item StaticNugget;
	public static Item LumumNugget;
	
	public static Item StaticBelt;
	public static Item EnergizedBelt;
	public static Item StaticRing;
	public static Item EnergizedRing;
	public static Item StaticHelmet;
	public static Item StaticChestplate;
	public static Item StaticLeggings;
	public static Item StaticBoots;
	public static Item EnergizedHelmet;
	public static Item EnergizedChestplate;
	public static Item EnergizedLeggings;
	public static Item EnergizedBoots;
	
	public static Item DepletedCrop;
	public static Item EnergizedSeeds;
	public static Item EnergizedCrop;
	public static Item StaticSeeds;
	public static Item StaticCrop;
	public static Item LumumSeeds;
	public static Item LumumCrop;
	
	public static void init() {		
		
		StaticWrench = new StaticWrench().setUnlocalizedName("StaticWrench");
		RegisterHelper.registerItem(StaticWrench);
		SolderingIron = new SolderingIron("SolderingIron", 10);
		RegisterHelper.registerItem(SolderingIron);
		CoordinateMarker = new CoordinateMarker("CoordinateMarker");
		RegisterHelper.registerItem(CoordinateMarker);
		
		BasicItemFilter = new ItemFilter("BasicItemFilter", FilterTier.BASIC);
		RegisterHelper.registerItem(BasicItemFilter);
		UpgradedItemFilter = new ItemFilter("UpgradedItemFilter", FilterTier.UPGRADED);
		RegisterHelper.registerItem(UpgradedItemFilter);
		AdvancedItemFilter = new ItemFilter("AdvancedItemFilter", FilterTier.ADVANCED);
		RegisterHelper.registerItem(AdvancedItemFilter);
		
		Rubber = new ItemBase("Rubber");
		RegisterHelper.registerItem(Rubber);
		DepletedCrop = new DepletedCrop("DepletedCrop");
		RegisterHelper.registerItem(DepletedCrop);
		IOPort = new ItemBase("IOPort");
		RegisterHelper.registerItem(IOPort);
		
		StaticHelmet = new StaticArmor("StaticHelmet", StaticMaterial, "StaticHelmet", EntityEquipmentSlot.HEAD).setUnlocalizedName("StaticHelmet");
		RegisterHelper.registerItem(StaticHelmet);	
		StaticChestplate = new StaticArmor("StaticChestplate", StaticMaterial, "StaticChestplate", EntityEquipmentSlot.CHEST).setUnlocalizedName("StaticChestplate");
		RegisterHelper.registerItem(StaticChestplate);		
		StaticLeggings = new StaticArmor("StaticLeggings", StaticMaterial, "StaticLeggings", EntityEquipmentSlot.LEGS).setUnlocalizedName("StaticLeggings");
		RegisterHelper.registerItem(StaticLeggings);		
		StaticBoots = new StaticArmor("StaticBoots", StaticMaterial, "StaticBoots", EntityEquipmentSlot.FEET).setUnlocalizedName("StaticBoots");
		RegisterHelper.registerItem(StaticBoots);
		
		EnergizedHelmet = new EnergizedArmor("EnergizedHelmet", EnergizedMaterial, "EnergizedHelmet", EntityEquipmentSlot.HEAD).setUnlocalizedName("EnergizedHelmet");
		RegisterHelper.registerItem(EnergizedHelmet);		
		EnergizedChestplate = new EnergizedArmor("EnergizedChestplate", EnergizedMaterial, "EnergizedChestplate", EntityEquipmentSlot.CHEST).setUnlocalizedName("EnergizedChestplate");
		RegisterHelper.registerItem(EnergizedChestplate);		
		EnergizedLeggings = new EnergizedArmor("EnergizedLeggings", EnergizedMaterial, "EnergizedLeggings", EntityEquipmentSlot.LEGS).setUnlocalizedName("EnergizedLeggings");
		RegisterHelper.registerItem(EnergizedLeggings);		
		EnergizedBoots = new EnergizedArmor("EnergizedBoots", EnergizedMaterial, "EnergizedBoots", EntityEquipmentSlot.FEET).setUnlocalizedName("EnergizedBoots");
		RegisterHelper.registerItem(EnergizedBoots);
		
		//EnergizedBelt = new EnergizedBelt(baubles.api.BaubleType.BELT).setUnlocalizedName("EnergizedBelt");
		//RegisterHelper.registerItem(EnergizedBelt);		
		
		BasicCircuit = new ItemBase("BasicCircuit");
		RegisterHelper.registerItem(BasicCircuit);
		StaticCircuit = new ItemBase("StaticCircuit");
		RegisterHelper.registerItem(StaticCircuit);
		EnergizedCircuit = new ItemBase("EnergizedCircuit");
		RegisterHelper.registerItem(EnergizedCircuit);
		LumumCircuit = new ItemBase("LumumCircuit");
		RegisterHelper.registerItem(LumumCircuit);
=======
import theking530.staticpower.items.tools.ElectricSolderingIron;
import theking530.staticpower.items.tools.SolderingIron;
import theking530.staticpower.items.tools.StaticWrench;
import theking530.staticpower.items.upgrades.BasePowerUpgrade;
import theking530.staticpower.items.upgrades.BaseQuarryingUpgrade;
import theking530.staticpower.items.upgrades.BaseSpeedUpgrade;
import theking530.staticpower.items.upgrades.BaseTankUpgrade;

public class ModItems {
	
	public static ArmorMaterial StaticMaterial = EnumHelper.addArmorMaterial("StaticMaterial", null, 28, new int[] {3, 6, 6, 3}, 25, null, 0);
	public static ArmorMaterial EnergizedMaterial = EnumHelper.addArmorMaterial("EnergizedMaterial", null, 35, new int[] {5, 10, 8, 7}, 35, null, 0);
	
	public static Item Rubber;
	public static Item IOPort;
	
	public static Item BasicCircuit;
	public static Item StaticCircuit;
	public static Item EnergizedCircuit;
	public static Item LumumCircuit;
	
	public static Item BasicBattery;
	public static Item StaticBattery;
	public static Item EnergizedBattery;
	public static Item LumumBattery;
	
	public static Item BasicSpeedUpgrade;
	public static Item StaticSpeedUpgrade;
	public static Item EnergizedSpeedUpgrade;
	public static Item LumumSpeedUpgrade;
	
	public static Item BasicTankUpgrade;
	public static Item StaticTankUpgrade;
	public static Item EnergizedTankUpgrade;
	public static Item LumumTankUpgrade;
	
	public static Item BasicPowerUpgrade;
	public static Item StaticPowerUpgrade;
	public static Item EnergizedPowerUpgrade;
	public static Item LumumPowerUpgrade;
	
	public static Item StaticQuarryingUpgrade;
	public static Item EnergizedQuarryingUpgrade;
	public static Item LumumQuarryingUpgrade;
	
	public static Item CreativePowerUpgrade;
	public static Item CreativeTankUpgrade;
	public static Item CreativeSpeedUpgrade;
	
	public static Item StaticWrench;
	public static Item SolderingIron;
	public static Item ElectricSolderingIron;
	public static Item StaticBook;
	public static Item CoordinateMarker;
	
	public static Item BasicItemFilter;
	public static Item UpgradedItemFilter;
	public static Item AdvancedItemFilter;
	public static Item QuarryFilter;
	
	public static Item SilverDust;
	public static Item TinDust;
	public static Item LeadDust;
	public static Item CopperDust;
	public static Item PlatinumDust;
	public static Item IronDust;
	public static Item GoldDust;
	public static Item InertInfusionBlend;
	public static Item StaticDust;
	public static Item EnergizedDust;
	public static Item LumumDust;
	public static Item RedstoneAlloyDust;
	
	public static Item SilverIngot;
	public static Item TinIngot;
	public static Item LeadIngot;
	public static Item CopperIngot;
	public static Item PlatinumIngot;
	public static Item InertIngot;
	public static Item EnergizedIngot;
	public static Item StaticIngot;
	public static Item LumumIngot;
	public static Item RedstoneAlloyIngot;
	
	public static Item EnergizedNugget;
	public static Item StaticNugget;
	public static Item LumumNugget;
	
	public static Item StaticBelt;
	public static Item EnergizedBelt;
	public static Item StaticRing;
	public static Item EnergizedRing;
	public static Item StaticHelmet;
	public static Item StaticChestplate;
	public static Item StaticLeggings;
	public static Item StaticBoots;
	public static Item EnergizedHelmet;
	public static Item EnergizedChestplate;
	public static Item EnergizedLeggings;
	public static Item EnergizedBoots;
	
	public static Item DepletedCrop;
	public static Item EnergizedSeeds;
	public static Item EnergizedCrop;
	public static Item StaticSeeds;
	public static Item StaticCrop;
	public static Item LumumSeeds;
	public static Item LumumCrop;
	
	public static void init() {		
		
		StaticWrench = new StaticWrench().setUnlocalizedName("StaticWrench");
		RegisterHelper.registerItem(StaticWrench);
		SolderingIron = new SolderingIron("SolderingIron", 10);
		RegisterHelper.registerItem(SolderingIron);
		ElectricSolderingIron = new ElectricSolderingIron("ElectricSolderingIron", 100);
		RegisterHelper.registerItem(ElectricSolderingIron);
		CoordinateMarker = new CoordinateMarker("CoordinateMarker");
		RegisterHelper.registerItem(CoordinateMarker);
		
		BasicItemFilter = new ItemFilter("BasicItemFilter", FilterTier.BASIC);
		RegisterHelper.registerItem(BasicItemFilter);
		UpgradedItemFilter = new ItemFilter("UpgradedItemFilter", FilterTier.UPGRADED);
		RegisterHelper.registerItem(UpgradedItemFilter);
		AdvancedItemFilter = new ItemFilter("AdvancedItemFilter", FilterTier.ADVANCED);
		RegisterHelper.registerItem(AdvancedItemFilter);
		
		Rubber = new ItemBase("Rubber");
		RegisterHelper.registerItem(Rubber);
		DepletedCrop = new DepletedCrop("DepletedCrop");
		RegisterHelper.registerItem(DepletedCrop);
		IOPort = new ItemBase("IOPort");
		RegisterHelper.registerItem(IOPort);
		
		StaticHelmet = new StaticArmor("StaticHelmet", StaticMaterial, "StaticHelmet", EntityEquipmentSlot.HEAD).setUnlocalizedName("StaticHelmet");
		RegisterHelper.registerItem(StaticHelmet);	
		StaticChestplate = new StaticArmor("StaticChestplate", StaticMaterial, "StaticChestplate", EntityEquipmentSlot.CHEST).setUnlocalizedName("StaticChestplate");
		RegisterHelper.registerItem(StaticChestplate);		
		StaticLeggings = new StaticArmor("StaticLeggings", StaticMaterial, "StaticLeggings", EntityEquipmentSlot.LEGS).setUnlocalizedName("StaticLeggings");
		RegisterHelper.registerItem(StaticLeggings);		
		StaticBoots = new StaticArmor("StaticBoots", StaticMaterial, "StaticBoots", EntityEquipmentSlot.FEET).setUnlocalizedName("StaticBoots");
		RegisterHelper.registerItem(StaticBoots);
		
		EnergizedHelmet = new EnergizedArmor("EnergizedHelmet", EnergizedMaterial, "EnergizedHelmet", EntityEquipmentSlot.HEAD).setUnlocalizedName("EnergizedHelmet");
		RegisterHelper.registerItem(EnergizedHelmet);		
		EnergizedChestplate = new EnergizedArmor("EnergizedChestplate", EnergizedMaterial, "EnergizedChestplate", EntityEquipmentSlot.CHEST).setUnlocalizedName("EnergizedChestplate");
		RegisterHelper.registerItem(EnergizedChestplate);		
		EnergizedLeggings = new EnergizedArmor("EnergizedLeggings", EnergizedMaterial, "EnergizedLeggings", EntityEquipmentSlot.LEGS).setUnlocalizedName("EnergizedLeggings");
		RegisterHelper.registerItem(EnergizedLeggings);		
		EnergizedBoots = new EnergizedArmor("EnergizedBoots", EnergizedMaterial, "EnergizedBoots", EntityEquipmentSlot.FEET).setUnlocalizedName("EnergizedBoots");
		RegisterHelper.registerItem(EnergizedBoots);
		
		//EnergizedBelt = new EnergizedBelt(baubles.api.BaubleType.BELT).setUnlocalizedName("EnergizedBelt");
		//RegisterHelper.registerItem(EnergizedBelt);		
		
		BasicCircuit = new ItemBase("BasicCircuit");
		RegisterHelper.registerItem(BasicCircuit);
		StaticCircuit = new ItemBase("StaticCircuit");
		RegisterHelper.registerItem(StaticCircuit);
		EnergizedCircuit = new ItemBase("EnergizedCircuit");
		RegisterHelper.registerItem(EnergizedCircuit);
		LumumCircuit = new ItemBase("LumumCircuit");
		RegisterHelper.registerItem(LumumCircuit);
		
		BasicBattery = new BaseBattery("BasicPortableBattery", 100000, 1000);
		RegisterHelper.registerItem(BasicBattery);
		StaticBattery = new BaseBattery("StaticPortableBattery", 250000, 2500);
		RegisterHelper.registerItem(StaticBattery);
		EnergizedBattery = new BaseBattery("EnergizedPortableBattery", 500000, 5000);
		RegisterHelper.registerItem(EnergizedBattery);
		LumumBattery = new BaseBattery("LumumPortableBattery", 1000000, 10000);
		RegisterHelper.registerItem(LumumBattery);
>>>>>>> branch '1.10.2' of https://github.com/Theking5301/StaticPower.git
		
		CreativeSpeedUpgrade = new BaseSpeedUpgrade("CreativeSpeedUpgrade", Tier.CREATIVE);
		RegisterHelper.registerItem(CreativeSpeedUpgrade);	
		/**
		CreativeTankUpgrade = new BaseTankUpgrade("CreativeTankUpgrade", Tier.CREATIVE);
		RegisterHelper.registerItem(CreativeTankUpgrade);	
		CreativeSpeedUpgrade = new BasePowerUpgrade("CreativeSpeedUpgrade", Tier.CREATIVE);
		RegisterHelper.registerItem(CreativeSpeedUpgrade);
		*/
		
		BasicSpeedUpgrade = new BaseSpeedUpgrade("BasicSpeedUpgrade", Tier.BASE);
		RegisterHelper.registerItem(BasicSpeedUpgrade);	
		StaticSpeedUpgrade = new BaseSpeedUpgrade("StaticSpeedUpgrade", Tier.STATIC);
		RegisterHelper.registerItem(StaticSpeedUpgrade);	
		EnergizedSpeedUpgrade = new BaseSpeedUpgrade("EnergizedSpeedUpgrade", Tier.ENERGIZED);
		RegisterHelper.registerItem(EnergizedSpeedUpgrade);	
		LumumSpeedUpgrade = new BaseSpeedUpgrade("LumumSpeedUpgrade", Tier.LUMUM);
		RegisterHelper.registerItem(LumumSpeedUpgrade);	
		
		BasicTankUpgrade = new BaseTankUpgrade("BasicTankUpgrade", Tier.BASE);
		RegisterHelper.registerItem(BasicTankUpgrade);	
		StaticTankUpgrade = new BaseTankUpgrade("StaticTankUpgrade", Tier.STATIC);
		RegisterHelper.registerItem(StaticTankUpgrade);	
		EnergizedTankUpgrade = new BaseTankUpgrade("EnergizedTankUpgrade", Tier.ENERGIZED);
		RegisterHelper.registerItem(EnergizedTankUpgrade);	
		LumumTankUpgrade = new BaseTankUpgrade("LumumTankUpgrade", Tier.LUMUM);
		RegisterHelper.registerItem(LumumTankUpgrade);	
		
		BasicPowerUpgrade = new BasePowerUpgrade("BasicPowerUpgrade", Tier.BASE);
		RegisterHelper.registerItem(BasicPowerUpgrade);
		StaticPowerUpgrade = new BasePowerUpgrade("StaticPowerUpgrade", Tier.STATIC);
		RegisterHelper.registerItem(StaticPowerUpgrade);
		EnergizedPowerUpgrade = new BasePowerUpgrade("EnergizedPowerUpgrade", Tier.ENERGIZED);
		RegisterHelper.registerItem(EnergizedPowerUpgrade);
		LumumPowerUpgrade = new BasePowerUpgrade("LumumPowerUpgrade", Tier.LUMUM);
		RegisterHelper.registerItem(LumumPowerUpgrade);
		
		StaticQuarryingUpgrade = new BaseQuarryingUpgrade("StaticQuarryingUpgrade", Tier.STATIC);
		RegisterHelper.registerItem(StaticQuarryingUpgrade);	
		EnergizedQuarryingUpgrade = new BaseQuarryingUpgrade("EnergizedQuarryingUpgrade", Tier.ENERGIZED);
		RegisterHelper.registerItem(EnergizedQuarryingUpgrade);	
		LumumQuarryingUpgrade = new BaseQuarryingUpgrade("LumumQuarryingUpgrade", Tier.LUMUM);
		RegisterHelper.registerItem(LumumQuarryingUpgrade);	
		
		StaticSeeds = new StaticSeeds(ModBlocks.StaticCropPlant, Blocks.FARMLAND).setUnlocalizedName("StaticSeeds");
		RegisterHelper.registerItem(StaticSeeds);	
		MinecraftForge.addGrassSeed(new ItemStack(StaticSeeds), 20);		
		EnergizedSeeds = new EnergizedSeeds(ModBlocks.EnergizedCropPlant, Blocks.FARMLAND).setUnlocalizedName("EnergizedSeeds");
		RegisterHelper.registerItem(EnergizedSeeds);			
		LumumSeeds = new LumumSeeds(ModBlocks.LumumCropPlant, Blocks.FARMLAND).setUnlocalizedName("LumumSeeds");
		RegisterHelper.registerItem(LumumSeeds);	
		
		StaticCrop = new StaticCrop().setUnlocalizedName("StaticCrop");
		RegisterHelper.registerItem(StaticCrop);			
		EnergizedCrop = new EnergizedCrop().setUnlocalizedName("EnergizedCrop");
		RegisterHelper.registerItem(EnergizedCrop);			
		LumumCrop = new LumumCrop().setUnlocalizedName("LumumCrop");
		registerItem(LumumCrop);	

		StaticBook = new StaticPowerBook("StaticBook");
		registerItem(StaticBook);	
		
		GameRegistry.register(StaticIngot = new BaseIngot("StaticIngot"));
		GameRegistry.register(EnergizedIngot = new BaseIngot("EnergizedIngot"));
		GameRegistry.register(LumumIngot = new BaseIngot("LumumIngot"));
		GameRegistry.register(SilverIngot = new BaseIngot("SilverIngot"));
		GameRegistry.register(TinIngot = new BaseIngot("TinIngot"));
		GameRegistry.register(LeadIngot = new BaseIngot("LeadIngot"));
		GameRegistry.register(CopperIngot = new BaseIngot("CopperIngot"));
		GameRegistry.register(PlatinumIngot = new BaseIngot("PlatinumIngot"));
		GameRegistry.register(InertIngot = new BaseIngot("InertIngot"));
		GameRegistry.register(RedstoneAlloyIngot = new BaseIngot("RedstoneAlloyIngot"));
		OreDictionary.registerOre("ingotSilver", new ItemStack(SilverIngot));
		OreDictionary.registerOre("ingotTin", new ItemStack(TinIngot));
		OreDictionary.registerOre("ingotLead", new ItemStack(LeadIngot));
		OreDictionary.registerOre("ingotCopper", new ItemStack(CopperIngot));
		OreDictionary.registerOre("ingotPlatinum", new ItemStack(PlatinumIngot));
		
		GameRegistry.register(StaticNugget = new BaseNugget("StaticNugget"));
		GameRegistry.register(EnergizedNugget = new BaseNugget("EnergizedNugget"));
		GameRegistry.register(LumumNugget = new BaseNugget("LumumNugget"));
		
		GameRegistry.register(SilverDust = new BaseDust("SilverDust"));
		GameRegistry.register(TinDust = new BaseDust("TinDust"));
		GameRegistry.register(LeadDust = new BaseDust("LeadDust"));
		GameRegistry.register(CopperDust = new BaseDust("CopperDust"));
		GameRegistry.register(PlatinumDust = new BaseDust("PlatinumDust"));
		GameRegistry.register(IronDust = new BaseDust("IronDust"));
		GameRegistry.register(GoldDust = new BaseDust("GoldDust"));
		GameRegistry.register(InertInfusionBlend = new BaseDust("InertInfusionBlend"));
		GameRegistry.register(StaticDust = new BaseDust("StaticDust"));
		GameRegistry.register(EnergizedDust = new BaseDust("EnergizedDust"));
		GameRegistry.register(LumumDust = new BaseDust("LumumDust"));
		GameRegistry.register(RedstoneAlloyDust = new BaseDust("RedstoneAlloyDust"));
		OreDictionary.registerOre("dustSilver", new ItemStack(SilverDust));
		OreDictionary.registerOre("dustTin", new ItemStack(TinDust));
		OreDictionary.registerOre("dustLead", new ItemStack(LeadDust));
		OreDictionary.registerOre("dustCopper", new ItemStack(CopperDust));
		OreDictionary.registerOre("dustPlatinum", new ItemStack(PlatinumDust));
		OreDictionary.registerOre("dustIron", new ItemStack(IronDust));
		OreDictionary.registerOre("dustGold", new ItemStack(GoldDust));
	}

}