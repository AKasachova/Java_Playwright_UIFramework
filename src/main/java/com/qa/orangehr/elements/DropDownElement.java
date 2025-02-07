package com.qa.orangehr.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownElement extends Element {
    private String dropDownOptionXPath;
    private String dropDownOptionForTextExtraction;

    public DropDownElement(Page page, String dropDownXPath, String dropDownOptionXPath, String dropDownOptionForTextExtraction) {
        super(page, dropDownXPath);
        this.dropDownOptionXPath = dropDownOptionXPath;
        this.dropDownOptionForTextExtraction = dropDownOptionForTextExtraction;
    }

    public void expandDropDown(){
        getElement().click();
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

    public boolean checkDropDownOptionsCount(int expectedOptionsCount) {
        expandDropDown();
        List<Locator> allOptions = getAllDropDownOptions();
        int optionCount = allOptions.size();
        if(optionCount != expectedOptionsCount){
            System.out.println("The drop down options count mismatches!" + optionCount + " != " + expectedOptionsCount);
            return false;
        }
        return true;
    }

    public boolean checkDropDownOptionsText(List<String> expectedOptionsText) {
        expandDropDown();
        List<Locator> allOptions = getAllDropDownOptionsWithText();

        List<String> allOptionsText = allOptions.stream()
                                                .map(locator -> locator.innerText().trim())
                                                .collect(Collectors.toList());

        for (String expectedOption : expectedOptionsText) {
            if (!allOptionsText.contains(expectedOption)) {
                System.out.println("Missing drop-down option: " + expectedOption);
                return false;
            }
        }
        return true;
    }

    public List<Locator> getAllDropDownOptions(){
        return page.locator(dropDownOptionXPath).all();
    }

    public List<Locator> getAllDropDownOptionsWithText(){
        return page.locator(dropDownOptionForTextExtraction).all();
    }

    public String getSetDropDownOption() {
        return getElement().textContent();
    }
}
