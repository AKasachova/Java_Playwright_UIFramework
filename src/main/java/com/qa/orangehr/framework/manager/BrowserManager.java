package com.qa.orangehr.framework.manager;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.qa.orangehr.framework.factory.BrowserFactoryProvider;
import com.qa.orangehr.framework.utils.config.ConfigUtils;

public class BrowserManager {
    private static Browser browser;
    private static BrowserContext browserContext;

    public static Browser getBrowser() {
        if (browser == null) {
            browser = BrowserFactoryProvider.getBrowser(ConfigUtils.getConfigProperties());
        }
        return browser;
    }

    public static BrowserContext getBrowserContext(Browser browser) {
        return browser.newContext();
    }

    public static Page getNewPage(BrowserContext browserContext) {
        Page page = browserContext.newPage();
        page.navigate(ConfigUtils.getConfigProperties().getProperty("URL").trim());
        return page;
    }

    public static void closeContext() {
        if (browserContext != null) {
            browserContext.close();
        }
    }

    public static void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
        browser = null;
    }
}
