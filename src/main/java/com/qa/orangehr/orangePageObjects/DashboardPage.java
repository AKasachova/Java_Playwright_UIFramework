package com.qa.orangehr.orangePageObjects;

import com.microsoft.playwright.Page;
import com.qa.orangehr.framework.elements.Element;
import com.qa.orangehr.framework.elements.DropDownMenu;
import com.qa.orangehr.framework.pages.BasePage;

public class DashboardPage extends BasePage {

    public DashboardPage(Page page) {
        super(page);
    }

    private DropDownMenu getUserMenu(){
        return new DropDownMenu(page,
                "//li[contains(@class, 'oxd-userdropdown')]");
    }
    //will not implement separate wrapper
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
