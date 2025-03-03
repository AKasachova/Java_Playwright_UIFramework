package com.qa.orangehr.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.qa.orangehr.utils.factory.PlaywrightFactory;
import com.qa.orangehr.pageObjects.pages.LoginPage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Properties;

public class BaseTest {
    private static Browser browser;
    protected static Properties prop;
    private static PlaywrightFactory pf;
    protected BrowserContext context;
    protected Page page;
    protected LoginPage loginPage;

    @BeforeAll
    public static void setUpTestSuit(){
        pf = new PlaywrightFactory();
        prop = pf.getProp();
        browser = pf.getBrowser(prop);
    }

    @BeforeEach
    public void setUpContextAndPage(){
        page = pf.getNewContextAndPage(browser);
        loginPage = new LoginPage(page);
    }

    @AfterEach
    public void tearDown(){
        page.context().close();
    }

    @AfterAll
    public static void tearDownTests(){
        browser.close();
    }

    public void logIn(String userName, String password){
        loginPage.fillUserNameField(userName);
        loginPage.fillPasswordField(password);
        loginPage.clickSubmitButton();
    }

    public void logInAsAdmin(){
        logIn(prop.getProperty("userNameAdmin"), prop.getProperty("passwordAdmin"));
    }
}
