package com.qa.orangehr.framework.pages;

import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;
    protected String topBarSelector = "//header/div[contains(@class,'oxd-topbar-header')]";
    protected String topBarBreadscrumbSelector = String.format("%s//span[contains(@class,'oxd-topbar-header-breadcrumb')]/h6"
            , topBarSelector);

    public BasePage(Page page) {
        this.page = page;
    }
}
