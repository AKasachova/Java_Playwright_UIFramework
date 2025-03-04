package com.qa.orangehr.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Element {
    protected Page page;
    protected String xPath;
    //Не совсем корректно называть локатор xPath потому что сюда можно добавлять
    //и css локаторы

    public Element(Page page, String xPath) {
        this.page = page;
        this.xPath = xPath;
    }

    //я бы сделала еще один конструктор, который может принимать комент
    //(просто стрингу) с коментом конктетизирующим элемент, потому что
    //не всегда можно быстро на странице найти элемент

    protected Locator getElement() {
        return page.locator(xPath);
    }
    /*здесь архитектурный нюанс
    разберу на примере

      public void expandDropDown(){
        if (getDropDownCaretDown().isVisible()){
           --------> getElement().click();
        }
    }

    ты передаешь getElement в класс DropDownElement в метод expandDropDown()
    чтобы кликнуть по нему, но это избыточно ты можешь в этот методе кликнуть сразу
    по DropDownElement

     public void expandDropDown(){
        if (getDropDownCaretDown().isVisible()){
           --------> getDropDownCaretDown().click();
        }
    }

    то есть по логике в классе Element у тебя должны быть методы покрывающие
    основные действия с элементами и все классы наследники должны использовать
    просто эти методы, передовать локатор можно только в исключительных случаях,
    для реализации тех дейтсвий, которые могут выполняться исключительно в определенном классе
     */


    protected Page getPage() {
        return page;
    }

    public void click() {
        getElement().click();
    }

    public void fillField(String text) {
        getElement().fill(text);
    }

    public String getTextContent() {
        return getElement().textContent();
    }

    public void waitForXPathToBeAvailable() {
        page.waitForSelector(xPath);
    }

    public boolean isVisible() {
        return getElement().isVisible();
    }

}
