package com.qa.orangehr.tests;

import com.qa.orangehr.base.BaseTest;
import com.qa.orangehr.pageObjects.pages.DashboardPage;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests extends BaseTest {
    @Test
    @Order(1)
    public void loginPageContainsLogo(){
        boolean logoPresent = loginPage.isLogoVisible();
        Assertions.assertTrue(logoPresent);
    }

    @Test
    @Order(2)
    public void userWasLoggedInSuccessfully() {
        logInAsAdmin();

        DashboardPage dashboardPage = new DashboardPage(page);
        Assertions.assertTrue(dashboardPage.isUserMenuVisible());
    }

    @Test
    @Order(3)
    public void  userWasNotLoggedInWithInvalidCreds(){
        loginPage.fillUserNameField(userNameInvalid);
        loginPage.fillPasswordField(passwordInvalid);
        loginPage.clickSubmitButton();

        String validationMessageTextForCredsActual = loginPage.getValidationMessageTextForCreds();
        String validationMessageTextForCredsExpected = "Invalid credentials";
        Assertions.assertEquals(validationMessageTextForCredsExpected, validationMessageTextForCredsActual);
    }

    @Test
    @Order(4)
    public void userLoggedOutSuccessfully() {
        logInAsAdmin();

        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.logOutFromTheApp();
        Assertions.assertTrue(loginPage.isLogoVisible());
    }
}
