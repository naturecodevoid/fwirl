package dev.naturecodevoid.fwirl;

import github.scarsz.configuralize.DynamicConfig;
import github.scarsz.configuralize.ParseException;
import github.scarsz.configuralize.mapping.Option;
import lombok.Getter;
import org.apache.commons.io.IOUtils;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Config extends DynamicConfig {
    @Getter
    @Option(key = "opOnlyMode")
    private static boolean opOnlyMode;

    @Getter
    @Option(key = "gamemodeCommands")
    private static boolean gamemodeCommands;

    @Getter
    @Option(key = "welcomeMessageEnabled")
    private static boolean welcomeMessageEnabled;

    @Getter
    @Option(key = "welcomeMessage")
    private static String welcomeMessage;

    @Getter
    @Option(key = "debug")
    private static boolean debug;

    public Config() throws IOException, ParseException {
        Fwirl p = Fwirl.get();
        File cfgFile = new File(p.getDataFolder(), "config.yml");

        addSource(Config.class, "config", cfgFile);
        saveAllDefaults();
        p.reloadConfig();
        debug = p.getConfig().getBoolean("debug");

        YamlConfiguration defaults = new YamlConfiguration();
        try {
            defaults.loadFromString(IOUtils.toString(p.getResource("config/en.yml"), StandardCharsets.UTF_8));
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

        defaults.getValues(true).forEach((String key, Object val) -> {
            if (p.getConfig().get(key) == null) {
                Fwirl.debug("Updating value of " + key + " to default");
                p.getConfig().set(key, val);
            }
        });
        p.saveConfig();

        loadAll();
        map();

        if (isDebug())
            p.getConfig().getValues(true).forEach((String key, Object val) -> {
                Fwirl.debug("[CONFIG] " + key + " = " + val);
            });
    }

    public static void setWelcomeMessageEnabled(boolean val) {
        welcomeMessageEnabled = val;
        Fwirl.getCfg().set("welcomeMessageEnabled", welcomeMessageEnabled);
        Fwirl.saveCfg();
    }

    public static void setOpOnlyMode(boolean val) {
        opOnlyMode = val;
        Fwirl.getCfg().set("opOnlyMode", opOnlyMode);
        Fwirl.saveCfg();
    }

    public static void setGamemodeCommands(boolean val) {
        gamemodeCommands = val;
        Fwirl.getCfg().set("gamemodeCommands", gamemodeCommands);
        Fwirl.saveCfg();
    }
}
