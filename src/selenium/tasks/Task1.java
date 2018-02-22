package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
    public void errorOnText() throws Exception   {
        driver.findElement(By.id("numb"));
        driver.findElement(By.id("numb")).sendKeys("qwerty");
        driver.findElement(By.tagName ("button")).click();
        assertEquals("Please enter a number",driver.findElement(By.id("ch1_error")).getText());

//        TODO
//        enter a text instead of a number, check that correct error is seen
    }

    @Test
    public void errorOnNumberTooSmall() {
        driver.findElement(By.id("numb"));
        driver.findElement(By.id("numb")).sendKeys("9");
        driver.findElement(By.tagName("button")).click();
        assertEquals("Number is too small",driver.findElement(By.id("ch1_error")).getText());


//        TODO
//        enter number which is too small (below 50), check that correct error is seen
    }

    @Test
    public void errorOnNumberTooBig() {
        driver.findElement(By.id("numb"));
        driver.findElement(By.id("numb")).sendKeys("200");
        driver.findElement(By.tagName("button")).click();
        assertEquals("Number is too big",driver.findElement(By.id("ch1_error")).getText());

//        TODO
//        enter number which is too big (above 100), check that correct error is seen
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
        driver.findElement(By.id("numb"));
        driver.findElement(By.id("numb")).sendKeys("64");
        driver.findElement(By.tagName("button")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 64 is 8.00",alert.getText());


//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
    }

    @Test
    public void correctSquareRootWithRemainder() {
        driver.findElement(By.id("numb"));
        driver.findElement(By.id("numb")).sendKeys("80");
        driver.findElement(By.tagName("button")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 80 is 8.94",alert.getText());
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
