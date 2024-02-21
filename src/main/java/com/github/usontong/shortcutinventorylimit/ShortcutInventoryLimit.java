package com.github.usontong.shortcutinventorylimit;

import com.github.usontong.shortcutinventorylimit.command.Command;
import com.github.usontong.shortcutinventorylimit.entity.Implement;
import com.github.usontong.shortcutinventorylimit.entity.ImplementFunction;
import com.github.usontong.shortcutinventorylimit.listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShortcutInventoryLimit extends JavaPlugin {
    public static JavaPlugin instance;
    public static FileConfiguration configuration;
    public static List<Integer> violate;
    public static Map<Integer, Implement> implementMap = new HashMap<>();

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        init();
    }

    public void init() {
        instance = this;
        config();
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getPluginCommand("shortcutinventorylimit").setExecutor(new Command());
    }

    public void config() {
        configuration = this.getConfig();

        //映射违规快捷栏序号
        violate = configuration.getIntegerList("violate");
        violate = violate.stream().map(n -> n - 1).collect(Collectors.toList());

        for (int i = 1; i <= 9; i++) {
            String string = configuration.getString("limit." + i + ".implement");
            if (string != null) {
                ImplementFunction implementFunction = null;
                switch (string.toLowerCase()) {
                    case "back":
                        implementFunction = ImplementFunction.BACK;
                        break;
                    case "cancel":
                        implementFunction = ImplementFunction.CANCEL;
                        break;
                    case "toggle":
                        implementFunction = ImplementFunction.TOGGLE;
                        break;
                }
                int toggle = configuration.getInt("limit." + i + ".toggle") - 1;
                Implement implement = new Implement(implementFunction, toggle);
                implementMap.put(i - 1, implement);
            }
        }
    }
}
