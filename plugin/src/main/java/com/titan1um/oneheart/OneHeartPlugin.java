package com.titan1um.oneheart;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class OneHeartPlugin extends JavaPlugin {

    private boolean enabled = true;

    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTaskTimer(this, new HeartTask(this), 0L, 1L);

        getCommand("oneheart").setExecutor(new OneHeartCommand(this));

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);

        getLogger().info("[One Heart] Loaded!");
    }

    public boolean isEnabledState() {
        return enabled;
    }

    public void setEnabledState(boolean enabled) {
        this.enabled = enabled;
    }
}
