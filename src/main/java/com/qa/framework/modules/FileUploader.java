package com.qa.framework.modules;

import com.microsoft.playwright.Page;
import com.qa.framework.elements.Link;
import com.qa.framework.utils.config.ConfigUtils;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploader {
    private Page page;
    private Link uploadLink;

    public FileUploader(Page page, Link uploadLink) {
        this.page = page;
        this.uploadLink = uploadLink;
    }

    public void uploadFile() throws AWTException {
        //is it necessary to add separate method for link clicking?
        uploadLink.clickLink();
        Robot robot = new Robot();
        StringSelection str = new StringSelection(System.getProperty("user.dir") + ConfigUtils.getConfigProperties().getProperty("imgToUploadPath"));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        page.waitForTimeout(1000);
    }
}
