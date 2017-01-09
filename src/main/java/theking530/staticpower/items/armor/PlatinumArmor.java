package theking530.staticpower.items.armor;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.potion.PotionEffect;
import theking530.staticpower.items.EquipmentMaterial;
import theking530.staticpower.utils.EnumTextFormatting;

public class PlatinumArmor extends BaseArmor {

	public PlatinumArmor(String name, ArmorType type, EquipmentMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
		super(name, type, materialIn, equipmentSlotIn);
	}
	
	@Override
	public List getSetInfo() {
		List tempList = new ArrayList();
		tempList.add("Pay a Bodyguard: " + EnumTextFormatting.RED + "Unable to Melee Attack");
		tempList.add("Spoon Fed: " + EnumTextFormatting.DARK_AQUA + "Who Needs Food?");
		return tempList;
	}
	@Override
	public String getTagline() {
		return "Too Rich for You";
	}
	@Override
	public PotionEffect[] getEffects() {
		return new PotionEffect[]{new PotionEffect(MobEffects.SATURATION, 2, 0), new PotionEffect(MobEffects.WEAKNESS, 4, 10)};
	}
}