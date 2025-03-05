package com.qa.orangehr.framework.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class FirefoxFactory implements BrowserFactory {
    @Override
    public Browser createBrowser(Playwright playwright) {
        return playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)
                .setSlowMo(450));
    }
}