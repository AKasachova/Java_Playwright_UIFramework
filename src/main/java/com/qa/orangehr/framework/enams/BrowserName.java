package com.qa.orangehr.framework.enams;

public enum BrowserName {
    CHROMIUM, FIREFOX, SAFARI, CHROME;

    public static BrowserName getBrowserName(String browserName) {
        return BrowserName.valueOf(browserName.trim().toUpperCase());
    }
}
