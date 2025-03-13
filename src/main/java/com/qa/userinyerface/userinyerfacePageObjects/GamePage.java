package com.qa.userinyerface.userinyerfacePageObjects;

import com.microsoft.playwright.Page;
import com.qa.framework.elements.*;
import com.qa.framework.forms.ModalWindow;
import com.qa.framework.pages.BasePage;
import com.qa.framework.utils.dataGenerator.RandomDataGenerator;

public class GamePage extends BasePage {

    private String pageIndicatorSelector = "//div[contains(@class,'login-form__section')]//div[@class = 'page-indicator']";
    private String passwordFieldSelector = "//input[@placeholder='Choose Password']";
    private String emailFieldSelector = "//input[@placeholder='Your email']";
    private String domainFieldSelector = "//input[@placeholder='Domain']";
    private String topLevelDomainSelector = "//input[@placeholder='Domain']";
    private String termsOfUseSelector = "//a[@class='login-form__terms-conditions']/span[@class='login-form__terms-conditions-underline']";
    private String termsOfUseModalWindowSelector = "//div[@class='modal']//div[@class='terms-and-conditions']";
    private String termsOfUseModalAcceptButtonSelector = "//button[contains(text(), 'Accept')]";
    private String nextButtonSelector = "//a[contains(text(), 'Next')]";

    public GamePage(Page page) {
        super(page);
    }

    private Element getPageIndicatorSelector() {
        return new Element(page, pageIndicatorSelector);
    }

    private TextField getPasswordField() {
        return new TextField(page, passwordFieldSelector);
    }

    private TextField getEmailField() {
        return new TextField(page, emailFieldSelector);
    }

    private TextField getDomainField() {
        return new TextField(page, domainFieldSelector);
    }

    private DropDown getTopLevelDomainDropDown() {
        return new DropDown(page, topLevelDomainSelector);
    }

    private Link getTermsOfUseLink() {
        return new Link(page, termsOfUseSelector);
    }

    private Button getTermsOfUseModalAcceptButton() {
        return new Button(page, termsOfUseModalAcceptButtonSelector);
    }

    private ModalWindow getTermsOfUseModalWindow() {
        return new ModalWindow(page, termsOfUseModalWindowSelector, getTermsOfUseModalAcceptButton());
    }

    private Button getNextButton() {
        return new Button(page, nextButtonSelector);
    }

    public String getPageIndicatorText() {
        return getPageIndicatorSelector().getTextContent();
    }

    //todo
    public void fillPasswordFieldWithValidRandomPassword() {
        String randomPassword = RandomDataGenerator.generateRandomString(8);
        getPasswordField().fillTextField(randomPassword);
    }
//todo
    public void fillEmailFieldWithValidRandomEmail() {
        String randomEmail = RandomDataGenerator.generateRandomString(10);
        getEmailField().fillTextField(randomEmail);
    }
    //todo
    public void fillDomainFieldWithValidRandomEmail() {
        String randomDomain = RandomDataGenerator.generateRandomString(4);
        getDomainField().fillTextField(randomDomain);
    }

    public void chooseTopLevelDomainDropDownOption(String option) {
        getTopLevelDomainDropDown().chooseDropDownOption(option);
    }

    public void clickTermsOfUseLink() {
        getTermsOfUseLink().click();
    }

    public void waitForTermsOfUseModalToBeAvailable() {
        getTermsOfUseModalWindow().waitForModalWindowToBeAvailable();
    }

    public void acceptTermsOfUseModal() {
        getTermsOfUseModalWindow().scrollToTheBottomOfTheModalWindow();
        getTermsOfUseModalWindow().acceptWhenEnabled();
    }

    public void clickNextButton() {
        getNextButton().clickButton();
    }
}
