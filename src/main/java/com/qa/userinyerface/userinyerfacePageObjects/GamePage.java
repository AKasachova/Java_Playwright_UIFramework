package com.qa.userinyerface.userinyerfacePageObjects;

import com.microsoft.playwright.Page;
import com.qa.framework.elements.*;
import com.qa.framework.elements.Button;
import com.qa.framework.elements.TextField;
import com.qa.framework.modules.CheckBoxesPanel;
import com.qa.framework.modules.FileUploader;
import com.qa.framework.pages.BasePage;
import com.qa.framework.utils.dataGenerator.RandomDataGenerator;

import java.awt.*;

public class GamePage extends BasePage {

    private String pageIndicatorSelector = "//div[@class = 'page-indicator']";
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
    private String interestsListCheckBoxesSelector = "//div[@class='avatar-and-interests__interests-list__item']";
    private String  interestsListCheckBoxTextSelector = "//span[string-length(normalize-space(.)) > 0]";
    private String  interestsListCheckBoxIconSelector = "//span[@class = 'checkbox__box']";
    private String dropDownOptionsWithoutDefaultSelector = "//div[contains(@class, 'dropdown__list-item')]";
    private String uploadImgLinkSelector = "//a[@class='avatar-and-interests__upload-button']";
    private String nextButtonSelector = "//button[contains(text(), 'Next')]";

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

    private CheckBoxesPanel getInterestsListCheckBoxesPanel() {
        return new CheckBoxesPanel(page, interestsListCheckBoxesSelector);
    }

    private Link getUploadImgLink() {
        return new Link(page, uploadImgLinkSelector);
    }

    private FileUploader getFileUploader() {
        return new FileUploader(page, getUploadImgLink());
    }

    private Button getNextButton() {
        return new Button(page, nextButtonSelector);
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
        getTopLevelDomainDropDown().expandDropDown();
        getTopLevelDomainDropDown().chooseDropDownOption(option, dropDownOptionsWithoutDefaultSelector);
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

    public void clickRandomCheckBoxesInInterestsListCheckBoxesPanel(int count){
        getInterestsListCheckBoxesPanel().clickRandomCheckBoxes(count, "Unselect all", interestsListCheckBoxTextSelector, interestsListCheckBoxIconSelector);
    }

    public void uploadImg() throws AWTException {
        getFileUploader().uploadFile();
    }

    public void clickNextButton() {
        getNextButton().clickButton();
    }

}