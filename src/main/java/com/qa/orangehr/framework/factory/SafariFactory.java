package com.qa.orangehr.framework.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class SafariFactory implements BrowserFactory {
    @Override
    public Browser createBrowser(Playwright playwright) {
        return playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)
                .setSlowMo(450));
    }
}
