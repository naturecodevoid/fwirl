package dev.naturecodevoid.fwirl.subcommands;

import dev.naturecodevoid.fwirl.Fwirl;
import dev.naturecodevoid.fwirl.SubCommand;
import org.bukkit.command.CommandSender;

public class ReloadConfig extends SubCommand {
    public ReloadConfig() {
        super("reloadConfig");
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission("fwirl.config.reload-config");
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        if (!hasPermission(sender)) {
            sender.sendMessage("§cYou do not have permission to execute this command!");
            return;
        }

        Fwirl.reloadCfg();
        Fwirl.debug(sender.getName() + " reloaded the config from disk");

        sender.sendMessage("§aThe config has been reloaded from disk!");
    }
}
