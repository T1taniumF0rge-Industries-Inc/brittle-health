package com.titan1um.oneheart;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class OneHeartPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Run every tick (datapack equivalent)
        Bukkit.getScheduler().runTaskTimer(this, new HeartTask(), 0L, 1L);
    }
}