package com.qa.framework.modules;

import com.microsoft.playwright.Page;
import com.qa.framework.elements.CheckBox;

import java.util.*;

public class CheckBoxesPanel extends CheckBox{
    private Page page;
    private List<CheckBox> checkBoxes;

    public CheckBoxesPanel(Page page, String checkBoxesSelector) {
        super(page, checkBoxesSelector);
        this.page = page;
        this.checkBoxes = new ArrayList<>();

        for (int i = 0; i < page.locator(checkBoxesSelector).count(); i++) {
            checkBoxes.add(new CheckBox(page, "(" + checkBoxesSelector + ")" + "[" + (i + 1) + "]"));
        }
    }

    protected List<String>  getAllCheckBoxesText(String checkBoxTextSelector) {
        List<String> allCheckBoxesText = new ArrayList<>();
        for (int i = 0; i < checkBoxes.size(); i++) {
            allCheckBoxesText.add(checkBoxes.get(i).getCheckBoxText(checkBoxTextSelector));
        }
        return allCheckBoxesText;
    }

    public void unselectAllCheckBoxes(String textOfCheckBoxToUnselectAll, String checkBoxTextSelector, String checkBoxIconSelector) {
        List<String> allCheckBoxesText = getAllCheckBoxesText(checkBoxTextSelector);
        for (int i = 0; i < allCheckBoxesText.size(); i++) {
            if (allCheckBoxesText.get(i).equals(textOfCheckBoxToUnselectAll)) {
                checkBoxes.get(i).clickOnCheckBoxIcon(checkBoxIconSelector);
            }
        }
    }

    public void clickRandomCheckBoxes(int count, String textOfCheckBoxToUnselectAll, String checkBoxTextSelector,  String checkBoxIconSelector) {
        unselectAllCheckBoxes(textOfCheckBoxToUnselectAll, checkBoxTextSelector, checkBoxIconSelector);
        List<CheckBox> filteredCheckBoxes = checkBoxes.stream()
                .filter(checkBox -> !checkBox.getTextContent().equals(textOfCheckBoxToUnselectAll))
                .toList();
        if (count > filteredCheckBoxes.size()) {
            throw new IllegalArgumentException("The requested number of checkboxes exceeds the available list after filtering.");
        }
        Random random = new Random();
        Set<Integer> selectedIndexes = new HashSet<>();
        while (selectedIndexes.size() < count) {
            int randomIndex = random.nextInt(filteredCheckBoxes.size());
            selectedIndexes.add(randomIndex);
        }
        for (int index : selectedIndexes) {
            filteredCheckBoxes.get(index).clickOnCheckBoxIcon(checkBoxIconSelector);
            page.waitForTimeout(1000);
        }
    }
}
