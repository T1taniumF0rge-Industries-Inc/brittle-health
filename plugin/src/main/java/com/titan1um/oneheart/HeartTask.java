package com.titan1um.oneheart;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public final class HeartTask implements Runnable {

    private final OneHeartPlugin plugin;
    private static final double ONE_HEART = 2.0;

    public HeartTask(OneHeartPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {

        if (!plugin.isEnabledState()) return;

        for (Player player : Bukkit.getOnlinePlayers()) {

            AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);

            if (attribute != null && attribute.getBaseValue() != ONE_HEART) {
                attribute.setBaseValue(ONE_HEART);
            }

            if (player.getHealth() > ONE_HEART) {
                player.setHealth(ONE_HEART);
            }
        }
    }
}
