package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.StrictMath.sqrt;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task1");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
//        enter a text instead of a number, check that correct error is seen
        // String number = "blabla";
        driver.findElement(By.id("numb")).clear();// clear field
        driver.findElement(By.id("numb")).sendKeys("blabla");
        driver.findElement(By.className("w3-btn")).click();
        String expectedmessage = "Please enter a number";
        String actual = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expectedmessage, actual);
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("10");
        driver.findElement(By.className("w3-btn")).click();
        String expectedmessage = "Number is too small";
        String actual = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expectedmessage, actual);

    }

    @Test
    public void errorOnNumberTooBig() {
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("110");
        driver.findElement(By.className("w3-btn")).click();
        String expectedmessage = "Number is too big";
        String actual = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expectedmessage, actual);
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        driver.findElement(By.id("numb")).sendKeys("100");
        driver.findElement(By.className("w3-btn")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Alert alert2 = driver.switchTo().alert();
        assertEquals("Square root of 100 is 10.00", alert2.getText());
        alert2.accept();
        //try to check if the program is calculating correctly:
        //String myNumb = "100";
        //String myRoot = "10";
        //int numb = Integer.parseInt(myNumb);
        //int root = Integer.parseInt(myRoot);




    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        driver.findElement(By.id("numb")).sendKeys("50");
        driver.findElement(By.className("w3-btn")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Alert alert2 = driver.switchTo().alert();
        assertEquals("Square root of 50 is 7.07", alert2.getText());
        alert2.accept();
        //try to
        String checkNumber = "50";
        double checkRoot = sqrt(Double.parseDouble(checkNumber));
    }

    @Test
    public void error666() {
//        TODO
//        enter number 666, check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("666");
        driver.findElement(By.className("w3-btn")).click();
        String expectedmessage = "Number is too big";
        String actual = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expectedmessage, actual);

    }
}
