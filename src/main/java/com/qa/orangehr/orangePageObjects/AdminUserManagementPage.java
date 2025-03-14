package com.qa.orangehr.orangePageObjects;

import com.microsoft.playwright.Page;
import com.qa.framework.elements.DropDown;
import com.qa.framework.elements.TopBar;
import com.qa.framework.elements.TopBarBreadscrumb;
import com.qa.framework.modules.Table;
import java.util.List;

public class AdminUserManagementPage extends OrangeBasePage {
    private String userRoleDropDownSelector = "//div[contains(@class,'oxd-input-group') and .//label[text()='User Role']]"
            + "//div[@class='oxd-select-wrapper']";
    private String recordsFoundTableSelector = "//div[@class='oxd-table']";
    private String caretDownSelector = "//i[contains(@class, 'bi-caret-down-fill')]";
    private String dropDownOptionsWithoutDefaultSelector = "//div[@class='oxd-select-option']//span";
    private String dropDownOptionsWithDefaultSelector = "//div[@class='oxd-select-option']";

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
        getUserRoleDropDown().expandDropDown(caretDownSelector);
        return getUserRoleDropDown().getDropDownOptionsText(dropDownOptionsWithoutDefaultSelector);
    }

    public void chooseUserRoleDropDownOption(String option){
        getUserRoleDropDown().expandDropDown(caretDownSelector);
        getUserRoleDropDown().chooseDropDownOption(option, dropDownOptionsWithoutDefaultSelector);
    }

    public String getSetUserRoleDropDownOption(){
        return getUserRoleDropDown().getSetDropDownOption();
    }

    public void resetUserRoleDropDownOption(){
        getUserRoleDropDown().expandDropDown(caretDownSelector);
        getUserRoleDropDown().resetDropDownOptions(dropDownOptionsWithDefaultSelector);
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
