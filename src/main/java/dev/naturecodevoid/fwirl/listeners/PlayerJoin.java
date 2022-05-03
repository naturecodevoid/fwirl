package dev.naturecodevoid.fwirl.listeners;

import dev.naturecodevoid.fwirl.Config;
import dev.naturecodevoid.fwirl.Fwirl;
import dev.naturecodevoid.fwirl.subcommands.OpOnlyMode;
import dev.naturecodevoid.fwirl.util.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.regex.Pattern;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (Config.isOpOnlyMode()) {
            if (OpOnlyMode.kickIfNotAllowed(e.getPlayer()))
                Fwirl.debug("Kicked " + e.getPlayer().getName() + " in PlayerJoin for not being allowed in OP only mode");
        }

        if (Config.isWelcomeMessageEnabled()) {
            Player p = e.getPlayer();

            for (String s : Config.getWelcomeMessage().split("\n")) {
                if (s.startsWith("\\"))
                    Fwirl.adventure.player(p).sendMessage(ChatUtil.minimessage(s.replaceFirst(Pattern.compile(Pattern.quote("\\")).toString(), "")));
                else if (s.startsWith("/c"))
                    Fwirl.adventure.player(p).sendMessage(ChatUtil.minimessage(s, true));
                else Fwirl.adventure.player(p).sendMessage(ChatUtil.minimessage(s));
            }

            Fwirl.debug("Sent welcome message to " + p.getName());
        }
    }
}
