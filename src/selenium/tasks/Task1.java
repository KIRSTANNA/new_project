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
//
        System.out.println();
//        enter a text instead of a number, check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("JK");
        driver.findElement(By.className("w3-btn")).click();
        assertEquals("Please enter a number", driver.findElement(By.id("ch1_error")).getText();
        System.out.println();

//        assertEquals(elementTextOnPage."Please enter a number");
//        WebElement text = driver.findElement(By.id("show_me"));
    }

    private void assertEquals(String s) {
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen

        System.out.println();
//
        driver.findElement(By.id("numb")).sendKeys("9");
        driver.findElement(By.className("w3-btn")).click();
        assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText();
        System.out.println();


    }

    @Test
    public void errorOnNumberTooBig() {
//        TODO
        System.out.println();
//
        driver.findElement(By.id("numb")).sendKeys("130");
        driver.findElement(By.className("w3-btn")).click();
        assertEquals("Number is too big", driver.findElement(By.id("ch1_error")).getText();
        System.out.println();
//        enter number which is too big (above 100), check that correct error is seen
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
    }System.out.println();
//
   /*     driver.findElement((By.id("numb")).sendKeys("81"));
        driver.findElement((By.className("w3-btn")). click();
    assertEquals("", driver.findElement(By.id("ch1_error")).getText();
        System.out.println();

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
