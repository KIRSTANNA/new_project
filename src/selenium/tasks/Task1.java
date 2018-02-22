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
        System.out.println();
        driver.findElement(By.id("numb")).sendKeys(("loool"));
        driver.findElement(By.className("w3-btn")).click();

        assertEquals("Please enter a number", driver.findElement(By.id("ch1_error")).getText());
        System.out.println();

//        enter a text instead of a number, check that correct error is seen
    }

    @Test
    public void errorOnNumberTooSmall()
        /* if i enter 49 it finds the square root of it, insted of messsge"number is too small".
         if I enter number 666 no errors where shown
              */ {
        System.out.println();
        driver.findElement(By.id("numb")).sendKeys(("47"));
        driver.findElement(By.className("w3-btn")).click();

        assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
        System.out.println();


        System.out.println();



//        enter number which is too small (below 50), check that correct error is seen
    }

    @Test
    public void errorOnNumberTooBig() {
//        System.out.println();
        driver.findElement(By.id("numb")).sendKeys(("112"));
        driver.findElement(By.className("w3-btn")).click();

        assertEquals("Number is too big", driver.findElement(By.id("ch1_error")).getText());
        System.out.println();


        System.out.println();

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
