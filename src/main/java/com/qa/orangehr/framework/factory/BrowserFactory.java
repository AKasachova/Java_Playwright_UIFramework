package com.qa.orangehr.framework.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

public interface BrowserFactory {
    Browser createBrowser(Playwright playwright);
}
