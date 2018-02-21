package selenium.sample;

import org.junit.After;
import org.junit.Assert;
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
    public void goToAlertedPageViaButton() throws Exception {
//        TODO
//        click on "To go to alerted page press Ok. Or stay here" button
        driver.findElement(By.className("w3-blue")).click();
//        switch to alert
        Alert alert1 = driver.switchTo().alert();
        Assert.assertEquals("Want to see an alerted page?!", alert1.getText());
//        click ok
        alert1.accept();
//        switch to second alert
        Alert alert2 = driver.switchTo().alert();
        Assert.assertEquals("Booooooooo!", alert2.getText());
        alert2.accept();
        Assert.assertTrue("https://kristinek.github.io/test-sample/examples/al_p".equals(driver.getCurrentUrl()));
//        verify alert text
//        click ok on second alert
//        verify that the correct page is opened
    }

    @Test
    public void doNotGoToAlertedPageViaButton() throws Exception {
//        TODO
//        click on "To go to alerted page press Ok. Or stay here" button
        driver.findElement(By.className("w3-blue")).click();
//        switch to alert
        Alert alert1 = driver.switchTo().alert();
//        click cancel
        alert1.dismiss();
//        verify the text on page
        Assert.assertEquals("So you desided to say? Good!", driver.findElement(By.id("textForAlerts")).getText());
    }
}
