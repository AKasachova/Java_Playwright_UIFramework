package com.qa.framework.elements;

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

    private Element getDropDownCaretDown(String caretDownSelector){
        String userRoleDropDownCaretDownXPath = String.format("%s" + caretDownSelector,
                this.dropDownSelector);
        return new Element(page, userRoleDropDownCaretDownXPath);
    }

    protected String getDropDownOptionsWithoutDefaultXPath(String dropDownOptionsWithoutDefaultSelector){
        return String.format("%s" + dropDownOptionsWithoutDefaultSelector,  this.dropDownSelector);
    }

    private String getDropDownOptionsWithDefaultXPath(String dropDownOptionsWithDefaultSelector){
        return String.format("%s" + dropDownOptionsWithDefaultSelector,  this.dropDownSelector);
    }

    public void expandDropDown(String caretDownSelector){
        if (getDropDownCaretDown(caretDownSelector).isVisible()){
            getDropDownCaretDown(caretDownSelector).click();
        }
    }

    public void expandDropDown(){
        click();
    }

    public List<Locator> getAllDropDownOptionsWithoutDefault(String dropDownOptionsWithoutDefaultSelector){
        return page.locator(getDropDownOptionsWithoutDefaultXPath(dropDownOptionsWithoutDefaultSelector)).all();
    }

    public List<Locator> getAllDropDownOptionsWithDefault(String dropDownOptionsWithDefaultSelector) {
        return page.locator(getDropDownOptionsWithDefaultXPath(dropDownOptionsWithDefaultSelector)).all();
    }

    public void chooseDropDownOption(String optionToChoose, String dropDownOptionsWithoutDefaultSelector) {
        List<Locator> allOptions = getAllDropDownOptionsWithoutDefault(dropDownOptionsWithoutDefaultSelector);
        for (Locator option : allOptions) {
            if (option.textContent().equals(optionToChoose)) {
                option.click();
                break;
            }
        }
    }

    public void resetDropDownOptions(String dropDownOptionsWithDefaultSelector) {
        List<Locator> allOptions = getAllDropDownOptionsWithDefault(dropDownOptionsWithDefaultSelector);
        if (!allOptions.isEmpty()) {
            allOptions.get(0).click();
        } else {
            System.out.println("Dropdown is empty. Cannot reset.");
        }
    }

    public List<String> getDropDownOptionsText(String dropDownOptionsWithoutDefaultSelector) {
        List<Locator> allOptions = getAllDropDownOptionsWithoutDefault(dropDownOptionsWithoutDefaultSelector);
        return allOptions.stream()
                                .map(locator -> locator.innerText().trim())
                                .collect(Collectors.toList());
    }

    public String getSetDropDownOption() {
        return getTextContent();
    }
}
