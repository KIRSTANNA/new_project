package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DecimalFormat;

import static java.lang.Math.sqrt;
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
        driver.findElement(By.id("numb")).sendKeys("blabla");
        driver.findElement(By.className("w3-btn")).click();
        String expected = "Please enter a number";
        String actual = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expected, actual);
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("7");
        driver.findElement(By.className("w3-btn")).click();
        String expected = "Number is too small";
        String actual = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expected, actual);
    }

    @Test
    public void errorOnNumberTooBig() {
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("110");
        driver.findElement(By.className("w3-btn")).click();
        String expected = "Number is too big";
        String actual = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expected, actual);
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        driver.findElement(By.id("numb")).sendKeys("49");
        driver.findElement(By.className("w3-btn")).click();
        Alert alert = driver.switchTo().alert();
        String expected = "Square root of 49 is 7.00";
        String actual = alert.getText();
        assertEquals(expected, actual);
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        WebElement input = driver.findElement(By.id("numb"));
        String enterNumber = "50";
        double squareRoot = sqrt(Double.parseDouble(enterNumber));
        DecimalFormat dFormat = new DecimalFormat("#.##");
        String result = dFormat.format(squareRoot);
        squareRoot = Double.valueOf(result);

        input.sendKeys(enterNumber);
        driver.findElement(By.className("w3-btn")).click();
        Alert alert = driver.switchTo().alert();
        assertTrue(alert.getText().contains("Square root of "+enterNumber+ " is "+squareRoot));
    }

    @Test
    public void numberSixNoErrors() {
        driver.findElement(By.id("numb")).sendKeys("666");
        driver.findElement(By.className("w3-btn")).click();
        String expected = "";
        String actual = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expected, actual);
    }

}
