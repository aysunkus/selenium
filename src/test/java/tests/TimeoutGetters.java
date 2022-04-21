package tests;

import org.testng.annotations.*;
import utils.DriverManager;

import java.net.MalformedURLException;
import java.time.Duration;

public class TimeoutGetters extends DriverManager {

    @Parameters("browser")
    @BeforeClass(groups = {"hook"})

    void beforeClass(@Optional("browser") String browser) throws MalformedURLException {
        setDriver(browser);
    }

    @AfterClass(groups = {"hook"})
    void teardown() { driver.quit(); }

    @Test(groups = {"version4"})

    public void timeoutGetters() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        System.out.println("ImplicitWaitTimeOut" + driver.manage().timeouts().getImplicitWaitTimeout().getSeconds());
        System.out.println("ScriptTimeout" + driver.manage().timeouts().getScriptTimeout().getSeconds());
        System.out.println("PageloadTimeout" + driver.manage().timeouts().getPageLoadTimeout().getSeconds());
    }
}
