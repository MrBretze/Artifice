package shukaro.artifice.net;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import shukaro.artifice.ArtificeConfig;
import shukaro.artifice.event.ArtificeClientTickHandler;
import shukaro.artifice.render.FrameRenderer;
import shukaro.artifice.render.LotusRenderer;
import shukaro.artifice.render.OreRenderer;
import shukaro.artifice.render.connectedtexture.CTMRenderer;

public class ClientProxy extends CommonProxy
{
    public static int renderPass;

    public void init()
    {
        super.init();
        MinecraftForge.EVENT_BUS.register(new ArtificeClientEventHandler());
        FMLCommonHandler.instance().bus().register(new ArtificeClientTickHandler());

        ArtificeConfig.lotusRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(ArtificeConfig.lotusRenderID, new LotusRenderer());
        ArtificeConfig.frameRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(ArtificeConfig.frameRenderID, new FrameRenderer());
        ArtificeConfig.oreRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(ArtificeConfig.oreRenderID, new OreRenderer());
        ArtificeConfig.ctmRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(ArtificeConfig.ctmRenderID, new CTMRenderer());
    }
}
