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
        onLoad();
    });
    const i = setInterval(() => {
        onLoad();
    }, 100);

    const onLoad = () => {
        if (gotLatestRelease && !loaded) {
            if (document.querySelector(`a[href="${releaseUrl}"]`)) {
                loaded = true;
                clearInterval(i);
            }
            const element = document.querySelector('a[href="/download/"]');
            if (element) {
                loaded = true;
                clearInterval(i);
                const newElement = document.createElement("a");
                newElement.href = releaseUrl;
                newElement.innerHTML = "Download it here";
                element.parentNode.replaceChild(newElement, element);
            }
        }
    };
})();
