package me.xii69.whitelist;

import me.xii69.whitelist.command.WhitelistCommand;
import me.xii69.whitelist.listener.PlayerJoinListener;
import me.xii69.whitelist.utils.TabComplete;
import me.xii69.whitelist.utils.Utils;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Plugin plugin;
    private static boolean status;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        status = Utils.isTrue("whitelist");
        getCommand("wl").setExecutor(new WhitelistCommand());
        getCommand("whitelist").setExecutor(new WhitelistCommand());
        getCommand("wl").setTabCompleter(new TabComplete());
        getCommand("whitelist").setTabCompleter(new TabComplete());
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        plugin = null;
    }

    public static boolean getStatus() {
        return status;
    }

    public static void setStatus(boolean bool) {
        status = bool;
        Utils.setBoolean("whitelist", bool);
        Main.getInstance().saveConfig();
    }

    public static Plugin getInstance() {
        return plugin;
    }

}
