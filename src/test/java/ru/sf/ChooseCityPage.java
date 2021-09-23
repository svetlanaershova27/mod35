package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

//Что такое record 'https://www.baeldung.com/java-record-keyword'

//Имплементация паттерна Page Object Model
public record ChooseCityPage(WebDriver webDriver) {

    private static final String SEARCH_FIELD_CLASS = "locality-selector-popup__search-input";
    private static final String ERROR_MESSAGE_SPAN_CLASS = "locality-selector-popup__table-empty-text";

    public void go(String url) {
        webDriver.get(url);
    }

    public void searchCity(String city) {
        final var searchInput = webDriver.findElement(By.className(SEARCH_FIELD_CLASS));
        searchInput.sendKeys(city, Keys.ENTER);
    }

    public String getCityNotFoundMessage() {
        return webDriver.findElement(By.className(ERROR_MESSAGE_SPAN_CLASS)).getText();
    }
}
