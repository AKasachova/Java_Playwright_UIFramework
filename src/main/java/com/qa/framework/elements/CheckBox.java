package com.qa.framework.elements;

import com.microsoft.playwright.Page;

public class CheckBox extends Element {
    private String checkBoxSelector;

    public CheckBox(Page page, String checkBoxSelector) {
        super(page, checkBoxSelector);
        this.checkBoxSelector = checkBoxSelector;
    }

    private Element getCheckBoxIcon(String checkBoxIconSelector) {
        return new Element(page, String.format("%s" + checkBoxIconSelector, checkBoxSelector));
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