package com.qa.userinyerface.framework.utils.modalhandler;

import com.microsoft.playwright.Page;

public class ModalHandler {
    private Page page;
    private Thread modalWatcher;

    public ModalHandler(Page page) {
        this.page = page;
    }

    public void startWatching() {
        Thread modalWatcher = new Thread(() -> {
            while (true) {
                if (page.isVisible(".modal")) {
                    page.evaluate("document.querySelector('.modal')?.style.setProperty('display', 'none', 'important');");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        modalWatcher.setDaemon(true);
        modalWatcher.start();
    }

    public void stopWatching() {
        if (modalWatcher != null) {
            modalWatcher.interrupt();
        }
    }
}
