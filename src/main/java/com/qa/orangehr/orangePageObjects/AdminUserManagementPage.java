package com.qa.orangehr.orangePageObjects;

import com.microsoft.playwright.Page;
import com.qa.orangehr.framework.elements.DropDown;
import com.qa.orangehr.framework.elements.TopBar;
import com.qa.orangehr.framework.elements.TopBarBreadscrumb;
import com.qa.orangehr.framework.modules.Table;
import java.util.List;

public class AdminUserManagementPage extends OrangeBasePage {
    private String userRoleDropDownSelector = "//div[contains(@class,'oxd-input-group') and .//label[text()='User Role']]"
            + "//div[@class='oxd-select-wrapper']";
    private String recordsFoundTableSelector = "//div[@class='oxd-table']";

    public AdminUserManagementPage(Page page) {
        super(page);
    }

    private DropDown getUserRoleDropDown() {
        return new DropDown(page, userRoleDropDownSelector);
    }

    private Table getRecordsFoundTable(){
        return new Table(page, recordsFoundTableSelector);
    }

    protected TopBar topBar = new TopBar(page,topBarSelector, new TopBarBreadscrumb(page, topBarBreadscrumbSelector));


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

    public String getTopBarText(){
        return topBar.getTopBarBreadscrumbsText();
    }
}
