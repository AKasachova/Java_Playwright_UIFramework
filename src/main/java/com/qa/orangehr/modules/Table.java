package com.qa.orangehr.modules;

import com.microsoft.playwright.Page;
import com.qa.orangehr.elements.Element;

import java.util.List;

public class Table extends Element {
   private final String tableSelector;

   public Table(Page page,String tableSelector){
        super(page, tableSelector);
        this.tableSelector = tableSelector;
    }

    public List<String> getColumnValues(String columnName){
       String headerColumnXPath = String.format("%s//div[@role='columnheader' and text()='%s']", this.tableSelector, columnName);
       String columnValuesXPath = String.format("%s//div[@class='oxd-table-body']//div[@role='row']/div[count(%s/preceding-sibling::div) + 1]", this.tableSelector,headerColumnXPath);
       return page.locator(columnValuesXPath).allInnerTexts();
    }

    public String getCellValue(String columnName, int rowIndex){
        String headerColumnXPath = String.format("%s//div[@role='columnheader' and text()='%s']", this.tableSelector, columnName);
        String cellXPath = String.format("(%s//div[@class='oxd-table-body']//div[@role='row'])[%d]/div[count(%s/preceding-sibling::div) + 1]", this.tableSelector, rowIndex, headerColumnXPath);
        return page.locator(cellXPath).innerText();
    }
}
