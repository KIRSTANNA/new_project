package selenium.tasks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

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
        String expectedMessage = "Please enter a number";
        driver.findElement(By.id("numb")).sendKeys("skdfjhksj");
        driver.findElement(By.className("w3-btn")).click();
        String acctualMessage = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expectedMessage, acctualMessage);


    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        String expectedMessage = "Number is too small";
        driver.findElement(By.id("numb")).sendKeys("45");
        driver.findElement(By.className("w3-btn")).click();
        String acctualMessage = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expectedMessage, acctualMessage);

    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO

        String expectedMessage = "Number is too big";
        driver.findElement(By.id("numb")).sendKeys("110");
        driver.findElement(By.className("w3-btn")).click();
        String acctualMessage = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expectedMessage, acctualMessage);
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly

        String expectedMessage = "Square root of 81 is 9.00";
        driver.findElement(By.id("numb")).sendKeys("81");
        driver.findElement(By.className("w3-btn")).click();
        Alert alert = driver.switchTo().alert();
        String acctualMessage = alert.getText();
        assertEquals(expectedMessage, acctualMessage);
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly

        String expectedMessage = "Square root of 65 is 8.06";
        driver.findElement(By.id("numb")).sendKeys("65");
        driver.findElement(By.className("w3-btn")).click();
        Alert alert = driver.switchTo().alert();
        String acctualMessage = alert.getText();
        assertEquals(expectedMessage, acctualMessage);
    }
}
