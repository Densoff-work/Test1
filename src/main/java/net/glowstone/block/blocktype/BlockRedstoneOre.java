package net.glowstone.block.blocktype;

import net.glowstone.EventFactory;
import net.glowstone.block.GlowBlock;
import net.glowstone.block.GlowBlockState;
import net.glowstone.block.data.SimpleBlockData;
import net.glowstone.entity.GlowPlayer;
import net.glowstone.inventory.ToolType;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.util.Vector;

public class BlockRedstoneOre extends BlockRandomDrops {

    public BlockRedstoneOre() {
        super(Material.REDSTONE, 0, 3, 4, ToolType.IRON_PICKAXE);
    }

    @Override
    public boolean blockInteract(GlowPlayer player, GlowBlock block, BlockFace face,
        Vector clickedLoc) {
        // TODO: 1.13 glowing
        EntityChangeBlockEvent changeBlockEvent = new EntityChangeBlockEvent(player, block,
            new SimpleBlockData(Material.REDSTONE_ORE));
        EventFactory.getInstance().callEvent(changeBlockEvent);
        if (!changeBlockEvent.isCancelled()) {
            GlowBlockState state = block.getState();
            state.setType(Material.REDSTONE_ORE);
            state.update(true);
        }
        return false;
    }
}
