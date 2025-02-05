package com.qa.orangehr.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AddUserPage extends BasePage {
    private Locator pageTitle;
    private Locator userRoleDropDown;
    private Locator adminOption;
    private Locator statusDropDown;
    private Locator enabledOption;
    private Locator employeeNameField;
    private Locator userNameField;
    private Locator employeeNameFieldOption;
    private Locator passwordField;
    private Locator confirmPasswordField;
    private Locator submitButton;
    private Locator dropDownOptions;

    public AddUserPage(Page page) {
        super(page);
        this.pageTitle = page.getByText("Add").and(page.locator("h6"));
        // //h6[contains(@class, 'orangehrm-main-title') and text()='Add User']

        this.userRoleDropDown = page.locator("//div[@class='oxd-select-wrapper']").first();
        // //div[contains(@class, 'oxd-input-group') and  .//label[text()="User Role"]]//div[contains(@class,'oxd-select-wrapper')]

        //this.adminOption = page.locator("div.oxd-select-option").nth(1);
        this.adminOption = page.locator("(//div[@class = 'oxd-select-option'])[2]");

        // //(div[@class, 'oxd-select-option'])[1]
       // this.statusDropDown = page.locator("div.oxd-select-wrapper").nth(1);
        this.statusDropDown = page.locator("(//div[@class = 'oxd-select-wrapper'])[2]");

        //this.enabledOption = page.locator("div.oxd-select-option").nth(1);
        this.enabledOption = page.locator("(//div[@class='oxd-select-option'])[2]");

        //this.dropDownOptions = page.locator("div.oxd-select-option");
        this.dropDownOptions = page.locator("//div[@class = 'oxd-select-option']");

        //this.employeeNameField = page.getByPlaceholder("Type for hints...");
        this.employeeNameField = page.locator("//input[normalize-space(@placeholder) = 'Type for hints...']");

        this.employeeNameFieldOption = page.locator("//div[@role='listbox']/div").nth(2);

        //this.userNameField = page.locator("div > input.oxd-input.oxd-input--active").nth(1);
        this.userNameField = page.locator("//div[ contains(@class, 'oxd-input-group') and .//label[text()='Username']]//input");

        //this.passwordField = page.locator("input[type = 'password']").nth(0);
        this.passwordField = page.locator("//div[contains(@class, 'oxd-input-group') and .//label[text()='Password']]//input");

        //this.confirmPasswordField = page.locator("input[type = 'password']").nth(1);
        this.confirmPasswordField = page.locator("//div[contains(@class, 'oxd-input-group') and .//label[text()='Confirm Password']]//input");

        //this.submitButton = page.locator("button[type = 'submit']");
        this.submitButton = page.locator("//button[@type = 'submit']");
    }

    public Locator getPageTitle() {
        pageTitle.waitFor();
        return pageTitle;
    }

    private Locator getUserRoleDropDown()
    {
        return getLocator("//div[@class='oxd-select-wrapper']");
    }

    public void submitAdddUserForm(String employeeName, String userName, String password) {
        userRoleDropDown.click();
        adminOption.click();
        userRoleDropDown.click();
        statusDropDown.click();
        enabledOption.click();
        employeeNameField.fill(employeeName);
        userNameField.fill(userName);
        passwordField.fill(password);
        confirmPasswordField.fill(password);
        submitButton.click();
    }

    public void submitAdddUserForm2(String userRole, String status, String userName, String password) {
        userRoleDropDown.click();
        chooseDropDownOption(userRole, dropDownOptions);
        statusDropDown.click();
        chooseDropDownOption(status, dropDownOptions);
        employeeNameField.fill("a");
        employeeNameFieldOption.click();
        userNameField.fill(userName);
        passwordField.fill(password);
        confirmPasswordField.fill(password);
        submitButton.click();
    }
}
