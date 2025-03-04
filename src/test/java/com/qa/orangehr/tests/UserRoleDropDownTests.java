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
        logInAsAdmin();

        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.clickOptionInSearch("Admin");

        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(page);
        List<String> expectedOptionsText = Arrays.asList("Admin", "ESS");
        List<String> actualOptionsText = adminUserManagementPage.getAllUserRoleDropDownOptions();
        Assertions.assertEquals(expectedOptionsText, actualOptionsText);

        int optionsCountActual = actualOptionsText.size();
        int optionsCountExpected = 2;
        Assertions.assertEquals(optionsCountExpected, optionsCountActual);
    }

    @Test
    public void optionsInUserDropDownAreSetAndResetCorrectly() {
        logInAsAdmin();

        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.clickOptionInSearch("Admin");

        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(page);
        adminUserManagementPage.chooseUserRoleDropDownOption("Admin");
        Assertions.assertEquals("Admin", adminUserManagementPage.getSetUserRoleDropDownOption());

        adminUserManagementPage.resetUserRoleDropDownOption();
        Assertions.assertEquals("-- Select --",adminUserManagementPage.getSetUserRoleDropDownOption());
    }
}
