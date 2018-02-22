package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;


public class Task1 {
    WebDriver driver;

    @Before
    public void openPage(){
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task1");
    }

    @After
    public void closeBrowser(){
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
//        enter a text instead of a number, check that correct error is seen
        WebElement inputField = driver.findElement(By.id("numb"));
        inputField.sendKeys("tttt");

        WebElement buttonSubmit = driver.findElement(By.tagName("button"));
        buttonSubmit.click();

        List<WebElement> errorMessages = driver.findElements(By.id("ch1_error"));
        assertTrue(errorMessages.size()>0);
        assertEquals("Please enter a number", errorMessages.get(0).getText());
    }


    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        WebElement inputField = driver.findElement(By.id("numb"));
        inputField.sendKeys("23");

        WebElement buttonSubmit = driver.findElement(By.tagName("button"));
        buttonSubmit.click();

        List<WebElement> errorMessages = driver.findElements(By.id("ch1_error"));

        assertTrue(errorMessages.size()>0);
        assertEquals("Number is too small", errorMessages.get(0).getText());

        inputField.sendKeys("49");

        buttonSubmit = driver.findElement(By.tagName("button"));
        buttonSubmit.click();

        errorMessages = driver.findElements(By.id("ch1_error"));

        assertTrue(errorMessages.size()>0);
        assertEquals("Number is too small", errorMessages.get(0).getText());
    }

    @Test
    public void errorOnNumberTooBig() {
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement inputField = driver.findElement(By.id("numb"));
        inputField.sendKeys("123");

        WebElement buttonSubmit = driver.findElement(By.tagName("button"));
        buttonSubmit.click();

        List<WebElement> errorMessages = driver.findElements(By.id("ch1_error"));

        assertTrue(errorMessages.size()>0);
        assertEquals("Number is too big", errorMessages.get(0).getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly

        WebElement inputField = driver.findElement(By.id("numb"));
        inputField.sendKeys("81");

        WebElement buttonSubmit = driver.findElement(By.tagName("button"));
        buttonSubmit.click();

        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 81 is 9.00", alert.getText());
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        WebElement inputField = driver.findElement(By.id("numb"));
        inputField.sendKeys("80");

        WebElement buttonSubmit = driver.findElement(By.tagName("button"));
        buttonSubmit.click();

        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 80 is 8.94", alert.getText());
    }
}
