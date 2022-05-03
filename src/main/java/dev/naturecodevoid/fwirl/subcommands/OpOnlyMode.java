package dev.naturecodevoid.fwirl.subcommands;

import dev.naturecodevoid.fwirl.Config;
import dev.naturecodevoid.fwirl.Fwirl;
import dev.naturecodevoid.fwirl.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpOnlyMode extends SubCommand {
    public OpOnlyMode() {
        super("opOnlyMode");
        tabComplete.add("on");
        tabComplete.add("off");
    }

    public static boolean kickIfNotAllowed(Player p) {
        return kickIfNotAllowed(p, false);
    }

    public static boolean kickIfNotAllowed(Player p, boolean includeNow) {
        if (!p.hasPermission("fwirl.allow-in-op-only-mode")) {
//            p.kick(Component.text("You have been kicked because the server is" + (includeNow ? " now" : "") + " in OP only mode."));
            p.kickPlayer("You have been kicked because the server is" + (includeNow ? " now" : "") + " in OP only mode.");
            return true;
        }
        return false;
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission("fwirl.config.op-only-mode");
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
                Config.setOpOnlyMode(true);

                Fwirl.debug(sender.getName() + " set OP only mode to " + Config.isOpOnlyMode());
                sender.sendMessage("§aOP only mode is now enabled");

                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (kickIfNotAllowed(p, true))
                        Fwirl.debug("Kicked " + p.getName() + " when enabling OP only mode for not being allowed in OP only mode");
                }

                return;
            }

            if (arg.equalsIgnoreCase("false") || arg.equalsIgnoreCase("off")) {
                Config.setOpOnlyMode(false);

                Fwirl.debug(sender.getName() + " set OP only mode to " + Config.isOpOnlyMode());
                sender.sendMessage("§aOP only mode is now disabled");

                return;
            }
        }

        sender.sendMessage("§cOP only mode is currently " + (Config.isOpOnlyMode() ? "§aenabled" : "disabled"));
        sendAvailableOptions(sender);
    }
}
