package com.qa.framework.elements;

import com.microsoft.playwright.Page;

public class Link extends Element {
    private String linkSelector;

    public Link(Page page, String linkSelector) {
        super(page, linkSelector);
        this.linkSelector = linkSelector;
    }

    public void clickLink(){
        click();
    }
}
