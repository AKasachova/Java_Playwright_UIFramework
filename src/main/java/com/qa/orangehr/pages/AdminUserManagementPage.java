package com.qa.orangehr.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.orangehr.elements.DropDownElement;
import com.qa.orangehr.elements.Element;
import java.util.List;

public class AdminUserManagementPage extends BasePage{
//    private String recordsFoundTable = "//div[@class= 'oxd-table-body']";
//    private String recordsFoundTableRow = "//div[contains(@class, 'oxd-table-card')]";
//    private String recordsFoundTableColumn = "//div[contains(@class, 'oxd-table-cell')]";
    private final String dropDownXPath = "//div[contains(@class,'oxd-input-group') and .//label[text()='User Role']]//div[@class='oxd-select-wrapper']";

    public AdminUserManagementPage(Page page) {
        super(page);
    }

    public DropDownElement getUserRoleDropDown() {
        return new DropDownElement(page, dropDownXPath);
    }
    public Element getUserRoleDropDownCaretDown(){
        return new Element(page, "//div[contains(@class,'oxd-input-group') and .//label[text()='User Role']]//i[contains(@class, 'bi-caret-down-fill')]");
    }

    public String getUserRoleOptionsWithoutDefaultXPath(){
        return String.format("%s//div[@class='oxd-select-option']//span",  this.dropDownXPath);
    }

    public String getUserRoleOptionsWithDefaultXPath(){
        return String.format("%s//div[@class='oxd-select-option']",  this.dropDownXPath);
    }

    public void expandUserRoleDropDown(){
        getUserRoleDropDown().expandDropDown(getUserRoleDropDownCaretDown());
    }

    public List<Locator> getAllUserDropDownOptions(){
        return getUserRoleDropDown().getAllDropDownOptions(getUserRoleOptionsWithoutDefaultXPath());
    }

    public List<String> getUserRoleDropDownOptionsText(){
        return getUserRoleDropDown().getDropDownOptionsText(getUserRoleOptionsWithoutDefaultXPath());
    }

    public  void chooseUserRoleDropDownOption(String optionToChoose){
        getUserRoleDropDown().chooseDropDownOption(optionToChoose, getUserRoleOptionsWithoutDefaultXPath());
    }

    public String getSetUserRoleDropDownOption(){
        return getUserRoleDropDown().getSetDropDownOption();
    }

    public void resetUserRoleDropDownOptions(){
        getUserRoleDropDown().resetDropDownOptions(getUserRoleOptionsWithDefaultXPath());
    }

//    public String getRecordsFoundTableCellValue(int rowIndex, int colIndex) throws InterruptedException {
//        TableElement foundTable = new TableElement(page, recordsFoundTable);
//        return foundTable.getTableCellValue(this.recordsFoundTableRow, this.recordsFoundTableColumn, rowIndex, colIndex);
//    }

}
