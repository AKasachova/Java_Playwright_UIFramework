package com.qa.orangehr.pageObjects.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.List;
import java.util.stream.Collectors;

public class DropDownElement extends Element {
    private String dropDownXPath;

    public DropDownElement(Page page, String dropDownXPath) {
        super(page, dropDownXPath);
        this.dropDownXPath = dropDownXPath;
    }

    public Element getDropDownCaretDown(){
        String userRoleDropDownCaretDownXPath = String.format("%s//i[contains(@class, 'bi-caret-down-fill')]", this.dropDownXPath);
        return new Element(page, userRoleDropDownCaretDownXPath);
    }

    public String getDropDownOptionsWithoutDefaultXPath(){
        return String.format("%s//div[@class='oxd-select-option']//span",  this.dropDownXPath);
    }

    public String getDropDownOptionsWithDefaultXPath(){
        return String.format("%s//div[@class='oxd-select-option']",  this.dropDownXPath);
    }

    public void expandDropDown(){
        if (getDropDownCaretDown().isVisible()){
            getElement().click();
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
        List<Locator> allOptions = getAllDropDownOptionsWithDefault();
        if (!allOptions.isEmpty()) {
            allOptions.get(0).click();
        } else {
            System.out.println("Dropdown is empty. Cannot reset.");
        }
    }

    public List<String> getDropDownOptionsText() {
        List<Locator> allOptions = getAllDropDownOptionsWithoutDefault();
        return allOptions.stream()
                                .map(locator -> locator.innerText().trim())
                                .collect(Collectors.toList());
    }

    public String getSetDropDownOption() {
        return getElement().textContent();
    }
}
