package tests;

import org.openqa.selenium.WindowType;
import org.testng.annotations.*;
import utils.DriverManager;

import java.net.MalformedURLException;

public class WindowHandling extends DriverManager {

    @Parameters("browser")
    @BeforeClass(groups = {"hook"})
    void beforeClass(@Optional("browser") String browser) throws MalformedURLException {
        setDriver(browser);
    }

    @AfterClass(groups = {"hook"})
    void teardown() {driver.quit();}

    @Test(groups = {"version4"})
    public void windowHandlingV4Test() throws  InterruptedException {
        String openingUrl = "https://www.google.com.tr/";
        driver.get(openingUrl);
        String firstWindow = driver.getWindowHandle();
        Thread.sleep(2);

        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2);
        driver.get(baseUrl);
        Thread.sleep(2);

        driver.switchTo().window(firstWindow);
        driver.get("https://testingbootcamp.com/");
        Thread.sleep(2);
    }
}
