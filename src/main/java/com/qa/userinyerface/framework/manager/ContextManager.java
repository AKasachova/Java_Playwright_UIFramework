package com.qa.userinyerface.framework.manager;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.qa.userinyerface.framework.utils.config.ConfigUtils;

public class ContextManager {
    private static BrowserContext browserContext;

    public static BrowserContext getBrowserContext(Browser browser) {
        return browser.newContext();
    }

    public static Page getNewPage(Browser browser, String url) {
        Page page = getBrowserContext(browser).newPage();
        page.navigate(url);
        return page;
    }

    public static Page getNewPage(Browser browser) {
        Page page = getBrowserContext(browser).newPage();
        page.navigate(ConfigUtils.getConfigProperties().getProperty("urlUserinyerface").trim());
        return page;
    }

    public static void closeContext() {
        if (browserContext != null) {
            browserContext.close();
        }
    }
}
