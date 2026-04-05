package com.titan1um.oneheart;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public final class HeartTask implements Runnable {

    private static final double ONE_HEART = 2.0;

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {

            // Get max health attribute safely (1.18 compatible)
            AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);

            if (attribute != null) {
                if (attribute.getBaseValue() != ONE_HEART) {
                    attribute.setBaseValue(ONE_HEART);
                }
            }

            // Clamp current health
            if (player.getHealth() > ONE_HEART) {
                player.setHealth(ONE_HEART);
            }
        }
    }
}