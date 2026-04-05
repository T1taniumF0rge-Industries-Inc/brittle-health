package com.titan1um.oneheart;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("§e[One Heart] You are playing with the One Heart plugin, which sets you to one heart and removes the other 9 hearts! Good luck...");
    }
}
