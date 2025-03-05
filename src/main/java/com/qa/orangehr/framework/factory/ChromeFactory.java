package com.qa.orangehr.framework.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class ChromeFactory implements BrowserFactory {
    @Override
    public Browser createBrowser(Playwright playwright) {
        return playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome")
                .setHeadless(false).setSlowMo(1000));
    }
}
