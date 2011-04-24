package edgruberman.bukkit.simplefirefix;

import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;

import edgruberman.bukkit.simplefirefix.MessageManager.MessageLevel;

public class BlockListener extends org.bukkit.event.block.BlockListener {
    
    public BlockListener() {}
    
    @Override
    public void onBlockIgnite(BlockIgniteEvent event) {
        if (event.isCancelled()) return;
        
        if (!event.getCause().equals(IgniteCause.LIGHTNING)) return;
        
        Main.messageManager.log(MessageLevel.FINE,
                "Cancelling fire ignition from lightning in"
                + " \"" + event.getBlock().getWorld().getName() + "\" at"
                + " X:" + event.getBlock().getX()
                + " Y:" + event.getBlock().getY()
                + " Z:" + event.getBlock().getZ()
        );
        
        event.setCancelled(true);
    }
}