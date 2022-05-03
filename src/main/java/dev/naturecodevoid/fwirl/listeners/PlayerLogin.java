package dev.naturecodevoid.fwirl.listeners;

import dev.naturecodevoid.fwirl.Config;
import dev.naturecodevoid.fwirl.Fwirl;
import dev.naturecodevoid.fwirl.subcommands.OpOnlyMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLogin implements Listener {
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent e) {
        if (Config.isOpOnlyMode()) {
            if (OpOnlyMode.kickIfNotAllowed(e.getPlayer())) {
//                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, Component.text("You have been kicked because the server is in OP only mode."));
                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "You have been kicked because the server is in OP only mode.");
                e.setResult(PlayerLoginEvent.Result.KICK_OTHER);
//                e.kickMessage(Component.text("You have been kicked because the server is in OP only mode."));
                e.setKickMessage("You have been kicked because the server is in OP only mode.");
                Fwirl.debug("Kicked " + e.getPlayer().getName() + " in PlayerLogin for not being allowed in OP only mode");
            }
        }
    }
}
