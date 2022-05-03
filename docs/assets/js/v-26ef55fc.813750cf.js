"use strict";(self.webpackChunkfwirl_docs=self.webpackChunkfwirl_docs||[]).push([[192],{1082:(e,n,s)=>{s.r(n),s.d(n,{data:()=>a});const a={key:"v-26ef55fc",path:"/docs/config.html",title:"Configuration",lang:"en-US",frontmatter:{},excerpt:"",headers:[{level:2,title:"opOnlyMode",slug:"oponlymode",children:[]},{level:2,title:"gamemodeCommands",slug:"gamemodecommands",children:[]},{level:2,title:"welcomeMessageEnabled",slug:"welcomemessageenabled",children:[]},{level:2,title:"welcomeMessage",slug:"welcomemessage",children:[]},{level:2,title:"debug",slug:"debug",children:[]}],git:{updatedTime:1651542554e3,contributors:[{name:"naturecodevoid",email:"44983869+naturecodevoid@users.noreply.github.com",commits:1}]},filePathRelative:"docs/config.md"}},3188:(e,n,s)=>{s.r(n),s.d(n,{default:()=>de});var a=s(6252);const o=(0,a._)("h1",{id:"configuration",tabindex:"-1"},[(0,a._)("a",{class:"header-anchor",href:"#configuration","aria-hidden":"true"},"#"),(0,a.Uk)(" Configuration")],-1),l=(0,a._)("h4",null,"Table of Contents:",-1),i={class:"table-of-contents"},r=(0,a.Uk)("opOnlyMode"),t=(0,a.Uk)("gamemodeCommands"),c=(0,a.Uk)("welcomeMessageEnabled"),p=(0,a.Uk)("welcomeMessage"),d=(0,a.Uk)("debug"),m=(0,a.Uk)("All configuration can be done in "),u=(0,a._)("code",null,"plugins/fwirl/config.yml",-1),g=(0,a.Uk)(". This documents all options and what they do. For information on the permissions required to configure these using the "),h=(0,a._)("code",null,"/fwirl",-1),b=(0,a.Uk)(" command in-game, see "),f=(0,a._)("code",null,"fwirl.config",-1),k=(0,a.Uk)("."),y=(0,a._)("div",{class:"custom-container tip"},[(0,a._)("p",{class:"custom-container-title"},"TIP: Reload the config file"),(0,a._)("p",null,[(0,a.Uk)("If you change a setting in the config file ("),(0,a._)("code",null,"plugins/fwirl/config.yml"),(0,a.Uk)("), you can reload the config from disk using "),(0,a._)("code",null,"/fwirl reloadConfig"),(0,a.Uk)(".")])],-1),w=(0,a._)("h2",{id:"oponlymode",tabindex:"-1"},[(0,a._)("a",{class:"header-anchor",href:"#oponlymode","aria-hidden":"true"},"#"),(0,a.Uk)(),(0,a._)("code",null,"opOnlyMode")],-1),_=(0,a.Uk)("When this setting is enabled, it will block all players from joining except players with the "),v=(0,a._)("code",null,"fwirl.allow-in-op-only-mode",-1),U=(0,a.Uk)(" permission. This is given by default to OPs, and can be given to other non-OP players using a permission plugin such as "),E={href:"https://luckperms.net/",target:"_blank",rel:"noopener noreferrer"},C=(0,a.Uk)("LuckPerms"),T=(0,a.Uk)(" or the built-in "),M={href:"https://bukkit.fandom.com/wiki/Permissions.yml",target:"_blank",rel:"noopener noreferrer"},x=(0,a._)("code",null,"permissions.yml",-1),W=(0,a.Uk)("."),D=(0,a.uE)('<div class="custom-container tip"><p class="custom-container-title">TIP</p><p>Use <code>/fwirl opOnlyMode &lt;on/off&gt;</code> to change this option in-game.</p></div><h2 id="gamemodecommands" tabindex="-1"><a class="header-anchor" href="#gamemodecommands" aria-hidden="true">#</a> <code>gamemodeCommands</code></h2><p>When this setting is enabled, it will allow players to use the following commands:</p><ul><li><code>/c</code>: Turns the player into creative mode.</li><li><code>/s</code>: Turns the player into survival mode.</li><li><code>/a</code>: Turns the player into adventure mode.</li><li><code>/sp</code>: Turns the player into spectator mode.</li></ul>',4),P=(0,a.Uk)("Players with the "),F=(0,a._)("code",null,"fwirl.gamemode-commands.change-other-players",-1),q=(0,a.Uk)(" permission can change other players into the gamemode by using "),j=(0,a._)("code",null,"/<gamemode> <player>",-1),I=(0,a.Uk)(". For example, "),O=(0,a._)("code",null,"/c naturecodevoid",-1),L=(0,a.Uk)(" would turn the player naturecodevoid into creative mode. This permission is given by default to OPs."),S=(0,a.Uk)("There are also permissions for each gamemode. By default, all players are allowed to use all quick gamemode commands, but this can be changed by removing their permissions using a permission plugin such as "),B={href:"https://luckperms.net/",target:"_blank",rel:"noopener noreferrer"},J=(0,a.Uk)("LuckPerms"),R=(0,a.Uk)(" or the built-in "),H={href:"https://bukkit.fandom.com/wiki/Permissions.yml",target:"_blank",rel:"noopener noreferrer"},Y=(0,a._)("code",null,"permissions.yml",-1),Z=(0,a.Uk)(". For more information on the quick gamemode commands permissions, see "),A=(0,a._)("code",null,"fwirl.gamemode-commands",-1),G=(0,a.Uk)("."),z=(0,a.uE)('<div class="custom-container tip"><p class="custom-container-title">TIP</p><p>Use <code>/fwirl gamemodeCommands &lt;on/off&gt;</code> to change this option in-game.</p></div><h2 id="welcomemessageenabled" tabindex="-1"><a class="header-anchor" href="#welcomemessageenabled" aria-hidden="true">#</a> <code>welcomeMessageEnabled</code></h2><p>Turning this setting on enables the welcome message players see upon joining the server. For more information on configuring the welcome message itself, see <a href="#welcomemessage"><code>welcomeMessage</code></a>.</p><div class="custom-container tip"><p class="custom-container-title">TIP</p><p>Use <code>/fwirl welcomeMessage &lt;on/off&gt;</code> to change this option in-game.</p></div><h2 id="welcomemessage" tabindex="-1"><a class="header-anchor" href="#welcomemessage" aria-hidden="true">#</a> <code>welcomeMessage</code></h2><p>This setting changes the welcome message players seen upon joining the server if <a href="#welcomemessageenabled"><code>welcomeMessageEnabled</code></a> is enabled. Here is the default welcome message:</p><div class="language-yaml ext-yml line-numbers-mode"><pre class="shiki" style="background-color:#1E1E1E;"><code><span class="line"><span style="color:#569CD6;">welcomeMessage</span><span style="color:#D4D4D4;">: </span><span style="color:#C586C0;">|</span></span>\n<span class="line"><span style="color:#CE9178;">    /c</span></span>\n<span class="line"><span style="color:#CE9178;">    &amp;6&amp;m                                                 &amp;r</span></span>\n<span class="line"></span>\n<span class="line"><span style="color:#CE9178;">    /cThis is the example welcome</span></span>\n<span class="line"><span style="color:#CE9178;">    /cmessage for Fwirl.</span></span>\n<span class="line"></span>\n<span class="line"><span style="color:#CE9178;">    /cUse &quot;/c&quot; to center text,</span></span>\n<span class="line"><span style="color:#CE9178;">    /cand the &quot;&amp;&quot; symbol to</span></span>\n<span class="line"><span style="color:#CE9178;">    /c&amp;badd color.</span></span>\n<span class="line"></span>\n<span class="line"><span style="color:#CE9178;">    /cTo escape &quot;/c&quot;, add a</span></span>\n<span class="line"><span style="color:#CE9178;">    /cbacklash before the line:</span></span>\n<span class="line"><span style="color:#CE9178;">    \\/creative</span></span>\n<span class="line"></span>\n<span class="line"><span style="color:#CE9178;">    /c&lt;rainbow&gt;MiniMessage is&lt;/rainbow&gt;</span></span>\n<span class="line"><span style="color:#CE9178;">    /c&lt;gradient:red:blue&gt;also supported.&lt;/gradient&gt;</span></span>\n<span class="line"></span>\n<span class="line"><span style="color:#CE9178;">    /cFor more info, check out the docs</span></span>\n<span class="line"><span style="color:#CE9178;">    /cat &amp;ahttps://fwirl.naturecodevoid.dev</span></span>\n<span class="line"></span>\n<span class="line"><span style="color:#CE9178;">    &amp;6&amp;m                                                 &amp;r</span></span>\n<span class="line"><span style="color:#CE9178;">    /c</span></span>\n<span class="line"></span></code></pre><div class="line-numbers" aria-hidden="true"><span class="line-number">1</span><br><span class="line-number">2</span><br><span class="line-number">3</span><br><span class="line-number">4</span><br><span class="line-number">5</span><br><span class="line-number">6</span><br><span class="line-number">7</span><br><span class="line-number">8</span><br><span class="line-number">9</span><br><span class="line-number">10</span><br><span class="line-number">11</span><br><span class="line-number">12</span><br><span class="line-number">13</span><br><span class="line-number">14</span><br><span class="line-number">15</span><br><span class="line-number">16</span><br><span class="line-number">17</span><br><span class="line-number">18</span><br><span class="line-number">19</span><br><span class="line-number">20</span><br><span class="line-number">21</span><br><span class="line-number">22</span><br><span class="line-number">23</span><br></div></div><p>Features:</p>',8),K=(0,a._)("li",null,[(0,a.Uk)("Prefix a line with "),(0,a._)("code",null,"/c"),(0,a.Uk)(" to center it.")],-1),N=(0,a._)("li",null,[(0,a.Uk)("To escape "),(0,a._)("code",null,"/c"),(0,a.Uk)(", insert a backslash ("),(0,a._)("code",null,"\\"),(0,a.Uk)(") before the line.")],-1),Q=(0,a.Uk)("Use the "),V=(0,a._)("code",null,"&",-1),X=(0,a.Uk)(" symbol for colors. For the color and formatting codes that minecraft supports, see "),$={href:"https://minecraft.fandom.com/wiki/Formatting_codes#Color_codes",target:"_blank",rel:"noopener noreferrer"},ee=(0,a.Uk)("Formatting codes"),ne=(0,a.Uk)("."),se=(0,a.Uk)("Use MiniMessage for advanced gradients and formatting. See the "),ae={href:"https://docs.adventure.kyori.net/minimessage/format.html",target:"_blank",rel:"noopener noreferrer"},oe=(0,a.Uk)("MiniMessage docs"),le=(0,a.Uk)(" and the "),ie={href:"https://webui.adventure.kyori.net",target:"_blank",rel:"noopener noreferrer"},re=(0,a.Uk)("online MiniMessage editor"),te=(0,a.Uk)(" for more information."),ce=(0,a.uE)('<p>This option has no command to configure it so you must edit <code>plugins/fwirl/config.yml</code>.</p><div class="custom-container tip"><p class="custom-container-title">TIP: Use seperators to isolate the message!</p><p>The java edition seperator is included in the default welcome message, but it is included here too. <strong>If you use Geyser</strong> and want the seperator to be compatible with bedrock edition, use the bedrock edition seperator instead of the java edition version.</p><p>Java Edition:</p><div class="language-text ext-text line-numbers-mode"><pre class="shiki" style="background-color:#1E1E1E;"><code><span class="line"><span style="color:#D4D4D4;">&amp;6&amp;m                                                 &amp;r</span></span>\n<span class="line"><span style="color:#D4D4D4;"></span></span></code></pre><div class="line-numbers" aria-hidden="true"><span class="line-number">1</span><br></div></div><p>Bedrock &amp; Java Edition:</p><div class="language-text ext-text line-numbers-mode"><pre class="shiki" style="background-color:#1E1E1E;"><code><span class="line"><span style="color:#D4D4D4;">&amp;6&amp;m&amp;o---------------------------------&amp;r</span></span>\n<span class="line"><span style="color:#D4D4D4;"></span></span></code></pre><div class="line-numbers" aria-hidden="true"><span class="line-number">1</span><br></div></div><p><img src="/img/seperator-java.jpg" alt="Java Edition Seperators"></p><p><img src="/img/seperator-bedrock.jpg" alt="Bedrock Edition Seperators"></p></div><h2 id="debug" tabindex="-1"><a class="header-anchor" href="#debug" aria-hidden="true">#</a> <code>debug</code></h2><p>This option can only be toggled in <code>config.yml</code>. There is no command for this since it is only meant for debugging and development. You should only set this to <code>true</code> if you are developing the plugin or you were asked to while getting support.</p><p>This option currently only toggles verbose logging.</p>',5),pe={},de=(0,s(3744).Z)(pe,[["render",function(e,n){const s=(0,a.up)("RouterLink"),pe=(0,a.up)("ExternalLinkIcon");return(0,a.wg)(),(0,a.iD)(a.HY,null,[o,l,(0,a._)("nav",i,[(0,a._)("ul",null,[(0,a._)("li",null,[(0,a.Wm)(s,{to:"#oponlymode"},{default:(0,a.w5)((()=>[r])),_:1})]),(0,a._)("li",null,[(0,a.Wm)(s,{to:"#gamemodecommands"},{default:(0,a.w5)((()=>[t])),_:1})]),(0,a._)("li",null,[(0,a.Wm)(s,{to:"#welcomemessageenabled"},{default:(0,a.w5)((()=>[c])),_:1})]),(0,a._)("li",null,[(0,a.Wm)(s,{to:"#welcomemessage"},{default:(0,a.w5)((()=>[p])),_:1})]),(0,a._)("li",null,[(0,a.Wm)(s,{to:"#debug"},{default:(0,a.w5)((()=>[d])),_:1})])])]),(0,a._)("p",null,[m,u,g,h,b,(0,a.Wm)(s,{to:"/docs/permissions.html#fwirl-config"},{default:(0,a.w5)((()=>[f])),_:1}),k]),y,w,(0,a._)("p",null,[_,(0,a.Wm)(s,{to:"/docs/permissions.html#fwirl-allow-in-op-only-mode"},{default:(0,a.w5)((()=>[v])),_:1}),U,(0,a._)("a",E,[C,(0,a.Wm)(pe)]),T,(0,a._)("a",M,[x,(0,a.Wm)(pe)]),W]),D,(0,a._)("p",null,[P,(0,a.Wm)(s,{to:"/docs/permissions.html#fwirl-gamemode-commands-change-other-players"},{default:(0,a.w5)((()=>[F])),_:1}),q,j,I,O,L]),(0,a._)("p",null,[S,(0,a._)("a",B,[J,(0,a.Wm)(pe)]),R,(0,a._)("a",H,[Y,(0,a.Wm)(pe)]),Z,(0,a.Wm)(s,{to:"/docs/permissions.html#fwirl-gamemode-commands"},{default:(0,a.w5)((()=>[A])),_:1}),G]),z,(0,a._)("ul",null,[K,N,(0,a._)("li",null,[Q,V,X,(0,a._)("a",$,[ee,(0,a.Wm)(pe)]),ne]),(0,a._)("li",null,[se,(0,a._)("a",ae,[oe,(0,a.Wm)(pe)]),le,(0,a._)("a",ie,[re,(0,a.Wm)(pe)]),te])]),ce],64)}]])},3744:(e,n)=>{n.Z=(e,n)=>{const s=e.__vccOpts||e;for(const[e,a]of n)s[e]=a;return s}}}]);