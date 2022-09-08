package me.xii69.whitelist.command;

import me.xii69.whitelist.Main;
import me.xii69.whitelist.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WhitelistCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(Utils.colorize("&cToo few arguments."));
            return true;
        }

        switch (args[0]) {
            case "on":
                if (!Main.getStatus()) {
                    sender.sendMessage(Utils.colorize("&bWhitelist has been turned &aon"));
                    Main.setStatus(true);
                } else {
                    sender.sendMessage(Utils.colorize("&bWhitelist has been turned &aon &balready."));
                }
                return true;
            case "off":
                if (Main.getStatus()) {
                    sender.sendMessage(Utils.colorize("&bWhitelist has been turned &coff"));
                    Main.setStatus(false);
                } else {
                    sender.sendMessage(Utils.colorize("&bWhitelist has been turned &coff &balready."));
                }
                return true;
            case "add":
                if (args.length < 2) {
                    sender.sendMessage(Utils.colorize("&cEnter a valid player username."));
                    return true;
                }
                if (Utils.addPlayer(args[1])) {
                    sender.sendMessage(Utils.colorize("&e" + args[1] + " &bhas been &aadded &bto whitelist."));
                } else {
                    sender.sendMessage(Utils.colorize("&cThis player is already whitelisted."));
                }
                return true;
            case "remove":
                if (args.length < 2) {
                    sender.sendMessage(Utils.colorize("&cEnter a valid player username."));
                    return true;
                }
                if (Utils.removePlayer(args[1])) {
                    sender.sendMessage(Utils.colorize("&e" + args[1] + " &bhas been &cremoved &bfrom whitelist."));
                } else {
                    sender.sendMessage(Utils.colorize("&cThis player is not whitelisted."));
                }
                return true;
            case "clear":
                Main.getInstance().getConfig().set("players", null);
                Main.getInstance().saveConfig();
                sender.sendMessage(Utils.colorize("&bWhitelist has been cleared."));
                return true;
            case "list":
                String usernames = "&bWhitelisted players&7:";
                if (Utils.getWhitelistedPlayers().isEmpty()) {
                    sender.sendMessage(Utils.colorize("&bThere is no whitelisted players."));
                    return true;
                }
                for (String name : Utils.getWhitelistedPlayers()) {
                    usernames = usernames + (" &e" + name + "&7,");
                }
                sender.sendMessage(Utils.colorize(usernames).substring(0, usernames.length() - 1));
                return true;
        }

        sender.sendMessage(Utils.colorize("&cUnknown arguments."));

        return false;

    }

}
