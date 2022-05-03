package dev.naturecodevoid.fwirl;

import dev.naturecodevoid.fwirl.util.ChatUtil;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public abstract class SubCommand {
    public final String name;
    public ArrayList<String> tabComplete = new ArrayList<>();

    public SubCommand(String name) {
        this.name = name;
    }

    public boolean hasPermission(CommandSender sender) {
        throw new NotImplementedException();
    }

    public void run(CommandSender sender, String[] args) {
        throw new NotImplementedException();
    }

    public ArrayList<String> getTabComplete(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> options = new ArrayList<>();

        for (String i : tabComplete) {
            if (i.toLowerCase().startsWith(args[1].toLowerCase())) options.add(i);
        }

        return options;
    }

    public void sendAvailableOptions(CommandSender sender) {
        StringBuilder message = new StringBuilder();

        message.append("§cAvailable options:\n");

        for (String i : tabComplete) {
            message.append("§c- ").append(i).append("\n");
        }

        ChatUtil.sendMessage(sender, message);
    }
}
