package com.qa.orangehr.pages;

import com.microsoft.playwright.Page;
import com.qa.orangehr.elements.Element;

public class DashboardPage extends BasePage{

    public DashboardPage(Page page) {
        super(page);
    }

    public Element getUserDropDown() {
        return new Element(page, "//div[@class='oxd-topbar-header-userarea']//li[@class = 'oxd-userdropdown']");
    }

    public Element getLogOutLink(){
        return new Element(page, "//ul[@role='menu']//li[.//a[contains(text(),'Logout')]]");
    }

    public void expandUserDropDown(){
        getUserDropDown().click();
    }

    public void clickLinkToLogout(){
        getLogOutLink().click();
    }
}
