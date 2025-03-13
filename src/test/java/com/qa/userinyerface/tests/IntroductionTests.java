package com.qa.userinyerface.tests;

import com.qa.userinyerface.base.base.BaseTest;
import com.qa.userinyerface.framework.utils.modalhandler.ModalHandler;
import com.qa.userinyerface.userinyerfacePageObjects.GamePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntroductionTests extends BaseTest {
    @Test
    public void userFormNavigationSuccessful() throws InterruptedException {

        ModalHandler modalHandler = new ModalHandler(page);
        modalHandler.startWatching();


        boolean logoPresent =  homePage.isLogoVisible();
        Assertions.assertTrue(logoPresent);


        String introductionTextActuat = homePage.getIntroductionText();
        String introductionTextExpected = "Hi and welcome to User Inyerface, a challenging exploration of user " +
                "interactions and design patterns.";
        Assertions.assertEquals(introductionTextExpected.replaceAll("\\s+", " ").trim(),
                introductionTextActuat.replaceAll("\\s+", " ").trim());

        homePage.clickStartLink();
        GamePage gamePage = new GamePage(page);

        String pageIndicatorTextActual = gamePage.getPageIndicatorText();
        String pageIndicatorTextExpected = "1 / 4";
        Assertions.assertEquals(pageIndicatorTextExpected, pageIndicatorTextActual);

        gamePage.fillPasswordAndEmailFieldsWithValidRandomData(".com");
        gamePage.clickOnTermsAndConditionsCheckBox();
        gamePage.clickNextLink();

        String pageIndicatorTextActual2 = gamePage.getPageIndicatorText();
        String pageIndicatorTextExpected2 = "2 / 4";
        Assertions.assertEquals(pageIndicatorTextExpected2, pageIndicatorTextActual2);

        modalHandler.stopWatching();
    }
}
