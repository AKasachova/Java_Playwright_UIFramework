package com.qa.orangehr.elements;

import com.microsoft.playwright.Page;

public class Button extends Element {
    private String buttonSelector;

    public Button(Page page, String buttonSelector) {
        super(page, buttonSelector);
        this.buttonSelector = buttonSelector;
    }

    public Button(Page page, String buttonSelector, String comment) {
        super(page, buttonSelector, comment);
        this.buttonSelector = buttonSelector;
    }

    public void clickButton(){
        click();
    }
}
