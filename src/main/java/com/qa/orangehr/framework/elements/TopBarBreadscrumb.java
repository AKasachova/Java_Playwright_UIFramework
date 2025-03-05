package com.qa.orangehr.framework.elements;

import com.microsoft.playwright.Page;

public class TopBarBreadscrumb extends Element{
    public String topBarBreadscrumbSelector;

    public TopBarBreadscrumb(Page page,String topBarBreadscrumbSelector) {
        super(page, topBarBreadscrumbSelector);
        this.topBarBreadscrumbSelector = topBarBreadscrumbSelector;
    }
}
