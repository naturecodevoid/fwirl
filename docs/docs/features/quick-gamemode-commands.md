# Quick Gamemode Commands

To start, enable quick gamemode commands by running `/fwirl gamemodeCommands on`. You can also
[change the `gamemodeCommands` value in the config file](/docs/config.html#gamemodecommands) and then reload the config
using `/fwirl reloadConfig`.

_From [quick gamemode commands configuration docs](/docs/config.html#gamemodecommands):_

> When this setting is enabled, it will allow players to use the following commands:
>
> -   `/c`: Turns the player into creative mode.
> -   `/s`: Turns the player into survival mode.
> -   `/a`: Turns the player into adventure mode.
> -   `/sp`: Turns the player into spectator mode.
>
> Players with the
> [`fwirl.gamemode-commands.change-other-players`](/docs/permissions.html#fwirl-gamemode-commands-change-other-players)
> permission can change other players into the gamemode by using `/<gamemode> <player>`. For example,
> `/c naturecodevoid` would turn the player naturecodevoid into creative mode. This permission is given by default to
> OPs. <br /><br /> There are also permissions for each gamemode. By default, all players are allowed to use all quick
> gamemode commands, but this can be changed by removing their permissions using a permission plugin such as
> [LuckPerms](https://luckperms.net/) or the built-in
> [`permissions.yml`](https://bukkit.fandom.com/wiki/Permissions.yml). For more information on the quick gamemode
> commands permissions, see [`fwirl.gamemode-commands`](/docs/permissions.html#fwirl-gamemode-commands).
