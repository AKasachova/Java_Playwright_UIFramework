package com.qa.orangehr.framework.factory;

import com.microsoft.playwright.*;
import java.util.Properties;

public class BrowserFactoryProvider {
    public static Browser getBrowser(Properties prop) {
        Playwright playwright = Playwright.create();
        String browserName = prop.getProperty("browser").trim().toLowerCase();
        BrowserFactory factory;

        switch (browserName) {
            case "chromium":
                factory = new ChromiumFactory();
                break;
            case "firefox":
                factory = new FirefoxFactory();
                break;
            case "safari":
                factory = new SafariFactory();
                break;
            case "chrome":
                factory = new ChromeFactory();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }
        return factory.createBrowser(playwright);
    }
}
