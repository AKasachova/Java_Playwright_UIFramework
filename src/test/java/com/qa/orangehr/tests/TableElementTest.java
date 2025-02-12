package com.qa.orangehr.tests;

import com.qa.orangehr.base.BaseTest;
import com.qa.orangehr.modules.Table;
import com.qa.orangehr.pages.AdminUserManagementPage;
import com.qa.orangehr.pages.DashboardPage;
import org.junit.jupiter.api.Test;


public class TableElementTest extends BaseTest {
    @Test
    public void correctValueOfTheCellIsDisplayed(){
        logInAsAdmin();

        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.clickOptionInSearch("Admin");

        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(page);
        Table recordsFoundTable = adminUserManagementPage.getRecordsFoundTable();
        System.out.println(recordsFoundTable.getColumnValues("Employee Name"));
        System.out.println(recordsFoundTable.getCellValue("Employee Name", 2));
        }
    }
