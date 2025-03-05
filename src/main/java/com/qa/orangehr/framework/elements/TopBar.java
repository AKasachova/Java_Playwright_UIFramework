package com.qa.orangehr.framework.elements;

import com.microsoft.playwright.Page;

public class TopBar extends Element{
    private String topBarSelector;
    private TopBarBreadscrumb topBarBreadscrumb;

    public TopBar(Page page, String topBarSelector, String topBarBreadscrumbSelector) {
      super(page, topBarSelector);
      this.topBarSelector = topBarSelector;
      this.topBarBreadscrumb =  new TopBarBreadscrumb(page, topBarBreadscrumbSelector);
    }

    public String getTopBarBreadscrumbsText() {
        topBarBreadscrumb.waitForElementToBeAvailable();
        return  topBarBreadscrumb.getTextContent();
    }
}
