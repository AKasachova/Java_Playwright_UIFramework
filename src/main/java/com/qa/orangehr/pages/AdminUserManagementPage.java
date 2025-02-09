package com.qa.orangehr.pages;

import com.microsoft.playwright.Page;
import com.qa.orangehr.elements.DropDownElement;
import com.qa.orangehr.elements.TableElement;

public class AdminUserManagementPage extends BasePage{
    private String recordsFoundTable = "//div[@class= 'oxd-table-body']";
    private String recordsFoundTableRow = "//div[contains(@class, 'oxd-table-card')]";
    private String recordsFoundTableColumn = "//div[contains(@class, 'oxd-table-cell')]";

    public AdminUserManagementPage(Page page) {
        super(page);
    }

    public DropDownElement getUserRoleDropDown() {
        return new DropDownElement(page, "//div[contains(@class,'oxd-input-group') and .//label[text()='User Role']]//div[@class='oxd-select-wrapper']", "//div[contains(@class,'oxd-input-group') and .//label[text()='User Role']]//div[@class='oxd-select-option']","//div[contains(@class, 'oxd-select-dropdown')]//*[self::div or self::span]");
    }

    public String getRecordsFoundTableCellValue(int rowIndex, int colIndex) throws InterruptedException {
        TableElement foundTable = new TableElement(page, recordsFoundTable);
        return foundTable.getTableCellValue(this.recordsFoundTableRow, this.recordsFoundTableColumn, rowIndex, colIndex );
    }
}
