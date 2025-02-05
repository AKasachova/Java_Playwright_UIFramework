package com.qa.orangehr.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPage {
    private Page page;
    private Locator adminOptionInSearch;
    private Locator myInfoLink;
    private Locator userDropDown;
    private Locator logOutLink;

    public DashboardPage(Page page) {
        this.page = page;

        //this.adminOptionInSearch = page.locator("text = Admin").nth(0);
        this.adminOptionInSearch = page.locator("//a//*[text()='Admin']");

        //this.myInfoLink = page.locator("a[href=\"/web/index.php/pim/viewMyDetails\"]");
        this.myInfoLink = page.locator("//a//span[text()='My Info']");

        //this.userDropDown = page.locator("span.oxd-userdropdown-tab");
        this.userDropDown = page.locator("//span[@class = 'oxd-userdropdown-tab']");

        this.logOutLink = page.locator("//ul[.//a[contains(text(),'Logout')]]");
    }

    public AdminUserManagementPage navigateToAdminPage() {
        adminOptionInSearch.click();
        return new AdminUserManagementPage(page);
    }

    public MyInfoPage navigateToMyInfoPage() {
        myInfoLink.click();
        return new MyInfoPage(page);
    }

    public LoginPage logout(){
        userDropDown.click();
        logOutLink.click();
        return new LoginPage(page);
    }
}
