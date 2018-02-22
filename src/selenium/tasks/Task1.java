package selenium.tasks;

import org.apache.xpath.operations.Equals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DecimalFormat;

import static java.lang.StrictMath.sqrt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
        WebElement numBox = driver.findElement(By.id("numb"));
        String newText = "abcdefg";
        numBox.sendKeys(newText);
        driver.findElement(By.className("w3-btn")).click();
        assertTrue(driver.findElement(By.id("ch1_error")).isDisplayed());
        assertEquals("Please enter a number", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        WebElement numBox = driver.findElement(By.id("numb"));
        String smallNum = "10";
        numBox.sendKeys(smallNum);
        driver.findElement(By.className("w3-btn")).click();
        assertTrue(driver.findElement(By.id("ch1_error")).isDisplayed());
        assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void errorOnNumberTooBig() {
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement numBox = driver.findElement(By.id("numb"));
        String bigNum = "105";
        numBox.sendKeys(bigNum);
        driver.findElement(By.className("w3-btn")).click();
        assertTrue(driver.findElement(By.id("ch1_error")).isDisplayed());
        assertEquals("Number is too big", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement numBox = driver.findElement(By.id("numb"));
        String numWithoutSquareRootRemainder = "64";
        numBox.sendKeys(numWithoutSquareRootRemainder);
        driver.findElement(By.className("w3-btn")).click();
        Alert alert = driver.switchTo().alert();
        assertTrue(alert.getText().contains("Square root of " + numWithoutSquareRootRemainder + " is " + sqrt(Double.parseDouble(numWithoutSquareRootRemainder))));
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        WebElement numBox = driver.findElement(By.id("numb"));
        String numWithSquareRootRemainder = "80";
        double squareRoot = sqrt(Double.parseDouble(numWithSquareRootRemainder));
        DecimalFormat df = new DecimalFormat("#.##");
        String dx=df.format(squareRoot);
        squareRoot=Double.valueOf(dx);
        numBox.sendKeys(numWithSquareRootRemainder);
        driver.findElement(By.className("w3-btn")).click();
        Alert alert = driver.switchTo().alert();
        assertTrue(alert.getText().contains("Square root of " + numWithSquareRootRemainder + " is " + squareRoot));
    }

}
