package com.qa.orangehr.tests;

import com.qa.orangehr.base.BaseTest;
import com.qa.orangehr.elements.Element;
import com.qa.orangehr.pages.DashboardPage;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests extends BaseTest {
    @Test
    @Order(1)
    public void loginPageContainsLogo(){
        Element logo = loginPage.getLogo();

        Assertions.assertNotNull(logo);
    }

    @Test
    @Order(2)
    public void userWasLoggedInSucсessfully() {
        new DashboardPage(page);
        DashboardPage dashboardPage = loginPage.getDashboardPage(prop.getProperty("userName"), prop.getProperty("password"));

        Assertions.assertNotNull(dashboardPage.getUserDropDown());
    }

    @Test
    @Order(3)
    public void  userWasNotLoggedInWithInvalidCreds(){
        String validationMessageForCreds = loginPage.getValidationMessageForCreds("1", "1");

        Assertions.assertEquals("Invalid credentials", validationMessageForCreds);
    }

    @Test
    @Order(4)
    public void userLoggedOutSucсessfully() {
        new DashboardPage(page);
        DashboardPage dashboardPage = loginPage.getDashboardPage(prop.getProperty("userName"), prop.getProperty("password"));
        dashboardPage.getLoginPageAfterlogout();

        Assertions.assertNotNull(loginPage.getLogo());
    }
}
