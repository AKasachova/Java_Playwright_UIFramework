package com.qa.orangehr.pages;

import com.microsoft.playwright.Page;
import com.qa.orangehr.elements.Element;
//import lombok.Getter;

public class LoginPage extends BasePage{
    //@Getter -- experiment:)
//    private  String userNameField = "//input[@name = 'username']";
    private Element logo;
    private Element userNameField;
    private Element passwordField;
    private Element submitButton;
    private Element validationMessageForCreds;


    public LoginPage(Page page){
        super(page);
    }

    public Element getLogo(){
        logo = new Element(page, "//div[@class='orangehrm-login-branding']");
        return logo;
    }

    public Element getUserNameField(){
        userNameField = new Element(page, "//input[@name = 'username']");
        return userNameField;
    }

    public Element getPasswordField(){
        passwordField = new Element(page,"//input[@type = 'password']");
        return passwordField;
    }

    public Element getSubmitButton(){
        submitButton = new Element(page, "button[type = 'submit']");
        return submitButton;
    }

    public Element getValidationMessageForCreds(){
        validationMessageForCreds = new Element(page, "//div[@class='orangehrm-login-error']//p[contains(@class,'oxd-alert-content-text')]");
        return validationMessageForCreds;
    }

    public DashboardPage getDashboardPage(String userName, String password) {
        getUserNameField().fillField(userName);
        getPasswordField().fillField(password);
        getSubmitButton().click();
        return new DashboardPage(page);
    }

    public String getValidationMessageForCreds(String userName, String password) {
        getUserNameField().fillField(userName);
        getPasswordField().fillField(password);
        getSubmitButton().click();
        validationMessageForCreds = getValidationMessageForCreds();
        validationMessageForCreds.waitForXPathToBeAvailable();

        return validationMessageForCreds.getTextContent();
    }
}
