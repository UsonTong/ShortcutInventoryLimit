package com.github.usontong.shortcutinventorylimit.listener;

import com.github.usontong.shortcutinventorylimit.ShortcutInventoryLimit;
import com.github.usontong.shortcutinventorylimit.entity.Implement;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        if (ShortcutInventoryLimit.violate.contains(event.getNewSlot())) {
            if (ShortcutInventoryLimit.implementMap.containsKey(event.getPreviousSlot())) {
                Implement implement = ShortcutInventoryLimit.implementMap.get(event.getPreviousSlot());
                switch (implement.getImplementFunction()) {
                    case BACK:
                        backImpl(event);
                        break;
                    case CANCEL:
                        cancelImpl(event);
                        break;
                    case TOGGLE:
                        toggleImpl(event, implement.getToggle());
                        break;
                }
            }
        }
    }

    //回退实现
    public void backImpl(PlayerItemHeldEvent event) {
        event.getPlayer().getInventory().setHeldItemSlot(event.getPreviousSlot());
    }

    //取消实现
    public void cancelImpl(PlayerItemHeldEvent event) {
        event.setCancelled(true);
    }

    //跳转实现
    public void toggleImpl(PlayerItemHeldEvent event, int toggle) {
        event.getPlayer().getInventory().setHeldItemSlot(toggle);
    }
}
