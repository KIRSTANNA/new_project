package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
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
//        enter a text instead of a number, check that correct error is see

        driver.findElement(By.id("numb")).sendKeys("eee");
        driver.findElement(By.className("w3-btn")).click();
        String expected = "Please enter a number";
        String actual = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expected,actual);
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("3");
        driver.findElement(By.className("w3-btn")).click();
        String expected = "Number is too small";
        String actual = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expected,actual);
    }

    @Test
    public void errorOnNumberTooBig() {
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("200");
        driver.findElement(By.className("w3-btn")).click();
        String expected = "Number is too big";
        String actual = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expected,actual);
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        driver.findElement(By.id("numb")).sendKeys("64");
        driver.findElement(By.className("w3-btn")).click();
        double b = 8;
        double square = Math.pow(b,2);
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 64 is 8.00", alert.getText());
        assertEquals(64,Math.pow(b,2),2 );
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        driver.findElement(By.id("numb")).sendKeys("55");
        driver.findElement(By.className("w3-btn")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 55 is 7.42 ", alert.getText());
    }
}
