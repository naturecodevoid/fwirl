package dev.naturecodevoid.fwirl.listeners;

import dev.naturecodevoid.fwirl.Config;
import dev.naturecodevoid.fwirl.Fwirl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class PlayerCommandSend implements Listener {
    @EventHandler
    public void onPlayerCommandSend(PlayerCommandSendEvent e) {
        if (!Config.isGamemodeCommands()) {
            Fwirl.debug("Removing commands for " + e.getPlayer().getName());
            e.getCommands().removeIf(command -> command.equalsIgnoreCase("c"));
            e.getCommands().removeIf(command -> command.equalsIgnoreCase("fwirl:c"));
            e.getCommands().removeIf(command -> command.equalsIgnoreCase("s"));
            e.getCommands().removeIf(command -> command.equalsIgnoreCase("fwirl:s"));
            e.getCommands().removeIf(command -> command.equalsIgnoreCase("a"));
            e.getCommands().removeIf(command -> command.equalsIgnoreCase("fwirl:a"));
            e.getCommands().removeIf(command -> command.equalsIgnoreCase("sp"));
            e.getCommands().removeIf(command -> command.equalsIgnoreCase("fwirl:sp"));
        }
    }
}
