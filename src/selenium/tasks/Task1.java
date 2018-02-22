package selenium.tasks;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.Alert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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


            String expected = "Please enter a number";
            driver.findElement(By.id("numb")).sendKeys("nnnn");
            driver.findElement(By.className("w3-btn w3-orange w3-margin"))
            String actual = driver.findElement(By.id("error")).getText();
            assertEquals(expected, actual);

//        TODO
//        enter a text instead of a number, check that correct error is seen
    }

    @Test
    public void errorOnNumberTooSmall() {

        String expected = "Number is too small";
        driver.findElement(By.id("numb")).sendKeys("40");
        driver.findElement(By.className("w3-btn")).click();
        String actualMessage = driver.findElement(By.id("ch1_error")).getText();

        assertEquals(expected, actualMessage);

//        TODO
//        enter number which is too small (below 50), check that correct error is seen
    }

    @Test
    public void errorOnNumberTooBig() {

        driver.findElement(By.id(""));
        String expected = "ch1_error";
        String actual = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expected, actual);
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
            driver.findElement(By.id("numb")).sendKeys("81");
            Alert alert = driver.switchTo().alert();
            String msg = alert.getText();
            System.out.println(msg);
            System.out.println();
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
    }

    @Test
    public void correctSquareRootWithRemainder() {
        driver.findElement(By.id("numb")).sendKeys("80");
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        System.out.println(msg);
        System.out.println();

//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
