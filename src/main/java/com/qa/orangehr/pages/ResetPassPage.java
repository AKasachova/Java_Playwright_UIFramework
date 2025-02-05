package com.qa.orangehr.pages;

import com.microsoft.playwright.Page;

public class ResetPassPage {
    private Page page;
    private String userNameField = "//input[@placeholder='Username']";
    private String resetPasswordButton = "//button[@type = 'submit']";

    public ResetPassPage(Page page) {
        this.page = page;
    }

    public SendPasswordReset sendPasswordReset(String userName){
        page.fill(userNameField, userName);
        page.click(resetPasswordButton);
        return new SendPasswordReset(page);
    }
}
