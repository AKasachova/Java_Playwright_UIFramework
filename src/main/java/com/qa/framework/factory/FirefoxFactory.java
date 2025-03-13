package com.qa.framework.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class FirefoxFactory implements BrowserInterface {
    @Override
    public Browser createBrowser(Playwright playwright) {
        return playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)
                .setSlowMo(450));
    }
}