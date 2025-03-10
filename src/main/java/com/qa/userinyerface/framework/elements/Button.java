package com.qa.userinyerface.framework.elements;

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
//todo
    public boolean isButtonEnabled() {
        return isElementEnabled();
    }
    public void clickButton(){
        click();
    }
}
