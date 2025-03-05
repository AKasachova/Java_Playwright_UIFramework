package com.qa.orangehr.tests;

import com.qa.orangehr.base.BaseTest;
import com.qa.orangehr.orangePageObjects.AdminUserManagementPage;
import com.qa.orangehr.orangePageObjects.DashboardPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class TableElementTest extends BaseTest {
    @Test
    public void correctValueOfTheCellIsDisplayed(){
        logInAsAdmin();

        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.clickOptionInSearch("Admin");

        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(page);

        List<String> expectedEmployeeNames = Arrays.asList("Achu MMS", "Achu MMS", "FirstNameTest LastNameTest", "A8DCo 010Z"," Edwin Antony", "Qwerty LName", "FName LName", "Jobin Sam", "Jason Phenduka", "Assaf B", "Thomas Benny");
        List<String> actualEmployeeNames = adminUserManagementPage.getColumnValuesForRecordsFoundTable("Employee Name");
        Assertions.assertEquals(expectedEmployeeNames, actualEmployeeNames);

        String expectedEmployeeName = "Achu MMS";
        String actualEmployeeName = adminUserManagementPage.getCellValueForRecordsFoundTable("Employee Name", 2);
        Assertions.assertEquals(expectedEmployeeName, actualEmployeeName);
        }
    }
