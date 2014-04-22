package net.alpenblock.bungeeperms.bukkit.bridge.bridges.vault;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;

import net.alpenblock.bungeeperms.bukkit.BungeePerms;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;

public class Chat_BungeePermsBukkit extends Chat{
    private static final Logger log = Logger.getLogger("Minecraft");
    
	private final String name = "BungeePermsBukkit";
	private Plugin plugin = null;
    private BungeePerms chat = null;

    public Chat_BungeePermsBukkit(Plugin plugin, Permission perms) {
        super(perms);
        this.plugin = plugin;

        Bukkit.getServer().getPluginManager().registerEvents(new PermissionServerListener(this), plugin);

        // Load Plugin in case it was loaded before
        if (chat == null) {
            Plugin p = plugin.getServer().getPluginManager().getPlugin("BungeePermsBukkit");
            if (p != null) {
                if (p.isEnabled()) {
                    chat = (BungeePerms) p;
                    log.info(String.format("[%s][Chat] %s hooked.", plugin.getDescription().getName(), name));
                }
            }
        }
    }

    public class PermissionServerListener implements Listener {
    	Chat_BungeePermsBukkit chat = null;

        public PermissionServerListener(Chat_BungeePermsBukkit chat) {
            this.chat = chat;
        }

        @EventHandler(priority = EventPriority.MONITOR)
        public void onPluginEnable(PluginEnableEvent event) {
            if (chat.chat == null) {
                Plugin perms = event.getPlugin();

                if (perms.getDescription().getName().equals("BungeePermsBukkit")) {
                    if (perms.isEnabled()) {
                        chat.chat = (BungeePerms) perms;
                        log.info(String.format("[%s][Chat] %s hooked.", plugin.getDescription().getName(), chat.name));
                    }
                }
            }
        }

        @EventHandler(priority = EventPriority.MONITOR)
        public void onPluginDisable(PluginDisableEvent event) {
            if (chat.chat != null) {
                if (event.getPlugin().getDescription().getName().equals("BungeePermsBukkit")) {
                    chat.chat = null;
                    log.info(String.format("[%s][Chat] %s un-hooked.", plugin.getDescription().getName(), chat.name));
                }
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isEnabled() {
        if (chat == null)
            return false;
        else
            return chat.isEnabled();
    }

    @Override
    public int getPlayerInfoInteger(String world, String playerName, String node, int defaultValue) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public double getPlayerInfoDouble(String world, String playerName, String node, double defaultValue) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public boolean getPlayerInfoBoolean(String world, String playerName, String node, boolean defaultValue) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public String getPlayerInfoString(String world, String playerName, String node, String defaultValue) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public void setPlayerInfoInteger(String world, String playerName, String node, int value) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public void setPlayerInfoDouble(String world, String playerName, String node, double value) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public void setPlayerInfoBoolean(String world, String playerName, String node, boolean value) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public void setPlayerInfoString(String world, String playerName, String node, String value) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public int getGroupInfoInteger(String world, String groupName, String node, int defaultValue) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public void setGroupInfoInteger(String world, String groupName, String node, int value) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public double getGroupInfoDouble(String world, String groupName, String node, double defaultValue) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public void setGroupInfoDouble(String world, String groupName, String node, double value) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public boolean getGroupInfoBoolean(String world, String groupName, String node, boolean defaultValue) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public void setGroupInfoBoolean(String world, String groupName, String node, boolean value) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public String getGroupInfoString(String world, String groupName, String node, String defaultValue) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public void setGroupInfoString(String world, String groupName, String node, String value) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public String getPlayerPrefix(String world, String playerName) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public String getPlayerSuffix(String world, String playerName) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public void setPlayerSuffix(String world, String player, String suffix) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public void setPlayerPrefix(String world, String player, String prefix) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public String getGroupPrefix(String world, String group) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public void setGroupPrefix(String world, String group, String prefix) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");

    }

    @Override
    public String getGroupSuffix(String world, String group) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }

    @Override
    public void setGroupSuffix(String world, String group, String suffix) {
    	throw new UnsupportedOperationException("BungeePerms info operations are not supported");
    }
}
