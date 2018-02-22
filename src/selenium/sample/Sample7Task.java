package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
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
    public void selectCheckBox() throws Exception {
//        check that none of the checkboxes are ticked
//        tick  "Option 2"
//        check that "Option 1" and "Option 3' are not ticked, but "Option 2" is ticked
//        tick  "Option 3"
//        click result
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for (WebElement checkBox : checkBoxes){
            assertFalse(checkBox.isSelected());
            checkBox.click();
            assertTrue(checkBox.isSelected());
            checkBox.click();
            assertFalse(checkBox.isSelected());
        }
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox'"));
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox'"));
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='checkbox'"));
        option2.click();
        assertFalse(option1.isSelected());
        assertFalse(option3.isSelected());
        assertTrue(option2.isSelected());
        option3.click();
        driver.findElement(By.id("result_button_checkbox")).click();
        assertEquals("You selected value(s): Option 2, Option 3", driver.findElement(By.id("result_checkbox")).getText());
    }


    @Test
    public void selectRadioButton() throws Exception {
//        check that none of the radio are selected
//        select  "Option 3"
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
//        select  "Option 1"
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
//        click result
//        check that 'You selected option: Option 1' text is being displayed
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio'"));
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio'"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio'"));

        for (WebElement radioButton : radioButtons){
            assertFalse(radioButton.isSelected());
        }
        option3.click();
        assertFalse(option1.isSelected());
        assertFalse(option2.isSelected());
        option1.click();
        assertFalse(option3.isSelected());
        assertFalse(option2.isSelected());
        driver.findElement(By.id("result_button_ratio")).click();
        assertEquals("You selected option: Option 1",driver.findElement(By.id("result_radio")).getText());

    }

    @Test
    public void selectOption() throws Exception {
//        select "Option 3" in Select
//        check that selected option is "Option 3"
//        select "Option 2" in Select
//        check that selected option is "Option 2"
//        click result
//        check that 'You selected option: Option 2' text is being displayed
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        dropdown.selectByIndex(2);
        assertTrue(dropdown.getFirstSelectedOption().isSelected());
        dropdown.selectByIndex(3);
        assertTrue(dropdown.getFirstSelectedOption().isSelected());

        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added

        Calendar cal = Calendar.getInstance();
        String result = "07/04/2007";


        WebElement dateBox = driver.findElement(By.id("vfb-8"));

        dateBox.click();
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        for (int i = 0; i < (12*11); i++) {
            dateWidget.findElement(By.className("ui-datepicker-prev")).click();
        }
        for (int i = 0; i < 5; i++) {
            dateWidget.findElement(By.className("ui-datepicker-next")).click();
        }
        dateWidget.findElement(By.xpath("//a[text()='4']")).click();



        assertEquals(result, dateBox.getAttribute("value"));
        dateBox.clear();
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//        enter date '2 of May 1959' using text
//        check that correct date is added
        String dateToEnter = "04/02/1959";

        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.clear();
        dateBox.sendKeys(dateToEnter);
        assertEquals(dateToEnter, dateBox.getAttribute("value"));
    }

}
