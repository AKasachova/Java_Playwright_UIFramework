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
    public void userWasLoggedInSuccessfully() {
        String userName = prop.getProperty("userName");
        String password = prop.getProperty("password");
        loginPage.fillUserNameField(userName);
        loginPage.fillPasswordField(password);
        loginPage.clickSubmitButton();

        DashboardPage dashboardPage = new DashboardPage(page);
        Assertions.assertNotNull(dashboardPage.getUserDropDown());
    }

    @Test
    @Order(3)
    public void  userWasNotLoggedInWithInvalidCreds(){
        loginPage.fillUserNameField("userName");
        loginPage.fillPasswordField("password");
        loginPage.clickSubmitButton();
        String validationMessageTextForCreds = loginPage.getValidationMessageTextForCreds();

        Assertions.assertEquals("Invalid credentials", validationMessageTextForCreds);
    }

    @Test
    @Order(4)
    public void userLoggedOutSuccessfully() {
        String userName = prop.getProperty("userName");
        String password = prop.getProperty("password");
        loginPage.fillUserNameField(userName);
        loginPage.fillPasswordField(password);
        loginPage.clickSubmitButton();

        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.expandUserDropDown();
        dashboardPage.clickLinkToLogout();

        Assertions.assertNotNull(loginPage.getLogo());
    }
}
