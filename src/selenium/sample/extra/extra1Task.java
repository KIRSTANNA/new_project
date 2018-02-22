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
    String base_url = "https://kristinek.github.io/test-sample/examples/act";
    String new_url = "https://kristinek.github.io/test-sample/examples/link1";
    String po1_url = "https://kristinek.github.io/test-sample/examples/po1";
    String po_url = "https://kristinek.github.io/test-sample/examples/po";

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
        driver.get("https://kristinek.github.io/test-sample/examples/po");
//        open page with url "https://kristinek.github.io/test-sample/examples/po"
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/p/a")).click();
        //        click "More > " for the top right element
        assertEquals(driver.getCurrentUrl(),po1_url);
//        check that the url now "https://kristinek.github.io/test-sample/examples/po1"
        driver.navigate().back();
//        using driver navigation go back to "https://kristinek.github.io/test-sample/examples/po"
        assertEquals(driver.getCurrentUrl(), po_url);
//        check that the page now is "https://kristinek.github.io/test-sample/examples/po"
    }
////*[@id="buttonId"]
    @Test
    public void navigateForward() throws Exception {
//        TODO
        driver.get(po_url);
//        open page with url "https://kristinek.github.io/test-sample/examples/po"
//        click "More > " for the top left element
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/p[2]/a")).click();
        assertEquals(driver.getCurrentUrl(),po1_url);
        driver.navigate().back();//        using driver navigation go back to "https://kristinek.github.io/test-sample/examples/po"
        assertEquals(driver.getCurrentUrl(),po_url);
        driver.navigate().forward();//        using driver navigation go forward to "https://kristinek.github.io/test-sample/examples/po1"
        assertEquals(driver.getCurrentUrl(),po1_url);//        check that the page now is "https://kristinek.github.io/test-sample/examples/po1"

    }

    @Test
    public void refresh() throws Exception {
//        TODO
//        open page "https://kristinek.github.io/test-sample/examples/act"
        driver.get(base_url);
//        click on "Show" button in 'Button' section
        driver.findElement(By.id("show_text")).click();
//        check that text "I am here!" is seen
        assertTrue(driver.findElement(By.id("show_me")) .isDisplayed());
//        refresh page
        driver.navigate().refresh();
//        check that text "I am here!" is not seen
        assertFalse(driver.findElement(By.id("show_me")).isDisplayed());
    }
}
