package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import sun.security.krb5.internal.crypto.Des;
import utils.DriverManager;

import java.io.File;
import java.net.MalformedURLException;

public class Screenshot extends DriverManager {

    @Parameters("browser")
    @BeforeClass(groups = {"hook"})

    void beforeClass(@Optional("browser") String browser) throws MalformedURLException {
        setDriver(browser);
    }

    @AfterClass(groups = {"hook"})
    void teardown() { driver.quit(); }

    @Test(groups = {"version4"})

    public void screenshotV4FirefoxTest() throws Exception {
        driver.close();
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(baseUrl);
        Thread.sleep(2000);
        File SrcFile= ((ChromeDriver) chromeDriver).getScreenshotAs(OutputType.FILE);
        File DestFile = new File("src/test/resources/screenshots/testv4-chrome.png");
        FileUtils.copyFile(SrcFile, DestFile);
        chromeDriver.quit();
    }

    @Test(groups = {"version4"})
    public void screenshotV4ElemenTest() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(3000);
        driver.findElements(By.tagName("button")).get(0).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Menü")).click();
        Thread.sleep(2000);
        WebElement targetElement = driver.findElement(By.linkText("Soğuk İçeceklerimiz"));
        File SrcFile = targetElement.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("src/test/resources/screenshots/testv4-element.png");
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
