# Permissions

<h4>Table of Contents:</h4>

[[toc]]

If you want to give access to every fwirl permission, use `fwirl.*`.

## `fwirl.allow-in-op-only-mode`

-   Default: Operators

All players with this permission will be allowed to join the server when OP only mode is on. See the
[OP only mode config docs](/docs/config.html#oponlymode) for more info.

## `fwirl.config`

This module contains permissions for configuring fwirl via `/fwirl`. If you want to give access to every fwirl config
permission, use `fwirl.config.*`.

### `fwirl.config.run`

-   Default: Operators

Allows running `/fwirl`. The user must have this to run any subcommands.

### `fwirl.config.reload-config`

-   Default: Operators

Allows running `/fwirl reloadConfig`. This will reload the config from disk.

### `fwirl.config.welcome-message`

-   Default: Operators

Allows toggling the welcome message via `/fwirl welcomeMessage <on/off>`.

### `fwirl.config.op-only-mode`

-   Default: Operators

Allows toggling OP only mode via `/fwirl opOnlyMode <on/off>`.

### `fwirl.config.gamemode-commands`

-   Default: Operators

Allows toggling quick gamemode commands via `/fwirl gamemodeCommands <on/off>`.

## `fwirl.gamemode-commands`

This module contains permissions for the quick gamemode commands (`/c`, `/s`, `/a`, `/sp`). If you want to give access
to every fwirl config permission, use `fwirl.gamemode-commands.*`.

### `fwirl.gamemode-commands.change-other-players`

-   Default: Operators

Allows using the quick gamemode commands to change other player's gamemode by using `/<gamemode> <player>`. For example,
`/c naturecodevoid` would turn the player naturecodevoid into creative mode.

### `fwirl.gamemode-commands.creative`

-   Default: All players

Allows running `/c`. This turns the user into creative mode.

### `fwirl.gamemode-commands.survival`

-   Default: All players

Allows running `/s`. This turns the user into survival mode.

### `fwirl.gamemode-commands.adventure`

-   Default: All players

Allows running `/a`. This turns the user into adventure mode.

### `fwirl.gamemode-commands.spectator`

-   Default: All players

Allows running `/sp`. This turns the user into spectator mode.
