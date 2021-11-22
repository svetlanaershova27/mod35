package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public record ChooseItemPage(WebDriver webDriver) {

    private final static String LABEL = "//label[@data-role='label_arrFilter_25_1662243607']";
    private final static String FLOWERS = "//ul/li/div[contains(text(),'Цветы')]";
    private final static String BUTTON_APPLY = "input#set_filter.filter-btn";

    public void go(String url) {
        webDriver.get(url);
    }

    public void chooseWeddingComposition() {
        WebElement webelement = webDriver.findElement(By.linkText("Свадебные букеты"));
        webelement.click();
    }
    public void selectSpecificSort() {
        WebElement web = webDriver.findElement(By.xpath(FLOWERS));
        web.click();
        // List<WebElement> select = webDriver.findElements(By.className("checkbox"));
        WebElement opt = webDriver.findElement(By.xpath(LABEL));
        //for (WebElement option : select) {
        opt.click();
        webDriver().findElement(By.cssSelector(BUTTON_APPLY)).click();
    }}



