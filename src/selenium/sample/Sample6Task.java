package selenium.sample;

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6Task {
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
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void findElementByXPath() throws Exception {
        System.out.println(driver.findElement(By.xpath("//*[@id=\'heading_2\']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[text()=\'Heading 2 text\']")).getAttribute("id"));

//        TODO
        //        "Test Text 1"
        System.out.println(driver.findElement(By.xpath("//*[@id='test1']/p[@class='test']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id='test1']/p[1]")).getText());
        System.out.println("--------------------");
//        "Test Text 2"
        System.out.println(driver.findElement(By.xpath("//*[@id='test1']/p[2]")).getText());
        System.out.println(driver.findElements(By.xpath("//*[@id='test1']/p")).get(1).getText());
        System.out.println("--------------------");
//        "Test Text 3"
        System.out.println(driver.findElement(By.xpath("//*[@id='test3']/*[@class='test']")).getText());
        System.out.println(driver.findElement(By.xpath("")).getText());
        System.out.println("--------------------");
//         2-3 ways to write xpath to
//              * "Hading 2 text"
//              * "Test Text 1"
//              * "Test Text 2"
//              * "Test Text 3"
//              * "Test Text 4"
//              * "Test Text 5"
//              * "Test Text 6"
//              * "This is also a button"
        System.out.println(driver.findElement(By.xpath("//*[@id=buttonid']/*[@class='test']")).getText());
        System.out.println(driver.findElement(By.xpath("")).getText());
        System.out.println("--------------------");
    }

    @Test
    public void findElementByCssName() throws Exception {
//        TODO
        System.out.println(driver.findElement(By.cssSelector("#heading_2")).getText());
        System.out.println(driver.findElement(By.cssSelector("h2#heading_2")).getAttribute("id"));
        System.out.println(driver.findElement(By.cssSelector("h2:nth-of-type(2)")).getText());
        //         1-2 ways to write css to
//              * "Hading 2 text"
/       System.out.println(driver.findElement(By.cssSelector("#heading_2")).getText());
        System.out.println(driver.findElement(By.cssSelector("h2#heading_2")).getAttribute("id"));
        System.out.println(driver.findElement(By.cssSelector("h2:nth-of-type(2)")).getText());

//              * "Test Text 2"
//              * "Test Text 3"
        System.out.println(driver.findElement(By.cssSelector( "#test1 > p.test")).getText());
        System.out.println(driver.findElement(By.cssSelector( "#test1 > p:nth-of-type(2)")).getText());
        System.out.println(driver.findElement(By.cssSelector("h2:nth-of-type(2)")).getText());

        System.out.println(driver.findElement(By.cssSelector( "#test3 > .test")).getText());
        System.out.println(driver.findElement(By.cssSelector( "#test1 > p:nth-of-type(2)")).getText());
        System.out.println(driver.findElement(By.cssSelector("h2:nth-of-type(2)")).getText());


    }