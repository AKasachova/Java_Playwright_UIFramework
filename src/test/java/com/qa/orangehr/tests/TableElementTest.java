package com.qa.orangehr.tests;

import com.qa.orangehr.base.BaseTest;
import com.qa.orangehr.pages.AdminUserManagementPage;
import com.qa.orangehr.pages.DashboardPage;
import org.junit.jupiter.api.Test;


public class TableElementTest extends BaseTest {
    @Test
    public void correctValueOfTheCellIsDisplayed() throws InterruptedException {
        String userName = prop.getProperty("userName");
        String password = prop.getProperty("password");
        loginPage.fillUserNameField(userName);
        loginPage.fillPasswordField(password);
        loginPage.clickSubmitButton();

        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.clickAdminOptionInSearch();

        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(page);
        System.out.println(adminUserManagementPage.getRecordsFoundTableCellValue(2, 2));
        }
    }
