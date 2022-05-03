import { Bundler, defineUserConfig, viteBundler } from "vuepress";
import { webpackBundler } from "@vuepress/bundler-webpack";
import { defaultTheme } from "@vuepress/theme-default";

import { searchPlugin } from "@vuepress/plugin-search";
import { tocPlugin } from "@vuepress/plugin-toc";
import { shikiPlugin } from "@vuepress/plugin-shiki";

import { description } from "../package.json";

export default defineUserConfig({
    lang: "en-US",
    title: "Fwirl Docs",
    description: description,

    head: [
        ["link", { rel: "icon", href: "/favicon.ico" }],
        ["link", { rel: "shortcut icon", href: "/favicon.ico" }],

        ["meta", { property: "og:title", content: "Fwirl Docs" }],
        [
            "meta",
            {
                property: "og:description",
                content: "Fwirl is a very simple, yet highly configurable Spigot plugin for common features.",
            },
        ],
        ["meta", { property: "og:url", content: "https://fwirl.naturecodevoid.dev" }],
        ["meta", { property: "og:locale", content: "en_US" }],
        ["meta", { property: "og:type", content: "website" }],

        [
            "meta",
            {
                name: "description",
                content: "Fwirl is a very simple, yet highly configurable Spigot plugin for common features.",
            },
        ],
        ["meta", { name: "owner", content: "naturecodevoid" }],
        ["meta", { name: "url", content: "https://fwirl.naturecodevoid.dev" }],
        ["meta", { name: "category", content: "developer" }],

        ["meta", { name: "apple-mobile-web-app-capable", content: "yes" }],
        ["meta", { name: "apple-mobile-web-app-status-bar-style", content: "black" }],
    ],

    bundler: (process.env.WEBPACK === "1" ? webpackBundler() : viteBundler()) as Bundler,

    theme: defaultTheme({
        repo: "naturecodevoid/fwirl",
        docsDir: "web/",
        editLinkText: "Edit this page on GitHub",
        navbar: [
            {
                text: "Documentation",
                link: "/docs/",
            },
            {
                text: "Changelog",
                link: "https://github.com/naturecodevoid/fwirl/blob/main/CHANGELOG.md",
            },
            {
                text: "SpigotMC",
                link: "https://www.spigotmc.org/resources/101801",
            },
        ],
        sidebar: {
            "/docs/": [
                {
                    text: "Documentation",
                    children: [
                        "/docs/README.md",
                        "/docs/installing.md",
                        "/docs/config.md",
                        "/docs/permissions.md",
                        "/docs/support.md",
                        {
                            text: "Features",
                            link: "/docs/features/",
                            children: [
                                "/docs/features/welcome-message.md",
                                "/docs/features/op-only-mode.md",
                                "/docs/features/quick-gamemode-commands.md",
                            ],
                        },
                    ],
                },
            ],
        },
    }),

    port: Number.parseInt(process.env.PORT) || 8080,

    plugins: [searchPlugin(), tocPlugin(), shikiPlugin({ theme: "dark-plus" })],
});
