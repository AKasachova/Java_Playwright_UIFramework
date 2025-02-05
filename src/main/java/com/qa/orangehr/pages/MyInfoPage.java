package com.qa.orangehr.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.nio.file.Paths;


public class MyInfoPage {
    private Page page;
    private Locator employeeFirstNameField;
    private Locator employeeMiddleNameField;
    private Locator employeeLastNameField;
    private Locator employeeIDField;
    private Locator otherIDField;
    private Locator driversLicenseNumber;
    private Locator licenseExpiryDate;
    private Locator dateOfBirthField;
    private Locator genderField;
    private Locator nationalityDropDown;
    private Locator nationalityDropDownOption;
    private Locator marialStatusDropDown;
    private Locator marialStatusDropDownOption;
    private Locator bloodTypeDropDown;
    private Locator bloodTypeDropDownOption;
    private String addButton = "text=Add";
    private Locator browseButton;
    private Locator uploadField;
    private Locator savePersonalDetailsButton;
    private Locator successToastMessageText;
    private Locator saveCustomFieldsButton;
    private Locator saveAttachmentsButton;
    private Locator fileNameInGrid;
    private Locator deleteFileButton;
    private Locator deletionConfirmationPopup;
    private Locator confirmDeletionButton;


    public MyInfoPage(Page page) {
        this.page = page;

        //this.employeeFirstNameField = page.locator("input[placeholder = 'First Name']");
        this.employeeFirstNameField = page.locator("//input[@name ='firstName']");

        //this.employeeMiddleNameField = page.getByPlaceholder("Middle Name");
        this.employeeMiddleNameField = page.locator("//input[@name ='middleName']");

        //this.employeeLastNameField = page.getByPlaceholder("Last Name");
        this.employeeLastNameField = page.locator("//input[@name ='lastName']");

        //this.employeeIDField = page.locator("input.oxd-input.oxd-input--active").nth(4);
        this.employeeIDField = page.locator("//div[contains(@class, 'oxd-input-group') and .//label[text()='Employee Id']]//input");

        //this.otherIDField = page.locator("input.oxd-input.oxd-input--active").nth(5);
        this.otherIDField = page.locator("//div[contains(@class, 'oxd-input-group') and .//label[text()='Other Id']]//input");

        //this.driversLicenseNumber = page.locator("input.oxd-input.oxd-input--active").nth(6);
        this.driversLicenseNumber = page.locator("//div[contains(@class, 'oxd-input-group') and .//label[text()=\"Driver's License Number\"]]//input");

        //this.licenseExpiryDate = page.locator("input[placeholder = 'yyyy-dd-mm']").nth(1);
        this.licenseExpiryDate = page.locator("//div[contains(@class, 'oxd-input-group') and .//label[text()=\"License Expiry Date\"]]//input");

        //this.nationalityDropDown = page.locator("div.oxd-select-wrapper").nth(0);
        this.nationalityDropDown = page.locator("//div[contains(@class, 'oxd-input-group') and .//label[text()='Nationality']]//div[@class='oxd-select-wrapper']");

        //this.nationalityDropDownOption = page.locator("div.oxd-select-wrapper div[role='option']").nth(2);
        this.nationalityDropDownOption = page.locator("(//div[contains(@class, 'oxd-input-group') and .//label[text()='Nationality']]//div[@role='option'])[3]");

        //this.marialStatusDropDown = page.locator("div.oxd-select-wrapper").nth(1);
        this.marialStatusDropDown = page.locator("//div[contains(@class, 'oxd-input-group') and .//label[text()='Marital Status']]//div[@class='oxd-select-wrapper']");

        //this.marialStatusDropDownOption = page.locator("div.oxd-select-wrapper div[role='option']").nth(2);
        this.marialStatusDropDownOption = page.locator("(//div[contains(@class, 'oxd-input-group') and .//label[text()='Marital Status']]//div[@role='option'])[2]");

        //this.dateOfBirthField = page.locator("input.oxd-input.oxd-input--active").nth(8);
        this.dateOfBirthField = page.locator("//div[contains(@class, 'oxd-input-group') and .//label[text()='Date of Birth']]//input");

        //this.genderField = page.locator("text=Female");
        this.genderField = page.locator("//div[@class ='oxd-radio-wrapper' and  .//label[text()='Female']]");

        //this.bloodTypeDropDown = page.locator("div.oxd-select-wrapper").nth(2);
        this.bloodTypeDropDown = page.locator("//div[contains(@class, 'oxd-input-group') and .//label[text()='Blood Type']]//div[@class='oxd-select-wrapper']");

        //this.bloodTypeDropDownOption = page.locator("div.oxd-select-wrapper div[role='option']").nth(2);
        this.bloodTypeDropDownOption = page.locator("(//div[contains(@class, 'oxd-input-group') and .//label[text()='Blood Type']]//div[@role='option'])[3]");

        //this.browseButton = page.locator("div.oxd-file-button:text('Browse')");
        this.browseButton = page.locator("//div[@class='oxd-file-button'and text()='Browse']");

        //this.uploadField = page.locator("input.oxd-file-input");
        this.uploadField = page.locator("//input[@class='oxd-file-input']");

        //this.savePersonalDetailsButton = page.locator("button[type='submit']").nth(0);
        this.savePersonalDetailsButton = page.locator("(//button[@type='submit'])[1]");

        //this.saveCustomFieldsButton = page.locator("button[type='submit']").nth(1);
        this.saveCustomFieldsButton = page.locator("(//button[@type='submit'])[2]");

        this.saveAttachmentsButton = page.locator("button[type='submit']").nth(2);
        //this.saveAttachmentsButton = page.locator("(//button[type='submit'])[3]"); --why is not working

        this.successToastMessageText = page.locator("div.oxd-toast-content p").nth(1);
        //this.successToastMessageText = page.locator("(//div[@class='oxd-toast-content']//p)[2]");

        //this.fileNameInGrid = page.locator("div.header + div.data").nth(0);
        this.fileNameInGrid = page.locator("(//div[@class='header']/following-sibling::div[@class='data'][1])[1]");

        //to implement deletion method
        //this.deleteFileButton = page.locator("div.oxd-table-cell-actions button").nth(1);
        this.deleteFileButton = page.locator("(//div[@class='oxd-table-cell-actions']//button)[1]");

        //this.deletionConfirmationPopup = page.locator("div.orangehrm-dialog-popup");
        this.deletionConfirmationPopup = page.locator("//div[@class='orangehrm-dialog-popup']");

        //this.confirmDeletionButton = page.locator("text= Yes, Delete ");
        this.confirmDeletionButton = page.locator("//*[text()=' Yes, Delete ']");
    }

