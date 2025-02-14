package com.qa.orangehr.pageObjects.pages;

import com.microsoft.playwright.Page;
import com.qa.orangehr.pageObjects.elements.Element;
import com.qa.orangehr.pageObjects.elements.MenuElement;

public class DashboardPage extends BasePage{

    public DashboardPage(Page page) {
        super(page);
    }

    public MenuElement getUserMenu(){
        return new MenuElement(page, "//li[contains(@class, 'oxd-userdropdown')]");
    }

    public boolean isUserMenuVisible(){
        return getUserMenu().isVisible();
    }

    public Element getOptionInSearch(String option) {
        return new Element(page, String.format("//a//*[text()='%s']", option));
    }

    public void clickOptionInSearch(String option){
        getOptionInSearch(option).waitForXPathToBeAvailable();
        getOptionInSearch(option).click();
    }

    public void logOutFromTheApp(){
        getUserMenu().chooseDropDownOption("Logout");
    }
}
