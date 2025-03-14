package com.qa.framework.elements;

import com.microsoft.playwright.Page;

public class CheckBox extends Element {
    private String checkBoxSelector;

    public CheckBox(Page page, String checkBoxSelector) {
        super(page, checkBoxSelector);
        this.checkBoxSelector = checkBoxSelector;
    }


    public void clickOnCheckBox() {
        click();
    }

    public String getCheckBoxText(String checkBoxTextSelector) {
        return page.locator(String.format("%s" + checkBoxTextSelector, checkBoxSelector)).textContent();
    }

}