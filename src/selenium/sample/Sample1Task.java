package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1Task {
    static String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // TODO
        // go to https://kristinek.github.io/test-sample/index2.html

        //get title of page
        driver.get("https://kristinek.github.io/test-sample/index2.html");

        //get title of page
        System.out.println(driver.getTitle());

        //get URL of current page
        System.out.println(driver.getCurrentUrl());

        //Sleep for 10 seconds
        Thread.sleep(50000);

        //Close browser
        driver.close();
    }
}
