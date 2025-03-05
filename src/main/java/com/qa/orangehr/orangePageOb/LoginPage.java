package com.qa.orangehr.orangePageOb;

import com.microsoft.playwright.Page;
import com.qa.orangehr.framework.elements.Button;
import com.qa.orangehr.framework.elements.Element;
import com.qa.orangehr.framework.elements.Message;
import com.qa.orangehr.framework.elements.TextField;
import com.qa.orangehr.framework.pages.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(Page page){
        super(page);
    }

    //will not implement separate wrapper
    private Element getLogo(){
        return new Element(page, "//div[@class='orangehrm-login-branding']");
    }

    private TextField getUserNameField(){
        return new TextField(page, "//input[@name = 'username']");
    }

    private TextField getPasswordField(){
        return new TextField(page,"//input[@type = 'password']");
    }

    private Button getSubmitButton(){
        return new Button(page, "button[type = 'submit']",
                "Submit Login form button");
    }

    private Message getValidationMessageForCreds(){
        return new Message(page, "//div[@class='orangehrm-login-error']" +
                "//p[contains(@class,'oxd-alert-content-text')]");
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
