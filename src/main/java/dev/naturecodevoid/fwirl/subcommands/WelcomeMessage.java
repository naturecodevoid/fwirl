package dev.naturecodevoid.fwirl.subcommands;

import dev.naturecodevoid.fwirl.Config;
import dev.naturecodevoid.fwirl.Fwirl;
import dev.naturecodevoid.fwirl.SubCommand;
import org.bukkit.command.CommandSender;

public class WelcomeMessage extends SubCommand {
    public WelcomeMessage() {
        super("welcomeMessage");
        tabComplete.add("on");
        tabComplete.add("off");
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission("fwirl.config.welcome-message");
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
                Config.setWelcomeMessageEnabled(true);

                Fwirl.debug(sender.getName() + " set welcome message enabled to " + Config.isWelcomeMessageEnabled());
                sender.sendMessage("§aEnabled welcome message (configure the message in plugins/fwirl/config.yml)");

                return;
            }

            if (arg.equalsIgnoreCase("false") || arg.equalsIgnoreCase("off")) {
                Config.setWelcomeMessageEnabled(false);

                Fwirl.debug(sender.getName() + " set welcome message enabled to " + Config.isWelcomeMessageEnabled());
                sender.sendMessage("§aDisabled welcome message");

                return;
            }
        }

        sender.sendMessage("§cWelcome message is currently " + (Config.isWelcomeMessageEnabled() ? "§aenabled" : "disabled"));
        sendAvailableOptions(sender);
    }
}
