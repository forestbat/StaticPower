package theking530.staticpower.items.tools;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import theking530.staticpower.items.ItemBase;
import theking530.staticpower.utils.EnumTextFormatting;

public class WireCutters extends ItemBase {

	public WireCutters() {
		super("WireCutters");
		setMaxDamage(35);
		setMaxStackSize(1);
	}
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		if(repair.getItem() == Items.IRON_INGOT) {
			return true;
		}
		return false;
	}
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
	    itemStack.setItemDamage(itemStack.getItemDamage() + 1);
	    return itemStack;     	
	}
	@Override
	public boolean hasContainerItem(){
		return true;
	}
	@Override  
		public void addInformation(ItemStack itemstack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
	    	if(showHiddenTooltips()) {
	    		list.add("Max Uses: " + getMaxDamage(itemstack));
	    		list.add("Uses Remaining: " + (getMaxDamage(itemstack) - getDamage(itemstack)));
	    	}else{
	    		list.add(EnumTextFormatting.ITALIC + "Hold Shift");
	    }
	}
}
