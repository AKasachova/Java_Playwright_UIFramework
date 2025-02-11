package com.qa.orangehr.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.List;
import java.util.stream.Collectors;

public class DropDownElement extends Element {

    public DropDownElement(Page page, String dropDownXPath) {
        super(page, dropDownXPath);
    }

    public void expandDropDown(Element dropDownCaretDown){
        if (dropDownCaretDown.isVisible()){
        getElement().click();
        }
    }

    public List<Locator> getAllDropDownOptions(String xPathForOptions){
        return page.locator(xPathForOptions).all();
    }

    public void chooseDropDownOption(String optionToChoose, String xPathForOptions) {
        List<Locator> allOptions = getAllDropDownOptions(xPathForOptions);
        for (Locator option : allOptions) {
            if (option.textContent().equals(optionToChoose)) {
                option.click();
                break;
            }
        }
    }

    public void resetDropDownOptions(String xPathForOptionsIncludingDefault) {
        List<Locator> allOptions = getAllDropDownOptions(xPathForOptionsIncludingDefault);
        if (!allOptions.isEmpty()) {
            allOptions.get(0).click();
        } else {
            System.out.println("Dropdown is empty. Cannot reset.");
        }
    }

    public List<String> getDropDownOptionsText(String xpathForOptions) {
        List<Locator> allOptions = getAllDropDownOptions(xpathForOptions);
        return allOptions.stream()
                                .map(locator -> locator.innerText().trim())
                                .collect(Collectors.toList());
    }

    public String getSetDropDownOption() {
        return getElement().textContent();
    }
}
