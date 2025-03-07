package com.qa.orangehr.framework.enams;

public enum BrowserName {
    CHROMIUM("chromium"),
    FIREFOX("firefox"),
    SAFARI("safari"),
    CHROME("chrome");

    private final String browserName;

    BrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }
}
