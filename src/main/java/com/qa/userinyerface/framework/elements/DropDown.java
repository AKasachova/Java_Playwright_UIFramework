package com.qa.userinyerface.framework.elements;

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


    public String getDropDownOptionsSelector(){
        return String.format("%s//div[@class='dropdown__list']//div",  this.dropDownSelector);
    }

    public String getSetDropDownOptionSelector() {
        return String.format(getDropDownOptionsSelector() + "[contains(@class, 'selected')]");
    }


    public void expandDropDown(){
           click();
    }

    public List<Locator> getAllDropDownOptions(){
        return page.locator(getDropDownOptionsSelector()).all();
    }


    public void chooseDropDownOption(String optionToChoose) {
        expandDropDown();
        List<Locator> allOptions = getAllDropDownOptions();
        for (Locator option : allOptions) {
            if (option.textContent().equals(optionToChoose)) {
                option.click();
                break;
            }
        }
    }

    public void resetDropDownOptions() {
        expandDropDown();
        List<Locator> allOptions = getAllDropDownOptions();
        if (!allOptions.isEmpty()) {
            allOptions.get(0).click();
        } else {
            System.out.println("Dropdown is empty. Cannot reset.");
        }
    }

    public List<String> getDropDownOptionsText() {
        expandDropDown();
        List<Locator> allOptions = getAllDropDownOptions();
        return allOptions.stream()
                                .map(locator -> locator.innerText().trim())
                                .collect(Collectors.toList());
    }

    public String getSetDropDownOption() {
        return page.locator(getSetDropDownOptionSelector()).textContent();
    }
}
