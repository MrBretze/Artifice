package shukaro.artifice.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraftforge.fml.common.network.FMLIndexedMessageToMessageCodec;
import shukaro.artifice.net.packets.ArtificePacket;
import shukaro.artifice.net.packets.ArtificePacketSneak;

public class ArtificeMessageToMessageCodec extends FMLIndexedMessageToMessageCodec<ArtificePacket>
{
    public static final int SNEAKEVENT = 1;

    public ArtificeMessageToMessageCodec()
    {
        addDiscriminator(SNEAKEVENT, ArtificePacketSneak.class);
    }

    @Override
    public void encodeInto(ChannelHandlerContext ctx, ArtificePacket msg, ByteBuf target) throws Exception
    {
        msg.writeBytes(target);
    }

    @Override
    public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, ArtificePacket msg)
    {
        msg.readBytes(source);
    }
}
