package com.qa.orangehr.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.List;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected Locator getLocator(String xPath) {
        return page.locator(xPath);
    }

    public void chooseDropDownOption(String option, Locator dropDownOptionsLocator) {
        List<String> allDropDownOptions = dropDownOptionsLocator.allTextContents();
        for (int i = 0; i < allDropDownOptions.size(); i++) {
            if (allDropDownOptions.get(i).equals(option)) {
                dropDownOptionsLocator.nth(i).click();
                break;
            }
        }
    }
}
