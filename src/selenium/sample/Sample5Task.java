package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Sample5Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/test-sample/examples/al_and_pu");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test

//

        public void alertOnOpeningPage() throws Exception {
            driver.get("https://kristinek.github.io/test-sample/examples/al_p");
//        org.openqa.selenium.UnhandledAlertException: unexpected alert open:
//        driver.findElement(By.id("heading")).getText();
            Alert alert = driver.switchTo().alert();
            assertEquals("Booooooooo!", alert.getText());

            alert.accept();
            assertEquals("This page is alerted", driver.findElement(By.id("heading")).getText());
        }

        @Test
        public void alertOnclickingButton() throws Exception {
            driver.findElement(By.className("w3-blue")).click();
            Alert alert = driver.switchTo().alert();
            assertEquals("Want to see an alerted page?!", alert.getText());
            alert.dismiss();
            assertEquals("So you desided to say? Good!",
                    driver.findElement(By.id("textForAlerts\")).getText());


        }
    public void alertOnclickingButton() throws Exception {
        driver.findElement(By.className("w3-blue")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Alert alert2 = driver.switchTo().alert();
        assertEquals("Booooooooo!", alert2.getText());

        alert2.accept();
        assertTrue()
        assertEquals("https://kristinek.github.io/test-sample/examples/al_p".equals(driver.getCurrentUrl()));
        System.out.println(); }


    }






