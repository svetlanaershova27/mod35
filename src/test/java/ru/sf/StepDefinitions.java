package ru.sf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


/**
 Created by me
 **/
public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final ChooseItemPage CHOOSE_ITEM_PAGE;
    public static final CallaLiliesPage CALLA_LILIES_PAGE;
    public static final FilterSpecial FILTER_SPECIAL;

    //Процесс инициализации необходимых ресурсов
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ersho\\IdeaProjects\\mod35\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
        webDriver.manage().window().maximize();
        CHOOSE_ITEM_PAGE = new ChooseItemPage(webDriver);
        CALLA_LILIES_PAGE = new CallaLiliesPage(webDriver);
        FILTER_SPECIAL = new FilterSpecial(webDriver);
    }

    @Then("assert that user was notified with message {string}")
    public void assertThatUserWasNotifiedWithMessage(String successMessage) {
        final var flowerMessage = CALLA_LILIES_PAGE.assertBouquetWasAddedToCard();
        assertEquals(successMessage, flowerMessage);
    }

    @When("chose an item on the main page")
    public void choseAnItemOnTheMainPage() {
        CHOOSE_ITEM_PAGE.chooseWeddingComposition();
        CHOOSE_ITEM_PAGE.selectSpecificSort();
    }

    @Then("chose the first item")
    public void choseTheFirstItem() {
        CALLA_LILIES_PAGE.getFirstItem();
    }

    @And("add item to card")
    public void addItemToCard() {
        CALLA_LILIES_PAGE.addItemToCard();

    }

    @When("chose an item applying  filters")
    public void choseAnItemApplyingFilters() {
        FILTER_SPECIAL.chooseComposition();
        FILTER_SPECIAL.selectPlantVarieties();
        FILTER_SPECIAL.selectColour();
    }

    @Then("assert that user saw message {string}")
    public void assertThatUserSawMessage( String message) {
        FILTER_SPECIAL.getItemNotFoundMessage(message);
    }

    @Given("url of website {string}")
    public void urlOfWebsite(String url) {
        CHOOSE_ITEM_PAGE.go(url);
    }
}
