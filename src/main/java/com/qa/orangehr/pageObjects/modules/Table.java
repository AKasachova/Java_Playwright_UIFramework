package com.qa.orangehr.pageObjects.modules;

import com.microsoft.playwright.Page;
import com.qa.orangehr.pageObjects.elements.Element;

import java.util.List;

public class Table extends Element {
   private final String tableXPath;

   public Table(Page page,String tableXPath){
        super(page,tableXPath);
        this.tableXPath = tableXPath;
    }

    public String getHeaderXPath(String columnName){
        return String.format("%s//div[@role='columnheader' and text()='%s']", this.tableXPath, columnName);
    }

    public String getColumnXPath(String columnName) {
        return String.format("%s//div[@class='oxd-table-body']//div[@role='row']/div[count(%s/preceding-sibling::div) + 1]", this.tableXPath, getHeaderXPath(columnName));
    }

    public String getCellXPath(String columnName, int rowIndex){
        return String.format("(%s//div[@class='oxd-table-body']//div[@role='row'])[%d]/div[count(%s/preceding-sibling::div) + 1]", this.tableXPath, rowIndex, columnName);
    }

    public List<String> getColumnValues(String columnName){
       return page.locator( getColumnXPath(columnName)).allInnerTexts();
    }

    public String getCellValue(String columnName, int rowIndex){
       return page.locator(getCellXPath(columnName,rowIndex)).innerText();
    }
}
