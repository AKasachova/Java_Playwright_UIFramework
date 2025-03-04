package com.qa.orangehr.utils.factory;

import com.microsoft.playwright.*;
import java.util.Properties;

public class BrowserFactory {
    Playwright playwright;
    Browser browser;

    public Browser getBrowser(Properties prop) {
        if (playwright == null) {
            playwright = Playwright.create();
        }
        if (browser == null) {
            String browserName = prop.getProperty("browser").trim();
            switch (browserName.toLowerCase()) {
                case "chromium":
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                            .setSlowMo(450));
                    break;
                case "firefox":
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;
                case "safari":
                    browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;
                case "chrome":
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome")
                            .setHeadless(false).setSlowMo(1000));
                    break;
                default:
                    System.out.println("Invalid browser name: " + browserName);
            }
        }
        return browser;
    }
}
