package com.qa.userinyerface.userinyerfacePageObjects;

import com.microsoft.playwright.Page;
import com.qa.userinyerface.framework.elements.*;
import com.qa.userinyerface.framework.pages.BasePage;
import com.qa.userinyerface.framework.utils.dataGenerator.RandomDataGenerator;

public class GamePage extends BasePage {

    private String pageIndicatorSelector = "//div[contains(@class,'login-form__section')]//div[@class = 'page-indicator']";
    private String passwordFieldSelector = "//input[@placeholder='Choose Password']";
    private String emailFieldSelector = "//input[@placeholder='Your email']";
    private String domainFieldSelector = "//input[@placeholder='Domain']";
    private String topLevelDomainSelector = "//div[contains(@class,'dropdown--gray')]";
    private String termsOfUseSelector = "//a[@class='login-form__terms-conditions']/span[@class='login-form__terms-conditions-underline']";
/*    private String termsOfUseModalWindowSelector = "//div[@class='modal']//div[@class='terms-and-conditions']";
    private String termsOfUseModalAcceptButtonSelector = "//button[contains(text(), 'Accept')]";*/
    //private String nextButtonSelector = "//a[contains(text(), 'Next')]";
    private String termsAndConditionsCheckBoxSelector = "//span[contains(@class, 'checkbox') and .//label[@for='accept-terms-conditions']]";
    private String nextLinkSelector = "//div[contains(@class,'button-container__secondary')]//a[@class='button--secondary']";
    private String interestsListCheckBoxiesSelector = "//div[@class='avatar-and-interests__interests-list']";

    public GamePage(Page page) {
        super(page);
    }

    private Element getPageIndicator() {
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

 /*   private Button getTermsOfUseModalAcceptButton() {
        return new Button(page, termsOfUseModalAcceptButtonSelector);
    }


    private ModalWindow getTermsOfUseModalWindow() {
        return new ModalWindow(page, termsOfUseModalWindowSelector, getTermsOfUseModalAcceptButton());
    }
*/
    private Link getNextLink() {
        return new Link(page, nextLinkSelector);
    }

    private CheckBox getTermsAndConditionsCheckBox() {
        return new CheckBox(page, termsAndConditionsCheckBoxSelector);
    }

    public String getPageIndicatorText() throws InterruptedException {
        getPageIndicator().isVisible();
        return getPageIndicator().getTextContent();
    }

    public void fillPasswordAndEmailFieldsWithValidRandomData(String option) {
        String randomEmail = RandomDataGenerator.generateRandomString(10);
        getEmailField().fillTextField(randomEmail);
        String randomPassword = RandomDataGenerator.generatePassword(randomEmail);
        getPasswordField().fillTextField(randomPassword);
        String randomDomain = RandomDataGenerator.generateRandomString(4);
        getDomainField().fillTextField(randomDomain);
        getTopLevelDomainDropDown().chooseDropDownOption(option);
    }


    public void clickTermsOfUseLink() {
        getTermsOfUseLink().click();
    }

/*
    public void waitForTermsOfUseModalToBeAvailable() {
        getTermsOfUseModalWindow().waitForModalWindowToBeAvailable();
    }

    public void acceptTermsOfUseModal() {
        getTermsOfUseModalWindow().scrollToTheBottomOfTheModalWindow();
        getTermsOfUseModalWindow().acceptWhenEnabled();
    }
*/
    public void clickOnTermsAndConditionsCheckBox() {
        getTermsAndConditionsCheckBox().clickOnCheckBox();
    }

    public void clickNextLink() {
        getNextLink().clickLink();
    }

    //todo
    //get all texts in list -> choose unchecked -> getelementIndex -> click on element
    //get list of all elements -> choose random -> parameter - how many to choose
}