    public void fillMyInfoData(String firstName, String middleName, String lastName) {
        employeeFirstNameField.clear();
        employeeFirstNameField.fill(firstName);
        employeeMiddleNameField.clear();
        employeeMiddleNameField.fill(middleName);
        employeeLastNameField.clear();
        employeeLastNameField.fill(lastName);
        employeeIDField.clear();
        employeeIDField.fill("Lead");
        otherIDField.clear();
        otherIDField.fill("815-91-5305");
        driversLicenseNumber.clear();
        driversLicenseNumber.fill("300-30-6675");
        licenseExpiryDate.fill("2023-19-10");
        dateOfBirthField.fill("2023-21-10");
        nationalityDropDown.click();
        nationalityDropDownOption.click();
        marialStatusDropDown.click();
        marialStatusDropDownOption.click();
        genderField.click();
        bloodTypeDropDown.click();
        bloodTypeDropDownOption.click();

        page.click(addButton);
        uploadField.setInputFiles(Paths.get("example.png"));
    }

    public Locator savePersonalDetails() {
        savePersonalDetailsButton.click();
        successToastMessageText.waitFor();
        return successToastMessageText;
    }

    public Locator saveCustomFields() {
        saveCustomFieldsButton.click();
        successToastMessageText.waitFor();
        return successToastMessageText;
    }

    public void saveAttachments() {
        page.evaluate("window.scrollTo(0, document.body.scrollHeight)");
        saveAttachmentsButton.click();
    }

    public Locator getFileNameFromGrid() {
        page.evaluate("window.scrollTo(0, document.body.scrollHeight)");
        fileNameInGrid.waitFor();
        return fileNameInGrid;
    }

    public void deleteFileFromUploads(){
        deleteFileButton.click();
    }

    public void confirmFileDeletion(){
        deletionConfirmationPopup.waitFor();
        confirmDeletionButton.click();
    }
}
