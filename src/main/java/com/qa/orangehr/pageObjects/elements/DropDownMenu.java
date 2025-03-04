package com.qa.orangehr.pageObjects.elements;

import com.microsoft.playwright.Page;

public class DropDownMenu extends DropDown {
    private String dropDownMenuSelector;

    public DropDownMenu(Page page, String dropDownMenuSelector){
        super(page, dropDownMenuSelector);
        this.dropDownMenuSelector = dropDownMenuSelector;
    }

    @Override
    public String getDropDownOptionsWithoutDefaultXPath(){
        return String.format("%s//ul[@role='menu']//li",  this.dropDownMenuSelector);
    }
}
