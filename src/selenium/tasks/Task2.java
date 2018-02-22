package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;
import static org.junit.Assert.*;

public class Task2 {
    WebDriver driver;
    private static WebDriverWait wait;

    @Before
    public void openPage(){
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        driver.get("https://kristinek.github.io/test-sample/tasks/task2");
    }

    @After
    public void closeBrowser(){
        driver.close();
    }

    @Test
    public void loadGreen(){
		 // 1) click on start loading green button
        assertTrue(driver.findElement(By.id("start_green")).isDisplayed());
        driver.findElement(By.id("start_green")).click();
		 // 2) check that button does not appear, but loading text is seen instead
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='magic_text']/*[text()=\"What is this magic? It's dev magic~\"]")));
        //        magicTextCheck();
        //driver.findElement(By.id("finish_green")).isDisplayed();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish_green")));
		 //  3) check that both button and loading text is not seen, success is seen instead
    }

    @Test
    public void loadGreenAndBlueBonus(){
		 // 0) wait until button to load green and blue appears
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("start_green_and_blue")));
        final String buttonGB = "//*[@id='start_green_and_blue']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(buttonGB)));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(buttonGB)));
        // 1) click on start loading green and blue button
        //driver.findElement(By.id("start_green_and_blue")).click();
        driver.findElement(By.xpath(buttonGB)).click();
        // 2) check that button does not appear, but loading text is seen instead for green
        assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
		 // 3) check that button does not appear, but loading text is seen instead for green and blue
        assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
        //assertTrue(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
        //assertTrue(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
         // 4) check that button and loading green does not appear,
		 // 		but loading text is seen instead for blue and success for green is seen

         // 5) check that both button and loading text is not seen, success is seen instead
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish_green_and_blue")));
    }

}