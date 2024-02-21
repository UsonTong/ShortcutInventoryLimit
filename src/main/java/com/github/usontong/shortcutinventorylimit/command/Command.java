package com.github.usontong.shortcutinventorylimit.command;

import com.github.usontong.shortcutinventorylimit.ShortcutInventoryLimit;
import com.github.usontong.shortcutinventorylimit.util.MessageSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (args.length != 0 && sender.isOp()) {
            if (args[0].equalsIgnoreCase("reload")) {
                File file = new File(ShortcutInventoryLimit.instance.getDataFolder(),  "config.yml");
                if (!file.exists()) {
                    ShortcutInventoryLimit.instance.saveDefaultConfig();
                }
                ShortcutInventoryLimit.instance.reloadConfig();
                MessageSender.sendMessage(sender, "配置文件重载完成！");
                ShortcutInventoryLimit.configuration = ShortcutInventoryLimit.instance.getConfig();
                return true;
            }
        }
        return false;
    }
}
