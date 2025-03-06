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

    public static String getBrowserNameByEnumValue(String browserNameValue) {
        try {
            return BrowserName.valueOf(browserNameValue.toUpperCase()).getBrowserName();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid browser name: " + browserNameValue, e);
        }
    }
}
