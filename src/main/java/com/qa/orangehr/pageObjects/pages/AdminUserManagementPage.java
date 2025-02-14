package com.qa.orangehr.pageObjects.pages;

import com.microsoft.playwright.Page;
import com.qa.orangehr.pageObjects.elements.DropDownElement;
import com.qa.orangehr.pageObjects.modules.Table;

public class AdminUserManagementPage extends BasePage{

    public AdminUserManagementPage(Page page) {
        super(page);
    }

    public DropDownElement getUserRoleDropDown() {
        return new DropDownElement(page, "//div[contains(@class,'oxd-input-group') and .//label[text()='User Role']]//div[@class='oxd-select-wrapper']");
    }

    public Table getRecordsFoundTable(){
        return new Table(page, "//div[@class= 'oxd-table']");
    }
}
