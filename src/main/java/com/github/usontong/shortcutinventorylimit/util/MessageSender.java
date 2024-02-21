package com.github.usontong.shortcutinventorylimit.util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class MessageSender {
    public static String pluginName = "[§5ShortcutInventoryLimit§r]";
    public static String sendName = pluginName + " ";

    public static void sendAll(String message) {
        Bukkit.getLogger().info(message);
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        for (Player player : onlinePlayers) {
            player.sendMessage(sendName + message);
        }
    }

    public static void sendMessage(CommandSender commandSender, String message) {
        commandSender.sendMessage(sendName + message);
    }

    public static void loggerInfo(String message) {
        Bukkit.getLogger().info(sendName + message);
    }

}
