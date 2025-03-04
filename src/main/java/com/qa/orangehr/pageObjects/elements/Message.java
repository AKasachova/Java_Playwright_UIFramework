package com.qa.orangehr.pageObjects.elements;

import com.microsoft.playwright.Page;

public class Message extends Element{
    private String messageSelector;

    public Message(Page page, String messageSelector) {
        super(page, messageSelector);
        this.messageSelector = messageSelector;
    }

    public void waitForMessageToBeAvailable() {
        waitForElementToBeAvailable();
    }

    public String getMessageText() {
        return getTextContent();
    }
}
