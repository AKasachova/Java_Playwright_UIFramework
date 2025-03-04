package com.qa.orangehr.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.List;
import java.util.stream.Collectors;

public class DropDown extends Element {
    private String dropDownSelector;

    public DropDown(Page page, String dropDownSelector) {
        super(page, dropDownSelector);
        this.dropDownSelector = dropDownSelector;
    }

    public Element getDropDownCaretDown(){
        String userRoleDropDownCaretDownXPath = String.format("%s//i[contains(@class, 'bi-caret-down-fill')]", this.dropDownSelector);
        return new Element(page, userRoleDropDownCaretDownXPath);
    }

    public String getDropDownOptionsWithoutDefaultXPath(){
        return String.format("%s//div[@class='oxd-select-option']//span",  this.dropDownSelector);
    }

    public String getDropDownOptionsWithDefaultXPath(){
        return String.format("%s//div[@class='oxd-select-option']",  this.dropDownSelector);
    }

    public void expandDropDown(){
        if (getDropDownCaretDown().isVisible()){
            getDropDownCaretDown().click();
        }
    }

    public List<Locator> getAllDropDownOptionsWithoutDefault(){
        return page.locator(getDropDownOptionsWithoutDefaultXPath()).all();
    }

    public List<Locator> getAllDropDownOptionsWithDefault(){
        return page.locator(getDropDownOptionsWithDefaultXPath()).all();
    }

    public void chooseDropDownOption(String optionToChoose) {
        expandDropDown();
        List<Locator> allOptions = getAllDropDownOptionsWithoutDefault();
        for (Locator option : allOptions) {
            if (option.textContent().equals(optionToChoose)) {
                option.click();
                break;
            }
        }
    }

    public void resetDropDownOptions() {
        expandDropDown();
        List<Locator> allOptions = getAllDropDownOptionsWithDefault();
        if (!allOptions.isEmpty()) {
            allOptions.get(0).click();
        } else {
            System.out.println("Dropdown is empty. Cannot reset.");
        }
    }

    public List<String> getDropDownOptionsText() {
        expandDropDown();
        List<Locator> allOptions = getAllDropDownOptionsWithoutDefault();
        return allOptions.stream()
                                .map(locator -> locator.innerText().trim())
                                .collect(Collectors.toList());
    }

    public String getSetDropDownOption() {
        return getTextContent();
    }
}
