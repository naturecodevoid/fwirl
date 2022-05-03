package dev.naturecodevoid.fwirl.subcommands;

import dev.naturecodevoid.fwirl.Config;
import dev.naturecodevoid.fwirl.Fwirl;
import dev.naturecodevoid.fwirl.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommands extends SubCommand {
    public GamemodeCommands() {
        super("gamemodeCommands");
        tabComplete.add("on");
        tabComplete.add("off");
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission("fwirl.config.gamemode-commands");
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        if (!hasPermission(sender)) {
            sender.sendMessage("§cYou do not have permission to execute this command!");
            return;
        }

        if (args.length > 1) {
            String arg = args[1].toLowerCase();

            if (arg.equalsIgnoreCase("true") || arg.equalsIgnoreCase("on")) {
                Config.setGamemodeCommands(true);

                Fwirl.debug(sender.getName() + " set quick gamemode commands to " + Config.isGamemodeCommands());
                sender.sendMessage("§aEnabled quick gamemode commands (/c, /s, /a, /sp)");

                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.updateCommands();
                }

                return;
            }

            if (arg.equalsIgnoreCase("false") || arg.equalsIgnoreCase("off")) {
                Config.setGamemodeCommands(false);

                Fwirl.debug(sender.getName() + " set gamemode commands to " + Config.isGamemodeCommands());
                sender.sendMessage("§aDisabled quick gamemode commands");

                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.updateCommands();
                }

                return;
            }
        }

        sender.sendMessage("§cQuick gamemode commands are currently " + (Config.isGamemodeCommands() ? "§aenabled" : "disabled"));
        sendAvailableOptions(sender);
    }
}
