package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import pages.FormPage;
//import pages.ListPage;

public class Task3 {
    static WebDriver driver;

    @Before
    public static void openPage() {
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task4");
    }

    @After
    public static void closeBrowser(){
        driver.quit();
    }

    @Test
    public void feedback() {
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
//        click "send"
//        check that the feedback was filled correctly
    }
}
