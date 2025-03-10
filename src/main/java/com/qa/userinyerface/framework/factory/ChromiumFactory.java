package com.qa.userinyerface.framework.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class ChromiumFactory implements BrowserInterface {
    @Override
    public Browser createBrowser(Playwright playwright) {
        return playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                    .setSlowMo(450));
        }
    }
