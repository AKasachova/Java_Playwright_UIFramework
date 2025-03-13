package com.qa.userinyerface.framework.elements;

import com.microsoft.playwright.Page;

public class CheckBox extends Element {
    private String checkBoxSelector;
    private String checkBoxTextSelector = String.format("%s//span[string-length(normalize-space(.)) > 0]", checkBoxSelector);

    public CheckBox(Page page, String checkBoxSelector) {
        super(page, checkBoxSelector);
        this.checkBoxSelector = checkBoxSelector;
    }


    public void clickOnCheckBox() {
        click();
    }

    public String getCheckBoxText() {
      return page.locator(checkBoxTextSelector).textContent();
    }

}
