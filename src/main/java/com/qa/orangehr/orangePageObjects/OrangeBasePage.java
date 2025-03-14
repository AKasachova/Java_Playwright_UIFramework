package com.qa.orangehr.orangePageObjects;

import com.microsoft.playwright.Page;
import com.qa.framework.pages.BasePage;

public class OrangeBasePage extends BasePage {
    protected String topBarSelector = "//header/div[contains(@class,'oxd-topbar-header')]";
    protected String topBarBreadscrumbSelector = String.format("%s//span[contains(@class,'oxd-topbar-header-breadcrumb')]/h6"
            , topBarSelector);

    public OrangeBasePage(Page page) {
        super(page);
    }
}
