function onBtnClick() {
    // Calling Android Native Method From Web
    if (window.Android && window.Android.onClicked) {
        window.Android.onClicked();
    }
}

// Message Event From Android Native
addEventListener("nativeEvent", function(event) { // (1)
    console.log("nativeEvent:: ", event.detail);
});
