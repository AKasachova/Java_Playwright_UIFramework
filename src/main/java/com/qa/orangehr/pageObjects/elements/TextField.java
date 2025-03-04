package com.qa.orangehr.pageObjects.elements;

import com.microsoft.playwright.Page;

public class TextField extends Element {
    private String textFieldSelector;

    public TextField(Page page, String textFieldSelector) {
        super(page, textFieldSelector);
        this.textFieldSelector = textFieldSelector;
    }

    public void fillTextField(String text){
        fillField(text);
    }
}
