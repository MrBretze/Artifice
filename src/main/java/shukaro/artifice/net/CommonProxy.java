package shukaro.artifice.net;

import net.minecraftforge.fml.common.network.FMLEmbeddedChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import shukaro.artifice.ArtificeCore;
import shukaro.artifice.gui.GuiHandlerArtifice;
import shukaro.artifice.net.handlers.SneakMessageHandler;

import java.util.EnumMap;

public class CommonProxy
{
    public static EnumMap<Side, FMLEmbeddedChannel> artificeChannel;

    public void init()
    {
        artificeChannel = NetworkRegistry.INSTANCE.newChannel(ArtificeCore.modChannel, new ArtificeMessageToMessageCodec(),
                new SneakMessageHandler());

        NetworkRegistry.INSTANCE.registerGuiHandler(ArtificeCore.instance, new GuiHandlerArtifice());
    }
}
