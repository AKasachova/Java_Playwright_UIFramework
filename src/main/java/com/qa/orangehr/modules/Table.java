//package com.qa.orangehr.modules;
//
//import com.microsoft.playwright.Page;
//import com.qa.orangehr.elements.Element;
//
//public class Table extends Element {
//    private final String tableXPath;
//
//    public Table(Page page,String tableXPath){
//        super(page,tableXPath);
//        this.tableXPath = tableXPath;
//    }
//
//    public String getTableCellValue(String tableRowXPath, String tableColumnXPath, int rowXPath, int colIndex) throws InterruptedException {
//        String cellXPath = String.format(
//                "%s%s[count(preceding-sibling::*) + 1 = %d]%s[count(preceding-sibling::*) = %d]/div",
//                this.tableXPath,tableRowXPath, rowXPath, tableColumnXPath, colIndex);
//
//        Element cell = new Element(page,cellXPath);
//        cell.waitForXPathToBeAvailable();
//        return cell.getTextContent();
//    }
//}
