package theking530.staticpower.items.tools;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import theking530.staticpower.StaticPower;
import theking530.staticpower.items.ItemBase;
import theking530.staticpower.utils.EnumTextFormatting;

public class SolderingIron extends ItemBase implements ISolderingIron{
	
	public SolderingIron(String name, int maxUses) {
		super(name);
		setMaxStackSize(1);
		setMaxDamage(maxUses);
		setNoRepair();
	}

	@Override  
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4) {
	    	if(showHiddenTooltips()) {
	    		list.add("Max Uses: " + getMaxDamage());
	    		list.add("Uses Remaining: " + (getMaxDamage() - getDamage(itemstack)));
	    	}else{
	    		list.add(EnumTextFormatting.ITALIC + "Hold Shift");
	    }
	}

	@Override
	public boolean useSolderingItem(ItemStack stack) {
		stack.setItemDamage(stack.getItemDamage() + 1);
		if(stack.getItemDamage() >= stack.getMaxDamage()) {
			return true;
		}
		return false;
	}
	@Override
	public boolean canSolder(ItemStack solderingIron) {
		if(solderingIron.getItemDamage() < solderingIron.getMaxDamage()) {
			return true;
		}
		return false;
	}
}
