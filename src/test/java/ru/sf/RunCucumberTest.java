package ru.sf;

import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

//Конфигурация, требующаяся для запуска сценариев через JUnit4
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features")
public class RunCucumberTest {
    //Закрываем браузер, когда тесты отработали
    @After
    public static void finalizeResources() {
        StepDefinitions.webDriver.quit();
    }
}
