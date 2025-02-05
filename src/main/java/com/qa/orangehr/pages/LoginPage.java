package com.qa.orangehr.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage{
    //private  Page page;
    private  String pageLogo = "//img[@alt = 'company-branding']";
    private  String userNameField = "//input[@name = 'username']";
    private  String passwordField = "//input[@type = 'password']";
    private  String submitButton = "button[type = 'submit']";
    private String forgotPasswordLink = "//div[@class='orangehrm-login-forgot']";

    public LoginPage(Page page){
        super(page);
    }

    public Locator getPageLogoImg() {
        return page.locator(pageLogo);
    }

    public DashboardPage submitLoginForm(String userName, String password) {
        page.locator(userNameField).fill(userName);
        page.locator(passwordField).fill(password);
        page.click(submitButton);
        return new DashboardPage(page);
    }

}
