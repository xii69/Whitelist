package me.xii69.whitelist.utils;

import me.xii69.whitelist.Main;
import org.bukkit.ChatColor;

import java.util.List;

public class Utils {

    public static String colorize(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static boolean isTrue(String path) {
        return Main.getInstance().getConfig().getBoolean(path);
    }

    public static void setBoolean(String path, boolean bool) {
        Main.getInstance().getConfig().set(path, bool);
    }

    public static List<String> getStringList(String path) {
        return Main.getInstance().getConfig().getStringList(path);
    }

    public static List<String> getWhitelistedPlayers() {
        return getStringList("players");
    }

    public static boolean addPlayer(String username) {
        if (!getStringList("players").contains(username)) {
            List<String> players = getStringList("players");
            players.add(username);
            Main.getInstance().getConfig().set("players", players);
            Main.getInstance().saveConfig();
            return true;
        } else {
            return false;
        }
    }

    public static boolean removePlayer(String username) {
        if (getStringList("players").contains(username)) {
            List<String> players = getStringList("players");
            players.remove(username);
            Main.getInstance().getConfig().set("players", players);
            Main.getInstance().saveConfig();
            return true;
        } else {
            return false;
        }
    }

}
