package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void errorOnText() throws Exception {
        //get title of page
        //System.out.println(driver.getTitle());

//     enter a text instead of a number, check that correct error is seen
        String invalidString = "invalid";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(invalidString);
        //
        driver.findElement(By.className("w3-btn")).click();
        //
        assertTrue(driver.findElement(By.id("ch1_error")).isDisplayed());
        assertEquals("Please enter a number", driver.findElement(By.id("ch1_error")).getText());
    }


    @Test
    public void errorOnNumberTooSmall() {
//        enter number which is too small (below 50), check that correct error is seen
        String number = "49";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
        driver.findElement(By.className("w3-btn")).click();
        //
        assertTrue(driver.findElement(By.id("ch1_error")).isDisplayed());
        assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void errorOnNumberTooBig() {
//        TODO
        String number = "101";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
        driver.findElement(By.className("w3-btn")).click();
        //
        assertTrue(driver.findElement(By.id("ch1_error")).isDisplayed());
        assertEquals("Number is too big", driver.findElement(By.id("ch1_error")).getText());

//        enter number which is too big (above 100), check that correct error is seen
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
        String number = "81";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
        driver.findElement(By.className("w3-btn")).click();
      //  assertFalse(driver.findElement(By.id("ch1_error")).isDisplayed());
        //        switch to alert
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 81 is 9.00", alert.getText());
//        click ok
        alert.accept();
        assertFalse(driver.findElement(By.id("ch1_error")).isDisplayed());
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly

    }

    @Test
    public void correctSquareRootWithRemainder() {
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        String number = "84.64";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
        driver.findElement(By.className("w3-btn")).click();
        //  assertFalse(driver.findElement(By.id("ch1_error")).isDisplayed());
        //        switch to alert
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 84.64 is 9.20", alert.getText());
//        click ok
        alert.accept();
        assertFalse(driver.findElement(By.id("ch1_error")).isDisplayed());
    }
}
