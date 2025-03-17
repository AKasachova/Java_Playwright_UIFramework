package com.qa.userinyerface.base.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.qa.framework.manager.BrowserManager;
import com.qa.framework.manager.ContextManager;
import com.qa.userinyerface.userinyerfacePageObjects.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    private static Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected HomePage homePage;

    @BeforeAll
    public static void setUpTestSuit() {
        browser = BrowserManager.getBrowser();
    }

    @BeforeEach
    public void setUpContextAndPage() {
        page = ContextManager.getNewPage(browser, "urlUserinyerface", "Userinyerface");
        homePage = new HomePage(page);
    }

    @AfterEach
    public void tearDown() {
        ContextManager.closeContext();
    }

    @AfterAll
    public static void tearDownTests(){
        BrowserManager.closeBrowser();
    }
}
