(() => {
    let gotLatestRelease = false;
    let releaseUrl = "https://github.com/naturecodevoid/fwirl/releases/latest";

    window.fetch("https://api.github.com/repos/naturecodevoid/fwirl/releases/latest").then((r) => {
        r.json().then((data) => {
            releaseUrl = data.assets[0].browser_download_url;
            gotLatestRelease = true;
        });
    });

    // Page specific

    let loaded = false;

    window.addEventListener("load", () => {
        onPageLoad();
        onLoad();
    });
    const i = setInterval(() => {
        onLoad();
    }, 100);

    const onLoad = () => {
        if (gotLatestRelease && !loaded) {
            loaded = true;
            clearInterval(i);
            window.location.href = releaseUrl;
        }
    };

    let pageLoaded = false;

    const iPage = setInterval(() => {
        onPageLoad();
    }, 10);

    const onPageLoad = () => {
        if (!pageLoaded) {
            const elements = document.getElementsByClassName(`external-link-icon`);
            if (elements) {
                for (let elementsChanged = 0; elementsChanged < elements.length; elementsChanged++) {
                    if (elementsChanged >= 6) {
                        const element = elements.item(elementsChanged);
                        element.setAttribute("width", 30);
                        element.setAttribute("height", 30);
                        element.style.paddingLeft = 5;
                        if (elementsChanged >= 8) {
                            pageLoaded = true;
                            clearInterval(iPage);
                            break;
                        }
                    }
                }
            }
        }
    };
})();
