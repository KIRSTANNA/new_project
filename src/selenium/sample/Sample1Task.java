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
        driver.get("https://kristinek.github.io/test-sample/index2.html");
        // go to
        // get title of page
        System.out.println(driver.getTitle());
        // get URL of current page
        System.out.println(driver.getCurrentUrl());


        //Close browser

        Thread.sleep(10000);


        driver.close();
    }
}
