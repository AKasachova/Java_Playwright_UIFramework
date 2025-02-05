package com.qa.orangehr.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private  Page page;
    private  Locator pageLogo;
    private  Locator userNameField;
    private  Locator passwordField;
    private  String submitButton = "button[type = 'submit']";
    private Locator forgotPasswordLink;

    public LoginPage(Page page) {
        this.page = page;

        this.pageLogo = page.locator("//img[@alt = 'company-branding']");

        //this.userNameField = "input[name = 'username']";
        this.userNameField = page.locator("//input[@name = 'username']");

        //this.passwordField = page.locator("input[name = 'password']");
        this.passwordField = page.locator("//input[@type = 'password']");

        this.forgotPasswordLink = page.locator("//div[@class='orangehrm-login-forgot']");
    }

    public Locator getPageLogoImg() {
        return this.pageLogo;
    }

    public DashboardPage submitLoginForm(String userName, String password) {
        userNameField.fill(userName);
        passwordField.fill(password);
        page.click(submitButton);
        return new DashboardPage(page);
    }

    public ResetPassPage navigateToResetPass() {
        forgotPasswordLink.click();
        return new ResetPassPage(page);
    }
}
