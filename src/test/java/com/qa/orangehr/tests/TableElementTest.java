package com.qa.orangehr.tests;

import com.qa.orangehr.base.BaseTest;
import com.qa.orangehr.pages.AdminUserManagementPage;
import com.qa.orangehr.pages.DashboardPage;
import org.junit.jupiter.api.Test;


public class TableElementTest extends BaseTest {
    @Test
    public void correctValueOfTheCellIsDisplayed(){
        loginPage.fillUserNameField(userNameValid);
        loginPage.fillPasswordField(passwordValid);
        loginPage.clickSubmitButton();

        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.clickOptionInSearch("Admin");

        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(page);
        System.out.println(adminUserManagementPage.getColumnValues("Employee Name"));
        System.out.println(adminUserManagementPage.getCellValue("Employee Name", 2));
        }
    }
