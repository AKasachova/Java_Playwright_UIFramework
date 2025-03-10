package com.qa.userinyerface.framework.manager;

import com.microsoft.playwright.Browser;
import com.qa.userinyerface.framework.factory.BrowserFactoryProvider;

public class BrowserManager {
    private static Browser browser;

    public static Browser getBrowser() {
        if (browser == null) {
            browser = BrowserFactoryProvider.getBrowser();
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
