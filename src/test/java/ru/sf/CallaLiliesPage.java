package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public record CallaLiliesPage(WebDriver webDriver) {

    private final static String BOUQUET_LINK = "Свадебный букет невесты из калл";
    private final static String BUTTON = "button#bx_3966226736_845_7e1b8e3524755c391129a9d7e6f2d206_buy_link";

    public void getFirstItem() {

        WebElement getItem = webDriver.findElement(By.linkText(BOUQUET_LINK));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView()", getItem);

    }
    public void addItemToCard() {
        WebElement button = webDriver.findElement(By.cssSelector(BUTTON));
        button.click();
    }
    public  String assertBouquetWasAddedToCard() {
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-add-basket")));
        String successMessage = webDriver.findElement(By.className("modal-add-basket")).getText();
        return successMessage;
    }

}
