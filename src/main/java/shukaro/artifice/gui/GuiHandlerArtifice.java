package shukaro.artifice.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerArtifice implements IGuiHandler
{
    public static final int craftKitID = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == craftKitID)
            return new ContainerCraftkit(player.inventory, world, new BlockPos(x, y, z));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == craftKitID)
            return new GuiCraftKit(player.inventory, world, new BlockPos(x, y, z));
        return null;
    }
}
