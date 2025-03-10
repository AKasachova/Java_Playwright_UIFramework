package com.qa.userinyerface.framework.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import com.qa.userinyerface.framework.enams.BrowserName;
import com.qa.userinyerface.framework.utils.config.ConfigUtils;

public class BrowserFactoryProvider {
    public static Browser getBrowser(BrowserName browserName) {
        Playwright playwright = Playwright.create();
        BrowserInterface factory;

        switch (browserName) {
            case CHROMIUM:
                factory = new ChromiumFactory();
                break;
            case FIREFOX:
                factory = new FirefoxFactory();
                break;
            case SAFARI:
                factory = new SafariFactory();
                break;
            case CHROME:
                factory = new ChromeFactory();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }
        return factory.createBrowser(playwright);
    }

    public static Browser getBrowser(String browserName) {
        return getBrowser(BrowserName.valueOf(browserName.toUpperCase()));
    }

    public static Browser getBrowser() {
        return getBrowser(BrowserName.valueOf(ConfigUtils.getConfigProperties().getProperty("browser").toUpperCase()));
    }
}
