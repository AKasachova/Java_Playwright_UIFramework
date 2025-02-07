package com.qa.orangehr.tests;

import com.qa.orangehr.base.BaseTest;
import com.qa.orangehr.elements.DropDownElement;
import com.qa.orangehr.pages.AdminUserManagementPage;
import com.qa.orangehr.pages.DashboardPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class UserRoleDropDownTests extends BaseTest {
    @Test
    public void userDropDownOptionsAreDisplayedCorrectly(){
        String userName = prop.getProperty("userName");
        String password = prop.getProperty("password");
        loginPage.fillUserNameField(userName);
        loginPage.fillPasswordField(password);
        loginPage.clickSubmitButton();

        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.clickAdminOptionInSearch();

        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(page);
        DropDownElement userRoleDropDown = adminUserManagementPage.getUserRoleDropDown();
        boolean userRoleDropDownOptionsCountVerification = userRoleDropDown.checkDropDownOptionsCount(3) ;
        Assertions.assertTrue(userRoleDropDownOptionsCountVerification);

        //Missing drop-down option: --Select--
        List<String> expectedOptionsText = Arrays.asList("--Select--", "Admin", "ESS");
        boolean userRoleDropDownOptionsTextVerification = userRoleDropDown.checkDropDownOptionsText(expectedOptionsText) ;
        Assertions.assertTrue(userRoleDropDownOptionsTextVerification);
    }

    @Test
    public void optionsInUserDropDownAreSetAndResetCorrectly() {
        String userName = prop.getProperty("userName");
        String password = prop.getProperty("password");
        loginPage.fillUserNameField(userName);
        loginPage.fillPasswordField(password);
        loginPage.clickSubmitButton();

        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.clickAdminOptionInSearch();

        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(page);
        DropDownElement userRoleDropDown = adminUserManagementPage.getUserRoleDropDown();
        userRoleDropDown.chooseDropDownOption("Admin");
        Assertions.assertEquals("Admin", userRoleDropDown.getSetDropDownOption());

        userRoleDropDown.resetDropDownOptions();
        Assertions.assertEquals("-- Select --", userRoleDropDown.getSetDropDownOption());
    }
}
