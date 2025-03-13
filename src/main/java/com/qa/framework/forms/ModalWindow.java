package com.qa.framework.forms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.framework.elements.Button;

public class ModalWindow {
    private Page page;
    private String modalWindowSelector;
    private String comment;
    private Button acceptButton;

    public ModalWindow(Page page, String modalWindowSelector, Button acceptButton) {
        this.page = page;
        this.modalWindowSelector = modalWindowSelector;
        this.acceptButton = acceptButton;
    }

    public ModalWindow(Page page, String modalWindowSelector, Button acceptButton, String comment) {
        this.page = page;
        this.modalWindowSelector = modalWindowSelector;
        this.comment = comment;
    }

    private Locator getModalWindow() {
        return page.locator(modalWindowSelector);
    }

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

    public void scrollToTheBottomOfTheModalWindow() {
        //todo
        //page.evaluate("document.querySelector('.terms-and-conditions__content').scrollTop = document.querySelector('.terms-and-conditions__content').scrollHeight;");
        //page.evaluate("document.querySelector('.terms-and-conditions__content').scrollBy(0, 300)");
/*        page.locator(".terms-and-conditions__text-content").hover();
        page.mouse().wheel(0, 2300);*/
        //page.evaluate("document.querySelector('.terms-and-conditions__text-content').scrollBy(0, 2300);");
        //page.evaluate("document.querySelector('.terms-and-conditions__text-content :last-child').scrollIntoView();");
        //page.evaluate("document.querySelector('.terms-and-conditions__text-content').scrollBy(0, document.querySelector('.terms-and-conditions__text-content').scrollHeight);");
/*        page.evaluate("""
    let container = page.locator('.terms-and-conditions__text-content');
    container.scrollBy(0, container.scrollHeight - container.scrollTop);
""");*/
        //page.evaluate("document.querySelector('.terms-and-conditions__text-content').scrollTop = document.querySelector('.terms-and-conditions__text-content').scrollHeight;");
/*        page.locator(".terms-and-conditions__text-scrollbar").hover();
        page.mouse().wheel(0, 2300);*/
        //page.evaluate("document.querySelector('.modal .terms-and-conditions__text').scrollTop = document.querySelector('.modal .terms-and-conditions__text').scrollHeight;");

/*            // Получаем локатор модального окна и контейнера для прокрутки
            Locator modalContent = page.locator(".modal .terms-and-conditions__text");

            // Скроллим вниз, прокручивая на всю высоту содержимого
            modalContent.evaluate("el => el.scrollTop = el.scrollHeight");*/
/*        page.evaluate("""
        let container = document.querySelector('.modal .terms-and-conditions__text');
        container.scrollBy(0, 300);  // Прокручиваем на 300px
    """);*/
        //page.locator(".modal .terms-and-conditions__text").evaluate("e => e.scrollTop += 100");
        //page.locator(".modal .terms-and-conditions__text").evaluate("e => e.scrollBy(0, e.scrollHeight)");
    }

}
