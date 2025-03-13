package com.qa.framework.factory;

import com.microsoft.playwright.*;
import com.qa.framework.enams.BrowserName;
import com.qa.framework.utils.config.ConfigUtils;

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
