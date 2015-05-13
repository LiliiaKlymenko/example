import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Liliia_Klymenko on 13-May-15.
 */

@RunWith(value = Parameterized.class)
public class WebDriverBaseClass {


    protected static WebDriver driver;
    private String url;

    public WebDriverBaseClass(String url) {
        this.url = url;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{"EPAM"}, {"SELENIUM"}});
    }

    @BeforeClass
    public static void startBrowser() {
        driver = new FirefoxDriver();
    }

    @Ignore
    @Test
    public void testweb() throws InterruptedException {

        driver.get("http://www.google.com");
        driver.findElement(By.id("lst-ib")).sendKeys("epam");
        Thread.sleep(2000);
        driver.findElement(By.id("lst-ib")).clear();
    }

    @Test
    public void testwebParametr() throws InterruptedException {

        driver.get("http://www.google.com");
        driver.findElement(By.id("lst-ib")).sendKeys(url);
        Thread.sleep(2000);
        driver.findElement(By.id("lst-ib")).clear();
    }
}







