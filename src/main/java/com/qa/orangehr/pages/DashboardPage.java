package com.qa.orangehr.pages;

import com.microsoft.playwright.Page;
import com.qa.orangehr.elements.DropDownElement;
import com.qa.orangehr.elements.Element;

public class DashboardPage extends BasePage{
    public String userDropDownXPath = "//li[contains(@class, 'oxd-userdropdown')]";

    public DashboardPage(Page page) {
        super(page);
    }

    public DropDownElement getUserDropDown(){
        return new DropDownElement(page, userDropDownXPath);
    }

    public String getUserDropDownOptionsXPath(){
        return String.format("%s//ul[@role='menu']//li",  this.userDropDownXPath);
    }

    public Element getOptionInSearch(String option) {
        return new Element(page, String.format("//a//*[text()='%s']", option));
    }

    public void clickOptionInSearch(String option){
        getOptionInSearch(option).waitForXPathToBeAvailable();
        getOptionInSearch(option).click();
    }


    public void chooseUserDropDownOption(String option){
        getUserDropDown().chooseDropDownOption(option, getUserDropDownOptionsXPath());
    }

    public void logOutFromTheApp(){
        chooseUserDropDownOption("Logout");
    }
}
