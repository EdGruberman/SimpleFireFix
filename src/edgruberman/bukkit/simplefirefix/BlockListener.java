package edgruberman.bukkit.simplefirefix;

import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;

import edgruberman.bukkit.simplefirefix.MessageManager.MessageLevel;

public class BlockListener extends org.bukkit.event.block.BlockListener {
    
    public BlockListener() {}
    
    @Override
    public void onBlockIgnite(BlockIgniteEvent event) {
        if (event.isCancelled()) return;
        
        if (!event.getBlock().getWorld().hasStorm()) return;
        
        Main.messageManager.log(MessageLevel.FINE,
                "Cancelling fire ignition during storm in"
                + " \"" + event.getBlock().getWorld().getName() + "\" at"
                + " X:" + event.getBlock().getX()
                + " Y:" + event.getBlock().getY()
                + " Z:" + event.getBlock().getZ()
        );
        
        event.setCancelled(true);
    }
    
    @Override
    public void onBlockBurn(BlockBurnEvent event) {
        if (event.isCancelled()) return;
        
        if (!event.getBlock().getWorld().hasStorm()) return;
        
        Main.messageManager.log(MessageLevel.FINE,
                "Cancelling fire burn during storm in"
                + " \"" + event.getBlock().getWorld().getName() + "\" at"
                + " X:" + event.getBlock().getX()
                + " Y:" + event.getBlock().getY()
                + " Z:" + event.getBlock().getZ()
        );
        
        event.setCancelled(true);


    }
}