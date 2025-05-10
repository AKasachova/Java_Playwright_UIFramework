package com.qa.framework.elements;

import com.microsoft.playwright.Page;

public class DropDownMenu extends DropDown {
    private String dropDownMenuSelector;

    public DropDownMenu(Page page, String dropDownMenuSelector){
        super(page, dropDownMenuSelector);
        this.dropDownMenuSelector = dropDownMenuSelector;
    }

    @Override
    public String getDropDownOptionsWithoutDefaultXPath(String dropDownOptionsWithoutDefaultSelector){
        return String.format("%s" + dropDownOptionsWithoutDefaultSelector,  this.dropDownMenuSelector);
    }
}
