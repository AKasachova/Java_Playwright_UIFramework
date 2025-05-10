package com.qa.framework.manager;

import com.microsoft.playwright.Browser;
import com.qa.framework.factory.BrowserFactoryProvider;

public class BrowserManager {
    private static Browser browser;

    public static Browser getBrowser() {
        if (browser == null) {
            browser = BrowserFactoryProvider.getBrowser();
        }
        return browser;
    }

    public static Browser getBrowser(String browserName) {
        if (browser == null) {
            browser = BrowserFactoryProvider.getBrowser(browserName);
        }
        return browser;
    }

    public static void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
        browser = null;
    }
}
