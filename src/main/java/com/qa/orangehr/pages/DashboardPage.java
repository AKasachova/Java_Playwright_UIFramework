package com.qa.orangehr.pages;

import com.microsoft.playwright.Page;
import com.qa.orangehr.elements.DropDownElement;
import com.qa.orangehr.elements.Element;

public class DashboardPage extends BasePage{

    public DashboardPage(Page page) {
        super(page);
    }

    public DropDownElement getUserDropDown() {
        return new DropDownElement(page, "//div[@class='oxd-topbar-header-userarea']//li[@class = 'oxd-userdropdown']", "//div[@class='oxd-topbar-header-userarea']//li[@class = '--active oxd-userdropdown']//ul[@role='menu']//li", "");
    }

    public Element getAdminOptionInSearch() {
        return new Element(page, "//a//*[text()='Admin']");
    }

    public void clickAdminOptionInSearch(){
        getAdminOptionInSearch().waitForXPathToBeAvailable();
        getAdminOptionInSearch().click();
    }
}
