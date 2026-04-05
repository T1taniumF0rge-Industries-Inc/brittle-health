package com.titan1um.oneheart;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public final class OneHeartCommand implements CommandExecutor {

    private final OneHeartPlugin plugin;

    public OneHeartCommand(OneHeartPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.isOp()) {
            sender.sendMessage("§cYou must be OP to use this command.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage("§eUsage: /oneheart <on|off>");
            return true;
        }

        if (args[0].equalsIgnoreCase("on")) {
            plugin.setEnabledState(true);
            sender.sendMessage("§aOneHeart enabled.");
            return true;
        }

        if (args[0].equalsIgnoreCase("off")) {
            plugin.setEnabledState(false);
            sender.sendMessage("§cOneHeart disabled.");
            return true;
        }

        sender.sendMessage("§eUsage: /oneheart <on|off>");
        return true;
    }
}
