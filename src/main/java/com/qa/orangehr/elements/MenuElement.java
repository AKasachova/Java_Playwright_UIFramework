package com.qa.orangehr.elements;

import com.microsoft.playwright.Page;

public class MenuElement extends DropDownElement{
    private String menuXPath;

    public MenuElement(Page page,String menuXPath){
        super(page, menuXPath);
        this.menuXPath = menuXPath;
    }

    @Override
    public String getDropDownOptionsWithoutDefaultXPath(){
        return String.format("%s//ul[@role='menu']//li",  this.menuXPath);
    }
}
