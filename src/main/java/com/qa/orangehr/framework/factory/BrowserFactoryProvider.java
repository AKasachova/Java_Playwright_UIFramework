package com.qa.orangehr.framework.factory;

import com.microsoft.playwright.*;
import com.qa.orangehr.framework.enams.BrowserName;

import java.util.Properties;

public class BrowserFactoryProvider {
    public static Browser getBrowser(Properties prop) {
        Playwright playwright = Playwright.create();
        BrowserName browserName = BrowserName.getBrowserName((prop.getProperty("browser")));
        BrowserFactory factory;

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
}
