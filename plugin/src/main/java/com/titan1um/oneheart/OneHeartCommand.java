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
            sender.sendMessage("§c[One Heart] You are not an operator and therefore cannot change the settings of One Heart!");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage("§e[One Heart] Usage: /oneheart <on|off>");
            return true;
        }

        if (args[0].equalsIgnoreCase("on")) {
            plugin.setEnabledState(true);
            sender.sendMessage("§a[One Heart] Enabled!");
            return true;
        }

        if (args[0].equalsIgnoreCase("off")) {
            plugin.setEnabledState(false);
            sender.sendMessage("§c[One Heart] Disabled!");
            return true;
        }

        sender.sendMessage("§e[One Heart] Usage: /oneheart <on|off>");
        return true;
    }
}
