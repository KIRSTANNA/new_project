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
        WebDriver driver1 = new ChromeDriver();

        driver1.get("https://kristinek.github.io/test-sample/");
        System.out.println(driver1.getTitle());
        System.out.println(driver1.getCurrentUrl());

        // TODO
        // go to https://kristinek.github.io/test-sample/index2.html
        // get title of page
        // get URL of current page

        //Close browser
        driver1.close();
    }
}
