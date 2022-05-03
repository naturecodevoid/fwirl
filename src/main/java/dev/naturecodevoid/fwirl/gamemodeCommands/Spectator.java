package dev.naturecodevoid.fwirl.gamemodeCommands;

import org.bukkit.GameMode;

public class Spectator extends GamemodeCommand {
    public Spectator() {
        super("sp", "spectator", GameMode.SPECTATOR);
    }
}
