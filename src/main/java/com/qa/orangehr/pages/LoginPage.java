package com.qa.orangehr.pages;

import com.microsoft.playwright.Page;
import com.qa.orangehr.elements.Element;

public class LoginPage extends BasePage{

    public LoginPage(Page page){
        super(page);
    }

    public Element getLogo(){
        return new Element(page, "//div[@class='orangehrm-login-branding']");
    }

    public Element getUserNameField(){
        return new Element(page, "//input[@name = 'username']");
    }

    public Element getPasswordField(){
        return new Element(page,"//input[@type = 'password']");
    }

    public Element getSubmitButton(){
        return new Element(page, "button[type = 'submit']");
    }

    public Element getValidationMessageForCreds(){
        return new Element(page, "//div[@class='orangehrm-login-error']//p[contains(@class,'oxd-alert-content-text')]");
    }

    public void fillUserNameField(String userName){
        getUserNameField().fillField(userName);
    }

    public void fillPasswordField(String password){
        getPasswordField().fillField(password);
    }

    public void clickSubmitButton(){
        getSubmitButton().click();
    }

    public String getValidationMessageTextForCreds() {
        Element validationMessageForCreds = getValidationMessageForCreds();
        validationMessageForCreds.waitForXPathToBeAvailable();
        return validationMessageForCreds.getTextContent();
    }
}
