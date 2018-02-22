package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

//import pages.FormPage;
//import pages.ListPage;

public class Task3 {
    static WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task4");
    }

    @After
    public  void closeBrowser(){
        driver.quit();
    }

    @Test
    public void feedback() throws Exception {
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
        driver.findElement(By.id("fb_name")).sendKeys("ILDAR");
        driver.findElement(By.id("fb_age")).sendKeys("222");
        List <WebElement> checkbox = driver.findElements(By.cssSelector("[type='checkbox']"));//loop checks empty checkboxes or not
        for (WebElement checkbox1 : checkbox){
            assertFalse(checkbox1.isSelected());
        }
        //clicking on checkboxes
        driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[2]")).click();
        driver.findElement(By.cssSelector(".w3-radio:nth-of-type(1)")).click();
        //Select Option
        Select dropdown = new Select(driver.findElement(By.id("like_us")));
        dropdown.selectByVisibleText("Bad");
        driver.findElement(By.xpath("//textarea")).sendKeys("it 's 123123123");
        driver.findElement(By.className("w3-btn-block")).click();//        click "send"
        //Verifying
        //assertEquals(driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[1]/p[1]")),);
        assertEquals("Your name: ILDAR", driver.findElement(By.xpath("//p[1]")).getText());
        assertEquals("Your age: 222", driver.findElement(By.xpath("//p[2]")).getText());
        assertEquals("Your language: English, French", driver.findElement(By.xpath("//p[3]")).getText());
        assertEquals("Your genre: Male", driver.findElement(By.xpath("//p[4]")).getText());
        assertEquals("Your option of us: Bad", driver.findElement(By.xpath("//p[5]")).getText());
        assertEquals("Your comment: it 's 123123123", driver.findElement(By.xpath("//p[6]")).getText());
        driver.findElement(By.className("w3-green")).click();
//        check that the feedback was filled correctly
    }
}
