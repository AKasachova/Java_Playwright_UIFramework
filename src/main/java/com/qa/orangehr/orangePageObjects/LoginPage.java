package com.qa.orangehr.orangePageObjects;

import com.microsoft.playwright.Page;
import com.qa.framework.elements.Button;
import com.qa.framework.elements.Element;
import com.qa.framework.elements.Message;
import com.qa.framework.elements.TextField;

public class LoginPage extends OrangeBasePage {
    private String logoSelector = "//div[@class='orangehrm-login-branding']";
    private String userNameFieldSelector = "//input[@name = 'username']";
    private String passwordFieldSelector = "//input[@type = 'password']";
    private String submitButtonSelector = "button[type = 'submit']";
    private String validationMessageForCredsSelector = "//div[@class='orangehrm-login-error']" +
            "//p[contains(@class,'oxd-alert-content-text')]";

    public LoginPage(Page page){
        super(page);
    }

    private Element getLogo(){
        return new Element(page, logoSelector);
    }

    private TextField getUserNameField(){
        return new TextField(page, userNameFieldSelector);
    }

    private TextField getPasswordField(){
        return new TextField(page, passwordFieldSelector);
    }

    private Button getSubmitButton(){
        return new Button(page, submitButtonSelector, "Submit Login form button");
    }

    private Message getValidationMessageForCreds(){
        return new Message(page, validationMessageForCredsSelector);
    }

    public boolean isLogoVisible(){
        return getLogo().isVisible();
    }

    public void fillUserNameField(String userName){
        getUserNameField().fillTextField(userName);
    }

    public void fillPasswordField(String password){
        getPasswordField().fillTextField(password);
    }

    public void clickSubmitButton(){
        getSubmitButton().clickButton();
    }

    public String getValidationMessageTextForCreds() {
        Message validationMessageForCreds = getValidationMessageForCreds();
        validationMessageForCreds.waitForMessageToBeAvailable();
        return validationMessageForCreds.getMessageText();
    }
}
