package com.qa.orangehr.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.qa.orangehr.orangePageObjects.LoginPage;
import com.qa.orangehr.framework.utils.config.ConfigUtils;

import com.qa.orangehr.framework.manager.BrowserManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    private static Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected LoginPage loginPage;

    protected String userNameInvalid = "userName";
    protected String passwordInvalid = "password";

    @BeforeAll
    public static void setUpTestSuit(){
        browser = BrowserManager.getBrowser();
    }

    @BeforeEach
    public void setUpContextAndPage(){
        context = BrowserManager.getBrowserContext(browser);
        page = BrowserManager.getNewPage(context);
        loginPage = new LoginPage(page);
    }

    @AfterEach
    public void tearDown(){

        BrowserManager.closeContext();
    }

    @AfterAll
    public static void tearDownTests(){
        BrowserManager.closeBrowser();
    }

    public void logInAsAdmin(){
        loginPage.fillUserNameField(ConfigUtils.getConfigProperties().getProperty("userNameAdmin"));
        loginPage.fillPasswordField(ConfigUtils.getConfigProperties().getProperty("passwordAdmin"));
        loginPage.clickSubmitButton();
    }
}
