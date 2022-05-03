# Welcome Message

<h4>Table of Contents:</h4>

[[toc]]

## Enabling the welcome message

To start, enable the welcome message by running `/fwirl welcomeMessage on`. You can also
[change the `welcomeMessageEnabled` value in the config file](/docs/config.html#welcomemessageenabled) and then reload
the config using `/fwirl reloadConfig`.

## Editing the welcome message

Open up `plugins/fwirl/config.yml`. You should see the default welcome message:

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

This will produce the following result:

![Example/default welcome message](/img/example-welcome.jpg)

Simply edit this value to change the welcome message. For more info on what is supported and other useful tips, see
[the welcome message configuration docs](/docs/config.html#welcomemessage).
