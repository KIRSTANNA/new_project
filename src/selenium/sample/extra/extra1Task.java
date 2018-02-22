package selenium.sample.extra;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class extra1Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/test-sample/examples/po";
    String new_url = "https://kristinek.github.io/test-sample/examples/po1";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void navigateBack() throws Exception {
//        TODO
//        open page with url "https://kristinek.github.io/test-sample/examples/po"
//        click "More > " for the top left element a
//        check that the url now "https://kristinek.github.io/test-sample/examples/po1"
//        using driver navigation go back to "https://kristinek.github.io/test-sample/examples/po"
//        check that the page now is "https://kristinek.github.io/test-sample/examples/po"
        assertEquals(base_url, driver.getCurrentUrl());
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/p[2]/a")).click();
        assertEquals(new_url, driver.getCurrentUrl());
        driver.navigate().back();
        assertEquals(base_url, driver.getCurrentUrl());
    }

    @Test
    public void navigateForward() throws Exception {
//        TODO
//        open page with url "https://kristinek.github.io/test-sample/examples/po"
//        click "More > " for the top left element
//        using driver navigation go back to "https://kristinek.github.io/test-sample/examples/po"
//        using driver navigation go forward to "https://kristinek.github.io/test-sample/examples/po1"
//        check that the page now is "https://kristinek.github.io/test-sample/examples/po1"
        assertEquals(base_url, driver.getCurrentUrl());
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/p[2]/a")).click();
        assertEquals(new_url, driver.getCurrentUrl());
        driver.navigate().back();
        assertEquals(base_url, driver.getCurrentUrl());
        driver.navigate().forward();
        assertEquals(new_url, driver.getCurrentUrl());
    }

    @Test
    public void refresh() throws Exception {
//        TODO
//        open page "https://kristinek.github.io/test-sample/examples/act"
//        click on "Show" button in 'Button' section
//        check that text "I am here!" is seen
//        refresh page
//        check that text "I am here!" is not seen
        driver.get("https://kristinek.github.io/test-sample/examples/act");
        driver.findElement(By.id("show_text")).click();
        assertEquals("I am here!", driver.findElement(By.id("show_me")).getText());
        driver.navigate().refresh();
        assertFalse(driver.findElement(By.id("show_me")).isDisplayed());
    }
}
