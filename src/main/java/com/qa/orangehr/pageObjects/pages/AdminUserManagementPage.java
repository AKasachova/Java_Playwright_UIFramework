package com.qa.orangehr.pageObjects.pages;

import com.microsoft.playwright.Page;
import com.qa.orangehr.pageObjects.elements.DropDown;
import com.qa.orangehr.pageObjects.modules.Table;

import java.util.List;

public class AdminUserManagementPage extends BasePage{

    public AdminUserManagementPage(Page page) {
        super(page);
    }

    private DropDown getUserRoleDropDown() {
        return new DropDown(page, "//div[contains(@class,'oxd-input-group') and .//label[text()='User Role']]//div[@class='oxd-select-wrapper']");
    }

    private Table getRecordsFoundTable(){
        return new Table(page, "//div[@class='oxd-table']");
    }

    public List<String> getAllUserRoleDropDownOptions() {
        getUserRoleDropDown().expandDropDown();
        return getUserRoleDropDown().getDropDownOptionsText();
    }

    public void chooseUserRoleDropDownOption(String option){
        getUserRoleDropDown().chooseDropDownOption(option);
    }

    public String getSetUserRoleDropDownOption(){
        return getUserRoleDropDown().getSetDropDownOption();
    }

    public void resetUserRoleDropDownOption(){
        getUserRoleDropDown().expandDropDown();
        getUserRoleDropDown().resetDropDownOptions();
    }

    public List<String> getColumnValuesForRecordsFoundTable(String columnName){
        return getRecordsFoundTable().getColumnValues(columnName);
    }

    public String getCellValueForRecordsFoundTable(String columnName, int rowIndex){
        return getRecordsFoundTable().getCellValue(columnName, rowIndex);
    }
}
