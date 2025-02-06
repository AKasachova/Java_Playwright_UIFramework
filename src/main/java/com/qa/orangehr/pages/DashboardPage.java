package com.qa.orangehr.pages;

import com.microsoft.playwright.Page;
import com.qa.orangehr.elements.Element;

public class DashboardPage extends BasePage{
    private Element userDropDown;
    private Element logOutLink;

    public DashboardPage(Page page) {
        super(page);
    }

    public Element getUserDropDown() {
        userDropDown = new Element(page, "//div[@class='oxd-topbar-header-userarea']//li[@class = 'oxd-userdropdown']");
        return userDropDown;
    }

    public Element getLogOutLink(){
        logOutLink = new Element(page, "//ul[@role='menu']//li[.//a[contains(text(),'Logout')]]");
        return logOutLink;
    }

    public LoginPage getLoginPageAfterlogout(){
        getUserDropDown().click();
        getLogOutLink().click();
        return new LoginPage(page);
    }
}
