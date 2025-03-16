package com.qa.framework.elements;

import com.microsoft.playwright.Page;

public class CheckBox extends Element {
    private String checkBoxSelector;

    public CheckBox(Page page, String checkBoxSelector) {
        super(page, checkBoxSelector);
        this.checkBoxSelector = checkBoxSelector;
    }


    private Element getCheckBoxIcon(String checkBoxIcontSelector) {
        return new Element(page, String.format("%s" + checkBoxIcontSelector, checkBoxSelector));
    }

    public String getCheckBoxText(String checkBoxTextSelector) {
        return page.locator(String.format("%s" + checkBoxTextSelector, checkBoxSelector)).textContent();
    }

    public void clickOnCheckBoxIcon(String checkBoxIconSelector) {
        getCheckBoxIcon(checkBoxIconSelector).click();
    }

    public void clickOnCheckBox() {
        click();
    }

}