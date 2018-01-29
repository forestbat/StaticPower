package theking530.staticpower.client.gui.widgets.tabs;

import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import theking530.staticpower.machines.BaseMachine;
  
public class PacketPowerControlTab implements IMessage{
    private int MAX_POWER_THRESHOLD;
    private int MIN_POWER_THRESHOLD;
    private int x;
    private int y;
    private int z;

    public PacketPowerControlTab() {}
    
    public PacketPowerControlTab(int MAX_POWER_THRESHOLD, int MIN_POWER_THRESHOLD, BlockPos pos) {
      this.MAX_POWER_THRESHOLD = MAX_POWER_THRESHOLD;
      this.MIN_POWER_THRESHOLD = MIN_POWER_THRESHOLD;
      this.x = pos.getX();
      this.y = pos.getY();
      this.z = pos.getY();
    }
    
    @Override
    public void fromBytes(ByteBuf buf) {
      // the order is important
      this.MAX_POWER_THRESHOLD = buf.readInt();
      this.MIN_POWER_THRESHOLD = buf.readInt();
      this.x = buf.readInt();
      this.y = buf.readInt();
      this.z = buf.readInt();
    }
    
    @Override
    public void toBytes(ByteBuf buf) {
      buf.writeInt(MAX_POWER_THRESHOLD);
      buf.writeInt(MIN_POWER_THRESHOLD);
      buf.writeInt(x);
      buf.writeInt(y);
      buf.writeInt(z);
    }
    public static class Message implements IMessageHandler<PacketPowerControlTab, IMessage> {
    @Override
    public IMessage onMessage(PacketPowerControlTab message, MessageContext ctx) {
    		TileEntity te = ctx.getServerHandler().player.getEntityWorld().getTileEntity(new BlockPos(message.x, message.y, message.z));
    		if(te != null && te instanceof BaseMachine) {
    			BaseMachine entity = (BaseMachine)te;
    			entity.minPowerThreshold = message.MIN_POWER_THRESHOLD;
    			entity.maxPowerThreshold = message.MAX_POWER_THRESHOLD;
    		}
		return null;
    	}
    }
}
