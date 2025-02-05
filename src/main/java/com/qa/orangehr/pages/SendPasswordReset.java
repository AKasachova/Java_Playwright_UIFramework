package com.qa.orangehr.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SendPasswordReset {
    private Page page;
    private String sucessfullsentPassTitle = "//div[@class = 'orangehrm-card-container']/h6";

    public SendPasswordReset(Page page) {
        this.page = page;
    }

    public Locator getResetMessageTitle(){
        return page.locator(sucessfullsentPassTitle);
    }
}
