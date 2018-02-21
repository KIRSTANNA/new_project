package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/test-sample/examples/act";

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
    public void enterNumber() throws Exception {
//        TODO
//        enter a number under "Number"
//        click on "Result" button
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
//        check that the button "Clear Result" is active now
//        click on "Clear Result"
//        check that the text is still ("You entered number: "NUMBER YOU ENTERED""), but it is not displayed
        WebElement number = driver.findElement(By.id("number"));
        String originalNumber = "5";
        String newNumber = "42";
        assertFalse(driver.findElement(By.id("clear_result_button_number")).isEnabled());

        WebElement button = driver.findElement(By.id("result_button_number"));
        button.click();
        assertTrue(driver.findElement(By.id("clear_result_button_number")).isEnabled());
        assertTrue(driver.findElement(By.id("result_number")).isDisplayed());
        System.out.println(driver.findElement(By.id("result_number")).getText());

        assertEquals("You entered number: \"5\"",driver.findElement(By.id("result_number")).getText() );

        assertEquals(originalNumber, number.getAttribute("value"));



        number.sendKeys(newNumber);


        assertEquals("42", number.getAttribute("value"));
        button.click();
        System.out.println(driver.findElement(By.id("result_number")).getText());
        assertEquals("You entered number: \"42\"",driver.findElement(By.id("result_number")).getText());
    }

    @Test
    public void clickOnLink() throws Exception {
//        TODO
//        click on "This is a link to Homepage"
//        verify that homepage is opened
        String homePage = "https://kristinek.github.io/test-sample/";
        assertEquals(base_url, driver.getCurrentUrl());
        WebElement link = driver.findElement(By.id("homepage_link"));
        link.click();
        assertFalse(driver.getCurrentUrl().equals(base_url));
        assertEquals(driver.getCurrentUrl(), homePage);

    }
}
