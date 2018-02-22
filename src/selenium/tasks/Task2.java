package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;


public class Task2 {
    WebDriver driver;

    @Before
    public void openPage(){
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task2");
    }

    @After
    public void closeBrowser(){
        driver.close();
    }

    @Test
    public void loadGreen() throws InterruptedException {
		/* TODO:
		 * 1) click on start loading green button
		 * 2) check that button does not appear, but loading text is seen instead
		 * 3) check that both button and loading text is not seen, success is seen instead
		 */
        assertEquals("https://kristinek.github.io/test-sample/tasks/task2", driver.getCurrentUrl());
        assertTrue(driver.findElement(By.id("start_green")).isDisplayed());
        driver.findElement(By.id("start_green")).click();
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());




    }

    @Test
    public void loadGreenAndBlueBonus() throws InterruptedException {
		/* TODO:
		 * 0) wait until button to load green and blue appears                                          +
		 * 1) click on start loading green and blue button                                              +
		 * 2) check that button does not appear, but loading text is seen instead for green             +
		 * 3) check that button does not appear, but loading text is seen instead for green and blue    +
		 * 4) check that button and loading green does not appear,                                      +
		 * 		but loading text is seen instead for blue and success for green is seen                 +
		 * 5) check that both button and loading text is not seen, success is seen instead              +
		 */
		Thread.sleep(3000);
        assertTrue(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
        driver.findElement(By.id("start_green_and_blue")).click();
        assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.id("loading_green_with_blue")).isDisplayed());
        assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
        Thread.sleep(2000);
        assertFalse(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_blue_without_green")).isDisplayed());
        Thread.sleep(3000);
        assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green_with_blue")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_blue_without_green")).isDisplayed());
        assertTrue(driver.findElement(By.id("finish_green_and_blue")).isDisplayed());





        //assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
        //assertTrue(driver.findElement(By.id("loading_blue_without_green")).isDisplayed());
        //Thread.sleep(2000);
        //assertTrue(driver.findElement(By.id("finish_green_and_blue")).isDisplayed());
    }

}