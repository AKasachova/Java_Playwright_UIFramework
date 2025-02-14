package com.qa.orangehr.tests;

import com.qa.orangehr.base.BaseTest;
import com.qa.orangehr.pageObjects.elements.DropDownElement;
import com.qa.orangehr.pageObjects.pages.AdminUserManagementPage;
import com.qa.orangehr.pageObjects.pages.DashboardPage;
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
        DropDownElement userRoleDropDown = adminUserManagementPage.getUserRoleDropDown();
        List<String> expectedOptionsText = Arrays.asList("Admin", "ESS");
        userRoleDropDown.expandDropDown();
        List<String> actualOptionsText = userRoleDropDown.getDropDownOptionsText();
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
        DropDownElement userRoleDropDown = adminUserManagementPage.getUserRoleDropDown();
        userRoleDropDown.chooseDropDownOption("Admin");
        Assertions.assertEquals("Admin", userRoleDropDown.getSetDropDownOption());

        userRoleDropDown.expandDropDown();
        userRoleDropDown.resetDropDownOptions();
        Assertions.assertEquals("-- Select --", userRoleDropDown.getSetDropDownOption());
    }
}
