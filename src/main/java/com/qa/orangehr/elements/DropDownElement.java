package com.qa.orangehr.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class DropDownElement extends Element {
    public DropDownElement(Page page, String xPath) {
        super(page, xPath);
    }

    public void chooseDropDownOption(String option) {
        List<Locator> elements = getElements();
        for (Locator element : elements) {
            if (element.textContent().equals(option)) {
               element.click();
                break;
            }
        }
    }

    public List<String> getDropDownOptions() {
        return getElement().allTextContents();
    }
}
