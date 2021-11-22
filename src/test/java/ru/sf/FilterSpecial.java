package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public record FilterSpecial(WebDriver webDriver) {

    private static final String ERROR_MESSAGE = "div.catalog-no-items__title";
    private final static String FLOWERS = "//ul/li/div[contains(text(),'Цветы')]";
    private final static String COLOURS = "//ul/li[3]/div[contains(text(),'Цвет')]";
    private final static String LABEL2 = "//label[@data-role='label_arrFilter_25_326707096']";
    private final static String LABEL3 = "//label[@data-role='label_arrFilter_44_2483454842']";
    private final static String BUTTON_APPLY = "//ul/li[3]/div[2]/div/div[2]/input";

    public void chooseComposition() {
        WebElement webelement = webDriver.findElement(By.linkText("Композиции"));
        webelement.click();
    }
    public void selectPlantVarieties() {
        WebElement web = webDriver.findElement(By.xpath(FLOWERS));
        web.click();
        // List<WebElement> select = webDriver.findElements(By.className("checkbox"));
        webDriver().findElement(By.xpath(LABEL2)).click();
    }

    public void selectColour() {
        WebElement web = webDriver.findElement(By.xpath(COLOURS));
        web.click();
        // List<WebElement> select = webDriver.findElements(By.className("checkbox"));
        WebElement opt = webDriver.findElement(By.xpath(LABEL3));
        //for (WebElement option : select) {
        opt.click();
        webDriver().findElement(By.xpath(BUTTON_APPLY)).click();
    }

    public void getItemNotFoundMessage(String message) {
        WebElement elem = webDriver.findElement(By.cssSelector(ERROR_MESSAGE));
        message = elem.getText();
    }
}


