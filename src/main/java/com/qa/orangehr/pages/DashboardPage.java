package com.qa.orangehr.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPage extends BasePage{
    private Page page;
    private String userDropDown = "//li[@class = 'oxd-userdropdown']";
    private String logOutLink = "//ul[.//a[contains(text(),'Logout')]]";

    public DashboardPage(Page page) {
        super(page);
    }

    public LoginPage logout(){
        page.locator(userDropDown).click();
        page.locator(logOutLink).click();
        return new LoginPage(page);
    }
}
