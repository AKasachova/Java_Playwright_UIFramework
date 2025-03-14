package com.qa.orangehr.orangePageObjects;

import com.microsoft.playwright.Page;
import com.qa.framework.elements.Element;
import com.qa.framework.elements.DropDownMenu;

public class DashboardPage extends OrangeBasePage {
    private String dropDownMenuSelector = "//li[contains(@class, 'oxd-userdropdown')]";

    public DashboardPage(Page page) {
        super(page);
    }

    private DropDownMenu getUserMenu(){
        return new DropDownMenu(page, dropDownMenuSelector);
    }

    private Element getOptionInSearch(String option) {
        return new Element(page, String.format("//a//*[text()='%s']", option));
    }

    public boolean isUserMenuVisible(){
        return getUserMenu().isVisible();
    }

    public void clickOptionInSearch(String option){
        getOptionInSearch(option).waitForElementToBeAvailable();
        getOptionInSearch(option).click();
    }

    public void logOutFromTheApp(){
        getUserMenu().chooseDropDownOption("Logout");
    }
}
