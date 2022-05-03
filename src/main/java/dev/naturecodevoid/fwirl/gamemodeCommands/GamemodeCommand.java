package dev.naturecodevoid.fwirl.gamemodeCommands;

import dev.naturecodevoid.fwirl.Config;
import dev.naturecodevoid.fwirl.Fwirl;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public abstract class GamemodeCommand implements CommandExecutor, TabCompleter {
    public final String commandName;
    public final String gamemodeName;
    public final GameMode gamemode;

    protected GamemodeCommand(String commandName, String gamemodeName, GameMode gamemode) {
        this.commandName = commandName;
        this.gamemodeName = gamemodeName;
        this.gamemode = gamemode;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase(commandName)) {
            if (!Config.isGamemodeCommands()) {
                sender.sendMessage("Unknown command. Type \"/help\" for help.");
                return true;
            }

            if (!sender.hasPermission("fwirl.gamemode-commands." + gamemodeName)) {
                sender.sendMessage("§cYou do not have permission to execute this command!");
                return true;
            }

            if (args.length > 0 && sender.hasPermission("fwirl.gamemode-commands.change-other-players")) {
                Player p = Bukkit.getPlayer(args[0]);

                if (p == null) {
                    sender.sendMessage("§cYou must provide a valid player!");
                    return true;
                }

                p.setGameMode(gamemode);

                Fwirl.debug(sender.getName() + " changed " + p.getName() + "'s gamemode to " + gamemodeName);
                if (p != sender)
                    sender.sendMessage("§a" + p.getName() + "'s gamemode has been changed to " + gamemodeName + " mode.");
                p.sendMessage("§aYour gamemode has been changed to " + gamemodeName + " mode.");
            } else {
                if (!(sender instanceof Player)) {
                    sender.sendMessage("§cYou must be a player to execute this command!" + (sender.hasPermission("fwirl.gamemode-commands.change-other-players") ? " You can also provide a player as the first argument to change them into " + gamemodeName + " mode." : ""));
                    return true;
                }

                Player p = (Player) sender;

                p.setGameMode(gamemode);

                Fwirl.debug(sender.getName() + " changed their gamemode to " + gamemodeName);
                sender.sendMessage("§aYour gamemode has been changed to " + gamemodeName + " mode.");
            }
        }

        return true;
    }

    public ArrayList<String> onTabComplete(@NotNull CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase(commandName)) {
            ArrayList<String> options = new ArrayList<>();

            if (sender.hasPermission("fwirl.gamemode-commands.change-other-players"))
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.getName().toLowerCase().startsWith(args[0].toLowerCase()))
                        options.add(p.getName());
                }

            return options;
        }
        return null;
    }
}
