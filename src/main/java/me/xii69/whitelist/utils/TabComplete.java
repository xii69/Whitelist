package me.xii69.whitelist.utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {

    List<String> arguments = new ArrayList<>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        arguments.add("on");
        arguments.add("off");
        arguments.add("add");
        arguments.add("remove");
        arguments.add("clear");
        arguments.add("list");

        if (args.length == 1) {
            return arguments;
        }

        return null;

    }

}
