package com.qa.orangehr.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

public class DropDownElement extends Element {
    public DropDownElement(Page page, String xPath) {
        super(page, xPath);
    }

    public void chooseDropDownOption(String option) {
//        List<String> allDropDownOptions = getDropDownOptions();
//        for (int i = 0; i < allDropDownOptions.size(); i++) {
//            if (allDropDownOptions.get(i).equals(option)) {
//                dropDownOptionsLocator.nth(i).click();
//                break;
//            }
//        }
    }

    public List<String> getDropDownOptions() {
        return getElement().allTextContents();
    }
}
