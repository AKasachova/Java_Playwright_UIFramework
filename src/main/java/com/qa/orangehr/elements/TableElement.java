package com.qa.orangehr.elements;

import com.microsoft.playwright.Page;

public class TableElement extends Element {
    private final String tableXPath;

    public TableElement(Page page,String tableXPath){
        super(page,tableXPath);
        this.tableXPath = tableXPath;
    }

    public String getTableCellValue(String tableRowXPath, String tableColumnXPath, int rowIndex, int colIndex) throws InterruptedException {
        String cellXPath = String.format(
                        "%s%s[count(preceding-sibling::*) + 1 = %d]%s[count(preceding-sibling::*) = %d]/div",
                this.tableXPath,tableRowXPath, rowIndex, tableColumnXPath, colIndex);
        Element cell = new Element(page,cellXPath);
        page.evaluate("window.scrollTo(0, document.body.scrollHeight)");
        cell.waitForXPathToBeAvailable();
            return cell.getTextContent();
        }
}
