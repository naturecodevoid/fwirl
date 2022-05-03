# Configuration

<h4>Table of Contents:</h4>

[[toc]]

All configuration can be done in `plugins/fwirl/config.yml`. This documents all options and what they do. For
information on the permissions required to configure these using the `/fwirl` command in-game, see
[`fwirl.config`](/docs/permissions.html#fwirl-config).

<!-- prettier-ignore -->
::: tip TIP: Reload the config file
If you change a setting in the config file (`plugins/fwirl/config.yml`), you can reload the config from disk using `/fwirl reloadConfig`.
:::

## `opOnlyMode`

When this setting is enabled, it will block all players from joining except players with the
[`fwirl.allow-in-op-only-mode`](/docs/permissions.html#fwirl-allow-in-op-only-mode) permission. This is given by default
to OPs, and can be given to other non-OP players using a permission plugin such as [LuckPerms](https://luckperms.net/)
or the built-in [`permissions.yml`](https://bukkit.fandom.com/wiki/Permissions.yml).

<!-- prettier-ignore -->
::: tip
Use `/fwirl opOnlyMode <on/off>` to change this option in-game.
:::

## `gamemodeCommands`

When this setting is enabled, it will allow players to use the following commands:

-   `/c`: Turns the player into creative mode.
-   `/s`: Turns the player into survival mode.
-   `/a`: Turns the player into adventure mode.
-   `/sp`: Turns the player into spectator mode.

Players with the
[`fwirl.gamemode-commands.change-other-players`](/docs/permissions.html#fwirl-gamemode-commands-change-other-players)
permission can change other players into the gamemode by using `/<gamemode> <player>`. For example, `/c naturecodevoid`
would turn the player naturecodevoid into creative mode. This permission is given by default to OPs.

There are also permissions for each gamemode. By default, all players are allowed to use all quick gamemode commands,
but this can be changed by removing their permissions using a permission plugin such as
[LuckPerms](https://luckperms.net/) or the built-in [`permissions.yml`](https://bukkit.fandom.com/wiki/Permissions.yml).
For more information on the quick gamemode commands permissions, see
[`fwirl.gamemode-commands`](/docs/permissions.html#fwirl-gamemode-commands).

<!-- prettier-ignore -->
::: tip
Use `/fwirl gamemodeCommands <on/off>` to change this option in-game.
:::

## `welcomeMessageEnabled`

Turning this setting on enables the welcome message players see upon joining the server. For more information on
configuring the welcome message itself, see [`welcomeMessage`](#welcomemessage).

<!-- prettier-ignore -->
::: tip
Use `/fwirl welcomeMessage <on/off>` to change this option in-game.
:::

## `welcomeMessage`

This setting changes the welcome message players seen upon joining the server if
[`welcomeMessageEnabled`](#welcomemessageenabled) is enabled. Here is the default welcome message:

```yaml
welcomeMessage: |
    /c
    &6&m                                                 &r

    /cThis is the example welcome
    /cmessage for Fwirl.

    /cUse "/c" to center text,
    /cand the "&" symbol to
    /c&badd color.

    /cTo escape "/c", add a
    /cbacklash before the line:
    \/creative

    /c<rainbow>MiniMessage is</rainbow>
    /c<gradient:red:blue>also supported.</gradient>

    /cFor more info, check out the docs
    /cat &ahttps://fwirl.naturecodevoid.dev

    &6&m                                                 &r
    /c
```

Features:

-   Prefix a line with `/c` to center it.
-   To escape `/c`, insert a backslash (`\`) before the line.
-   Use the `&` symbol for colors. For the color and formatting codes that minecraft supports, see
    [Formatting codes](https://minecraft.fandom.com/wiki/Formatting_codes#Color_codes).
-   Use MiniMessage for advanced gradients and formatting. See the
    [MiniMessage docs](https://docs.adventure.kyori.net/minimessage/format.html) and the
    [online MiniMessage editor](https://webui.adventure.kyori.net) for more information.

This option has no command to configure it so you must edit `plugins/fwirl/config.yml`.

<!-- prettier-ignore-start -->
::: tip TIP: Use seperators to isolate the message!
The java edition seperator is included in the default welcome
message, but it is included here too. **If you use Geyser** and want the seperator to be compatible with bedrock
edition, use the bedrock edition seperator instead of the java edition version.

Java Edition:
```
&6&m                                                 &r
```

Bedrock & Java Edition:
```
&6&m&o---------------------------------&r
```

![Java Edition Seperators](/img/seperator-java.jpg)

![Bedrock Edition Seperators](/img/seperator-bedrock.jpg)

:::
<!-- prettier-ignore-end -->

## `debug`

This option can only be toggled in `config.yml`. There is no command for this since it is only meant for debugging and
development. You should only set this to `true` if you are developing the plugin or you were asked to while getting
support.

This option currently only toggles verbose logging.
