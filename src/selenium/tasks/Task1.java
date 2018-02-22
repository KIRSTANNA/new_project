package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Task1 {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/test-sample/tasks/task1";
    String Button = "w3-btn";

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
        assertEquals(base_url, driver.getCurrentUrl());

        String word = "Text";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(word);


        driver.findElement(By.className(Button)).click();

        assertEquals("Please enter a number", driver.findElement(By.id("ch1_error")).getText());
                   }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        assertEquals(base_url, driver.getCurrentUrl());

        String numberSmall = "7";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(numberSmall);

        driver.findElement(By.className(Button)).click();

        assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void errorOnNumberTooBig() {
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        assertEquals(base_url, driver.getCurrentUrl());

        String numberBig = "101";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(numberBig);

        driver.findElement(By.className(Button)).click();

        assertEquals("Number is too big", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        assertEquals(base_url, driver.getCurrentUrl());

        String square = "64";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(square);

        driver.findElement(By.className(Button)).click();

        Alert alert = driver.switchTo().alert();

        assertEquals("Square root of 64 is 8.00",alert.getText());
        alert.accept();

        assertEquals(base_url, driver.getCurrentUrl());
        assertEquals("", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        assertEquals(base_url, driver.getCurrentUrl());

        String square = "63";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(square);

        driver.findElement(By.className(Button)).click();

        Alert alert = driver.switchTo().alert();

        assertEquals("Square root of 63 is 7.94",alert.getText());
        alert.accept();

        assertEquals(base_url, driver.getCurrentUrl());
        assertEquals("", driver.findElement(By.id("ch1_error")).getText());
    }
}
