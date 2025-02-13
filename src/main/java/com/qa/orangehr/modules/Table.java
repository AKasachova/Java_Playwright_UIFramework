package com.qa.orangehr.modules;

import com.microsoft.playwright.Page;
import com.qa.orangehr.elements.Element;

import java.util.List;

public class Table extends Element {
   private final String tableXPath;

   public Table(Page page,String tableXPath){
        super(page,tableXPath);
        this.tableXPath = tableXPath;
    }

    public List<String> getColumnValues(String columnName){
       String headerColumnXPath = String.format("%s//div[@role='columnheader' and text()='%s']", this.tableXPath, columnName);
       String columnValuesXPath = String.format("%s//div[@class='oxd-table-body']//div[@role='row']/div[count(%s/preceding-sibling::div) + 1]", this.tableXPath,headerColumnXPath);
       return page.locator(columnValuesXPath).allInnerTexts();
    }

    public String getCellValue(String columnName, int rowIndex){
        String headerColumnXPath = String.format("%s//div[@role='columnheader' and text()='%s']", this.tableXPath, columnName);
        String cellXPath = String.format("(%s//div[@class='oxd-table-body']//div[@role='row'])[%d]/div[count(%s/preceding-sibling::div) + 1]", this.tableXPath, rowIndex, headerColumnXPath);
        return page.locator(cellXPath).innerText();
    }
}
