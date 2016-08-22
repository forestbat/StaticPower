package theking530.staticpower.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import theking530.staticpower.StaticPower;

public class StaticSeeds extends CropSeeds {

    @SuppressWarnings("static-access")
    public StaticSeeds(Block blockCrop, Block blockSoil) {
        super("StaticSeeds", blockCrop, blockSoil);
    }
    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
    	list.add("These Seeds Radiate with");
    	list.add("a Strange Energy...");
    }
}