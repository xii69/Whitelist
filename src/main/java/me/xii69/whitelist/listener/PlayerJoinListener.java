package me.xii69.whitelist.listener;

import me.xii69.whitelist.Main;
import me.xii69.whitelist.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(AsyncPlayerPreLoginEvent event) {
        if (Main.getStatus()) {
            if (!Utils.getWhitelistedPlayers().contains(event.getName())) {
                event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_WHITELIST, Utils.colorize("&cShoma Whitelist Nistid!"));
            }
        }
    }

}
