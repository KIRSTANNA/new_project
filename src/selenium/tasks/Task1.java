package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Task1 {
    WebDriver driver;

    @Before
    public void openPage(){
        assertTrue (true);
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
        /*WebElement textArea = driver.findElement(By.id("text_area"));
        String originalTextInTextArea = "This is a text area";*/
        driver.findElement(By.id("numb")) .sendKeys("some keys");
        driver.findElement(By.className("w3-btn")).click();

        assertTrue(driver.findElement(By.id("ch1_error")).getText().contains("Please enter a number"));




//        TODO
//        enter a text instead of a number, check that correct error is seen
    }

    @Test
    public void errorOnNumberTooSmall() {
        driver.findElement(By.id("numb")) .sendKeys("11");
        driver.findElement(By.className("w3-btn")).click();

        assertTrue(driver.findElement(By.id("ch1_error")).getText().contains("Number is too small"));
        /*WebElement textArea = driver.findElement(By.id("numb"));
        String newText = "11";

        textArea.sendKeys(newText);
        driver.findElement(By.className("w3-btn")).click();


        assertTrue(driver.findElement(By.id("ch1_error")).getText().contains("Number is too small"));*/
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
    }

    @Test
    public void errorOnNumberTooBig() {
        driver.findElement(By.id("numb")) .sendKeys("999");
        driver.findElement(By.className("w3-btn")).click();

        assertTrue(driver.findElement(By.id("ch1_error")).getText().contains("Number is too big"));
        /*WebElement textArea = driver.findElement(By.id("numb"));
        String newText = "11";

        textArea.sendKeys(newText);
        driver.findElement(By.className("w3-btn")).click();


        assertTrue(driver.findElement(By.id("ch1_error")).getText().contains("Number is too small"));*/
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
