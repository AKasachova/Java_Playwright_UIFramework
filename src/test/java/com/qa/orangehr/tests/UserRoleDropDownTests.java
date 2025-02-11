package com.qa.orangehr.tests;

import com.qa.orangehr.base.BaseTest;
import com.qa.orangehr.pages.AdminUserManagementPage;
import com.qa.orangehr.pages.DashboardPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class UserRoleDropDownTests extends BaseTest {
    @Test
    public void userDropDownOptionsAreDisplayedCorrectly(){
        loginPage.fillUserNameField(userNameValid);
        loginPage.fillPasswordField(passwordValid);
        loginPage.clickSubmitButton();

        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.clickOptionInSearch("Admin");

        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(page);
        adminUserManagementPage.expandUserRoleDropDown();
        int optionsCountActual = adminUserManagementPage.getAllUserDropDownOptions().size();
        int optionsCountExpected = 2;
        Assertions.assertEquals(optionsCountExpected, optionsCountActual);

        List<String> expectedOptionsText = Arrays.asList("Admin", "ESS");
        List<String> actualOptionsText = adminUserManagementPage.getUserRoleDropDownOptionsText();
        Assertions.assertEquals(expectedOptionsText, actualOptionsText);
    }

    @Test
    public void optionsInUserDropDownAreSetAndResetCorrectly() {
        loginPage.fillUserNameField(userNameValid);
        loginPage.fillPasswordField(passwordValid);
        loginPage.clickSubmitButton();

        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.clickOptionInSearch("Admin");

        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(page);
        adminUserManagementPage.expandUserRoleDropDown();
        adminUserManagementPage.chooseUserRoleDropDownOption("Admin");
        Assertions.assertEquals("Admin", adminUserManagementPage.getSetUserRoleDropDownOption());

        adminUserManagementPage.expandUserRoleDropDown();
        adminUserManagementPage.resetUserRoleDropDownOptions();
        Assertions.assertEquals("-- Select --", adminUserManagementPage.getSetUserRoleDropDownOption());
    }
}
