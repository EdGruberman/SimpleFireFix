package edgruberman.bukkit.simplefirefix;

import org.bukkit.event.Event;

import edgruberman.bukkit.simplefirefix.MessageManager.MessageLevel;

public class Main extends org.bukkit.plugin.java.JavaPlugin {
    
    private final String DEFAULT_LOG_LEVEL = "INFO";

    public static MessageManager messageManager = null;
    
    public void onEnable() {
        Main.messageManager = new MessageManager(this);
        Main.messageManager.log("Version " + this.getDescription().getVersion());
        
        Configuration.load(this);
        
        Main.messageManager.setLogLevel(MessageLevel.parse(this.getConfiguration().getString("logLevel", this.DEFAULT_LOG_LEVEL)));
        
        this.getServer().getPluginManager()
            .registerEvent(Event.Type.BLOCK_IGNITE, new BlockListener(), Event.Priority.Normal, this);
        
        this.getServer().getPluginManager()
            .registerEvent(Event.Type.BLOCK_BURN,   new BlockListener(), Event.Priority.Normal, this);

        Main.messageManager.log("Plugin Enabled");
    }
    
    public void onDisable() {
        //TODO Unregister listeners when Bukkit supports it.
                
        Main.messageManager.log("Plugin Disabled");
        Main.messageManager = null;
    }
}
