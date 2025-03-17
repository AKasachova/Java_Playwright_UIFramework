package com.qa.framework.forms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.framework.elements.Button;

public class ModalWindow {
    private Page page;
    private String modalWindowSelector;
    private Button acceptButton;

    public ModalWindow(Page page, String modalWindowSelector, Button acceptButton) {
        this.page = page;
        this.modalWindowSelector = modalWindowSelector;
        this.acceptButton = acceptButton;
    }

    public ModalWindow(Page page, String modalWindowSelector) {
        this.page = page;
        this.modalWindowSelector = modalWindowSelector;
    }

    //todo
/*    private Locator getModalWindow() {
        return page.locator(modalWindowSelector);
    }*/

    public void waitForModalWindowToBeAvailable() {
        page.waitForSelector(modalWindowSelector).isVisible();
    }

    private void clickAcceptButtonIfEnabled() {
        if (acceptButton.isButtonEnabled()) {
            acceptButton.click();
        }
    }

    public void acceptWhenEnabled() {
        clickAcceptButtonIfEnabled();
    }
    public boolean isModalWindowHidden(String hiddenStyleSelector, String modalWindowTitleSelector) {
        Locator element = page.locator(modalWindowTitleSelector);
        boolean isElementOutOfScreen = (boolean) element.evaluate("el =>" +
                " { const rect = el.getBoundingClientRect(); " +
                "return rect.top < 0 || rect.left < 0 || rect.bottom > window.innerHeight || rect.right > window.innerWidth; }");
        return page.locator(hiddenStyleSelector).count() > 0 && isElementOutOfScreen;
    }

    public void hideModalWindow(Button hideWindowButton, double delay) {
        hideWindowButton.click();
        page.waitForTimeout(delay);
    }

    public void scrollToTheBottomOfTheModalWindow() {
        //todo
    }
}
