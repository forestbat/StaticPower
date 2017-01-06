package theking530.staticpower.items.tools.basictools;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import theking530.staticpower.StaticPower;
import theking530.staticpower.items.EquipmentMaterial;
import theking530.staticpower.utils.EnumTextFormatting;


public class BaseShovel extends ItemSpade {

	public String NAME = "";
	public EquipmentMaterial MATERIAL;
	
	public BaseShovel(EquipmentMaterial material, String unlocalizedName) {
		super(material.getToolMaterial());
		NAME= unlocalizedName;
		setUnlocalizedName(unlocalizedName);
		setRegistryName(unlocalizedName);
		setCreativeTab(StaticPower.StaticPower);
		MATERIAL = material;
	}
	
	@Override  
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4) {
    	if(showHiddenTooltips()) {
    		String tempLevel = "Mining Level: " +  MATERIAL.getToolMaterial().getHarvestLevel();
    		String tempSpeed = "Speed: " +  MATERIAL.getToolMaterial().getEfficiencyOnProperMaterial();
    		String tempDamage = "Damage: " + (Math.round(MATERIAL.getToolMaterial().getDamageVsEntity()) + 2.5F); 
    		String tempDurability = "Durability: " + (MATERIAL.getToolMaterial().getMaxUses()-itemstack.getMetadata()) + "/" + MATERIAL.getToolMaterial().getMaxUses();
    		
    		list.add(tempLevel);
    		list.add(tempSpeed);
    		list.add(tempDurability);
    		list.add(tempDamage);
    	}else{
    		list.add(EnumTextFormatting.ITALIC + "Hold Shift");
	    }
	}
	public boolean showHiddenTooltips() {
		return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
	}
}