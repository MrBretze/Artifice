package shukaro.artifice.event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import shukaro.artifice.net.PacketDispatcher;

public class ArtificeClientTickHandler
{
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void keyTicker(TickEvent.ClientTickEvent cte)
    {
        if (cte.phase != TickEvent.Phase.START) return;
        final Minecraft mc = Minecraft.getMinecraft();
        if (mc.thePlayer == null)
            return;
        Integer playerID = mc.thePlayer.getEntityId();
        if (Keyboard.isKeyDown(mc.gameSettings.keyBindSneak.getKeyCode()) && !Tracking.sneaks.contains(playerID))
        {
            Tracking.sneaks.add(playerID);
            PacketDispatcher.sendSneakEvent(playerID);
        }
        else if (!Keyboard.isKeyDown(mc.gameSettings.keyBindSneak.getKeyCode()) && Tracking.sneaks.contains(playerID))
        {
            Tracking.sneaks.remove(playerID);
            PacketDispatcher.sendSneakEvent(playerID);
        }
    }
}
