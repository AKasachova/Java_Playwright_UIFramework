package com.qa.orangehr.framework.factory;

import com.microsoft.playwright.*;
import com.qa.orangehr.framework.enams.BrowserName;
import com.qa.orangehr.framework.utils.config.ConfigUtils;

public class BrowserFactoryProvider {
    public static Browser getBrowser(String browserName) {
        Playwright playwright = Playwright.create();
        BrowserFactory factory;
        String browserEnum = BrowserName.getBrowserNameByEnumValue(browserName);

        switch (browserEnum) {
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

    public static Browser getBrowser() {
        return getBrowser( ConfigUtils.getConfigProperties().getProperty("browser"));
    }
}
