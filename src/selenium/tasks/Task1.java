package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
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
        WebElement textArea = driver.findElement(By.id("numb"));
        String newTextOne = " sending String";
        textArea.sendKeys(newTextOne);
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();
        assertEquals("Please enter a number", driver.findElement(By.id("ch1_error")).getText());
//        enter a text instead of a number, check that correct error is seen
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
        WebElement textArea = driver.findElement(By.id("numb"));
        String newIntOne = "1";
        textArea.sendKeys(newIntOne);
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();
        assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
//        enter number which is too small (below 50), check that correct error is seen
    }

    @Test
    public void errorOnNumberTooBig() {
//        TODO
        WebElement textArea = driver.findElement(By.id("numb"));
        String newIntOne = "101";
        textArea.sendKeys(newIntOne);
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();
        assertEquals("Number is too big", driver.findElement(By.id("ch1_error")).getText());
//        enter number which is too big (above 100), check that correct error is seen
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
        WebElement textArea = driver.findElement(By.id("numb"));
        String newIntOne = "100";
        double sqrt = Math.sqrt(100);
        textArea.sendKeys(newIntOne);
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of " + newIntOne + " is " + String.format("%4.2f" , sqrt), alert.getText());
        assertTrue(alert.getText().contains(String.format("%4.2f" , sqrt)));
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
        WebElement textArea = driver.findElement(By.id("numb"));
        String newIntOne = "72";
        double sqrt = Math.sqrt(72);
        textArea.sendKeys(newIntOne);
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of " + newIntOne + " is " + String.format("%4.2f" , sqrt), alert.getText());
        assertTrue(alert.getText().contains(String.format("%4.2f" , sqrt)));
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
