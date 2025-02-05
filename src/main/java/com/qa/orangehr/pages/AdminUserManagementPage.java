package com.qa.orangehr.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.orangehr.elements.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminUserManagementPage extends BasePage {
    private Locator pageTitle;
//    private Locator addButton;
    private Locator userNameField;
    private Locator userRoleDropDown;
    private Locator dropDownOptions;
    private Locator searchButton;
    private List<Locator> filteredUserName;

    private Element addButton = new Element(page, "");

    public AdminUserManagementPage(Page page) {
        super(page);
        //this.pageTitle = page.locator("h6").and(page.getByText("User Management"));
        this.pageTitle = page.locator("//h6[text()='User Management']");

        //this.addButton = page.getByText("Add");
        //this.addButton = page.locator("//button[text()=' Add ']");
        this.addButton = page.locator("//*[text()=' Add ']");

        //this.userRoleDropDown = page.locator("//div[@class='oxd-select-wrapper']").first();
        this.userRoleDropDown = page.locator("//div[contains(@class, 'oxd-grid-item') and .//label[text()='User Role']]//div[@class='oxd-select-wrapper']");

        //this.dropDownOptions = page.locator("div.oxd-select-option");
        this.dropDownOptions = page.locator("//div[@class = 'oxd-select-option']");

        this.searchButton = page.locator("//button[@type = 'submit']");

        //this.filteredUserName = page.locator("//div[@class='oxd-table-cell oxd-padding-cell']/div").all();

        this.filteredUserName = page.locator("//div[contains(@class,'oxd-table-cell')]/div[text()]").all();

        //this.userNameField = page.locator("//input[@class = 'oxd-input oxd-input--active']").nth(1);
        this.userNameField = page.locator("//div[contains(@class , 'oxd-input-group') and  .//label[text()='Username']]//input");
    }

    public Locator getPageTitle() {
        this.pageTitle.waitFor();
        return this.pageTitle;
    }

    public AddUserPage navigateToAddUserPage() {
        addButton.click();
        return new AddUserPage(page);
    }

    public void filterUsers(String userName, String userRole) {
        userNameField.fill(userName);
        userRoleDropDown.click();
        chooseDropDownOption(userRole, dropDownOptions);
        searchButton.click();
    }

    public List<Locator> getUserNameFromGridAfterFiltering(String userName) {
        List<Locator> filteredUsersList = new ArrayList<>();
        page.evaluate("window.scrollTo(0, document.body.scrollHeight)");
        page.waitForTimeout(2000);
        for (int i = 0; i < filteredUserName.size(); i++) {
            System.out.println(filteredUserName.get(i).textContent());
            if (filteredUserName.get(i).textContent().equals(userName)) {
                filteredUsersList.add(filteredUserName.get(i));
            }
        }
        /*List<Locator> filteredUsersList = filteredUserName.stream()
                .filter(locator -> locator.textContent().equals(userName))
                .collect(Collectors.toList());*/
        return filteredUsersList;
    }

    //To implement
    public void deleteFilteredUser() {

    }
}
