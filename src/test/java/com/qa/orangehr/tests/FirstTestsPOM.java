package com.qa.orangehr.tests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.qa.orangehr.base.BaseTest;
import com.qa.orangehr.constants.AppConstants;
import com.qa.orangehr.pages.*;
import org.junit.jupiter.api.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FirstTestsPOM extends BaseTest {
    //todo
    @Test
    @Order(1)
    public void newUserWasAdded() {
        new AdminUserManagementPage(page);
        new AddUserPage(page);
        AdminUserManagementPage adminUserManagementPage = homePage.navigateToAdminPage();
        AddUserPage addUserPage = adminUserManagementPage.navigateToAddUserPage();
        addUserPage.submitAdddUserForm2("Admin", "Enabled", "Test456", "Test123456");
        adminUserManagementPage.filterUsers("Test456", "Admin");

        List<Locator> filteredUserNames = adminUserManagementPage.getUserNameFromGridAfterFiltering("Test456");
        int filteredUserNamesCount = filteredUserNames.size();

        Assertions.assertEquals(1, filteredUserNamesCount);
    }

    @Test
    void invalidUserNameVerification() {
        new AdminUserManagementPage(page);
        new AddUserPage(page);
        AdminUserManagementPage adminUserManagementPage = homePage.navigateToAdminPage();
        assertThat(adminUserManagementPage.getPageTitle()).isVisible();

        AddUserPage addUserPage = adminUserManagementPage.navigateToAddUserPage();
        assertThat(addUserPage.getPageTitle()).hasText("Add User");

        addUserPage.submitAdddUserForm("Timothy Lewis Amiano", "TestName2", "Password12345");
        assertThat(page.locator("span.oxd-input-field-error-message")).hasText(AppConstants.INVALID_MESSAGE);
    }

    @Test
    //UI was changed  - needs to refactor the test
    void  myInfoPersonalDetailsWereSaved(){
        new MyInfoPage(page);
        MyInfoPage myInfoPage = homePage.navigateToMyInfoPage();
       myInfoPage.fillMyInfoData("firstName", "middleName", "lastName");

       assertThat(myInfoPage.savePersonalDetails()).containsText("Successfully");
       assertThat(myInfoPage.saveCustomFields()).containsText("Successfully");

        myInfoPage.saveAttachments();
        //save3->popup mess(question)
        //Locator text = myInfoPage.getFileNameFromGrid(); - why it is not visible
        //assertThat(text).containsText("example.png");
        myInfoPage.deleteFileFromUploads();
        //assertThat(myInfoPage.getFileNameFromGrid()).isHidden();
        //delete -> popup message -> click no
        //go to any tab -> return -> verify in every section presented data -> to check each drop down for spec option
    }

    @Test
    public void resetPassLinkSent(){
        new ResetPassPage(page);
        new SendPasswordReset(page);
        loginPage = homePage.logout();
        assertThat(loginPage.getPageLogoImg()).isVisible();

        ResetPassPage resetPassPage = loginPage.navigateToResetPass();
        SendPasswordReset sendPasswordReset = resetPassPage.sendPasswordReset("Test");
        assertThat(sendPasswordReset.getResetMessageTitle()).hasText("Reset Password link sent successfully");
    }
}
