package com.kodilla.testing2.crudapp;

import kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;

public class CrudAppTestSuite {

    private  static final String BASE_URL = "https://katarzynaaniszewska.github.io/";
    private WebDriver driver;
    private Random generator;
    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(BASE_URL );
        generator = new Random();
    }
    @After
    public void cleanUpAfterTest() {
        driver.close();
    }
    @Test
    private String  createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT ="//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_TASK_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + "content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_TASK_BUTTON));
        addButton.click();
        Thread.sleep(2000);
        return taskName;
    }
    @Test
    public void sendTestTaskToTrello(String taskName) throws InterruptedException {

        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class = \"datable_row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(.//p[@class=\"datable_field-value\"]"))
                                                     .getText().equals(taskName))

                .forEach(theForm -> {   
                    WebElement selectElemnt = theForm.findElement(By.xpath("//select[1]"));
                    Select select = new Select(selectElemnt);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
    }
    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "http://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("katarzynawojcik13");
        driverTrello.findElement(By.id("password")).sendKeys("igor2011");
        driverTrello.findElement(By.id("login")).submit();
        Thread.sleep(2000);
        driverTrello.findElements(By.xpath("//a[@class=\"board-title\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla Board\"]")).size()>0)
                .forEach(aHref->aHref.click());

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .filter(theSpan ->theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size()>0;
        driverTrello.close();
        return result;

    }
    @Test
    public void shouldCreateTrelloCard()throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));

        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT ="//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";


        driver.findElements(By.xpath(XPATH_TASK_NAME)).stream()
        .collect(Collectors.toList())
        .listIterator().remove();

        driver.findElements(By.xpath(XPATH_TASK_CONTENT)).stream()
                .collect(Collectors.toList())
                .listIterator().remove();
    }
}
