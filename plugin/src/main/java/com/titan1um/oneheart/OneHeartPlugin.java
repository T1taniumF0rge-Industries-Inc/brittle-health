package com.titan1um.oneheart;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class OneHeartPlugin extends JavaPlugin {

    private boolean enabled = true;

    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTaskTimer(this, new HeartTask(this), 0L, 1L);

        getCommand("oneheart").setExecutor(new OneHeartCommand(this));

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);

        getLogger().info("[One Heart] Loaded!");

        // bStats metrics
        int pluginId = 30593;
        Metrics metrics = new Metrics(this, pluginId);

        metrics.addCustomChart(new Metrics.AdvancedPie("player_gamemodes", () -> {
            Map<String, Integer> gamemodeMap = new HashMap<>();
            for (Player player : Bukkit.getOnlinePlayers()) {
                String gamemode = player.getGameMode().name();
                gamemodeMap.put(gamemode, gamemodeMap.getOrDefault(gamemode, 0) + 1);
            }
            return gamemodeMap;
        }));

        metrics.addCustomChart(new MultiLineChart("players_and_servers", () -> {
            Map<String, Integer> valueMap = new HashMap<>();
            valueMap.put("servers", 1);
            valueMap.put("players", Bukkit.getOnlinePlayers().size());
            return valueMap;
        }));

    public boolean isEnabledState() {
        return enabled;
    }

    public void setEnabledState(boolean enabled) {
        this.enabled = enabled;
    }
}
