package dev.naturecodevoid.fwirl;

import dev.naturecodevoid.fwirl.gamemodeCommands.*;
import dev.naturecodevoid.fwirl.listeners.PlayerCommandSend;
import dev.naturecodevoid.fwirl.listeners.PlayerJoin;
import dev.naturecodevoid.fwirl.listeners.PlayerLogin;
import dev.naturecodevoid.fwirl.subcommands.GamemodeCommands;
import dev.naturecodevoid.fwirl.subcommands.OpOnlyMode;
import dev.naturecodevoid.fwirl.subcommands.ReloadConfig;
import dev.naturecodevoid.fwirl.subcommands.WelcomeMessage;
import dev.naturecodevoid.fwirl.util.ChatUtil;
import github.scarsz.configuralize.ParseException;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;

public final class Fwirl extends JavaPlugin implements CommandExecutor, TabCompleter {
    public static BukkitAudiences adventure;
    private static Fwirl instance = null;
    private static Config cfg = null;
    private final ArrayList<SubCommand> subCommands = new ArrayList<>();

    public static Fwirl get() {
        return instance;
    }

    public static FileConfiguration getCfg() {
        return get().getConfig();
    }

    public static void saveCfg() {
        get().saveConfig();
    }

    public static void reloadCfg() {
        try {
            cfg = new Config();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void log(String msg) {
        Fwirl.get().getLogger().info(msg);
    }

    public static void debug(String msg) {
        if (Config.isDebug())
            Fwirl.get().getLogger().info("[DEBUG] " + msg);
    }

    @Override
    public void onEnable() {
        instance = this;
        adventure = BukkitAudiences.create(this);

        try {
            cfg = new Config();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        PluginManager m = Bukkit.getPluginManager();

        PluginCommand mainCommand = getCommand("fwirl");
        mainCommand.setExecutor(this);
        mainCommand.setTabCompleter(this);

        // Quick gamemode commands
        GamemodeCommand c = new Creative();
        getCommand("c").setExecutor(c);
        getCommand("c").setTabCompleter(c);

        GamemodeCommand s = new Survival();
        getCommand("s").setExecutor(s);
        getCommand("s").setTabCompleter(s);

        GamemodeCommand a = new Adventure();
        getCommand("a").setExecutor(a);
        getCommand("a").setTabCompleter(a);

        GamemodeCommand sp = new Spectator();
        getCommand("sp").setExecutor(sp);
        getCommand("sp").setTabCompleter(sp);

        // Subcommands
        subCommands.add(new ReloadConfig());
        subCommands.add(new WelcomeMessage());
        subCommands.add(new OpOnlyMode());
        subCommands.add(new GamemodeCommands());

        // Listeners
        m.registerEvents(new PlayerCommandSend(), this);
        m.registerEvents(new PlayerJoin(), this);
        m.registerEvents(new PlayerLogin(), this);

        debug("Debug mode is enabled, change `debug: true` to `debug: false` in `plugins/fwirl/config.yml` if you don't want it enabled");
        log("Done!");
    }

    @Override
    public void onDisable() {
        saveConfig();

        if (adventure != null) {
            adventure.close();
            adventure = null;
        }

        log("Done!");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("fwirl")) {
            if (!sender.hasPermission("fwirl.config.run")) {
                sender.sendMessage("§cYou do not have permission to execute this command!");
                return true;
            }

            if (args.length > 0) {
                String subCommandName = args[0];

                for (SubCommand i : subCommands) {
                    if (i.name.equalsIgnoreCase(subCommandName)) {
                        Fwirl.debug(sender.getName() + " running command " + i.name + " with args: "
                                + String.join(" ", args));
                        i.run(sender, args);
                        return true;
                    }
                }

                Fwirl.debug(sender.getName() + " tried to run command with args: " + String.join(" ", args));

                sendAvailableCommands(sender);
            } else {
                sendAvailableCommands(sender);
            }
        }

        return true;
    }

    public ArrayList<String> onTabComplete(@NotNull CommandSender sender, Command command, String label,
            String[] args) {
        if (command.getName().equalsIgnoreCase("fwirl")) {
            if (args.length > 1) {
                for (SubCommand i : subCommands) {
                    if (i.name.equalsIgnoreCase(args[0]) && i.hasPermission(sender)) {
                        return i.getTabComplete(sender, command, label, args);
                    }
                }

                return null;
            }

            ArrayList<String> options = new ArrayList<>();

            for (SubCommand i : subCommands) {
                if (i.name.toLowerCase().startsWith(args[0].toLowerCase()) && i.hasPermission(sender))
                    options.add(i.name);
            }

            return options;
        }
        return null;
    }

    public void sendAvailableCommands(CommandSender sender) {
        StringBuilder message = new StringBuilder();

        message.append("§cAvailable subcommands:\n");

        for (SubCommand i : subCommands) {
            if (i.hasPermission(sender))
                message.append("§c- " + i.name + "\n");
        }

        ChatUtil.sendMessage(sender, message);
    }
}
