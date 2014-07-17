package shukaro.artifice.net;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import shukaro.artifice.ArtificeCore;

import java.io.IOException;

public class ServerPacketHandler extends MessageHandlerBase
{
    @Override
    public void onMessage(Packet packet, INetHandler handler, EntityPlayer player,
                          int command) throws IOException
    {
        switch (command)
        {
            case Packets.SNEAKEVENT:
            {
                ArtificeCore.logger.info("got sneak packet");
                int entityId = packet.readInt();
                boolean doAdd = packet.readByte() != 0;
                if (doAdd)
                {
                    PlayerTracking.sneaks.add(entityId);
                }
                else
                {
                    PlayerTracking.sneaks.remove(Integer.valueOf(entityId));
                }
            } return;
        }
    }
}
