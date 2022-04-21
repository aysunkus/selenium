package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public String baseUrl;

    // public void setDriver() {
    //   WebDriverManager.chromedriver().setup();
    //   driver = new ChromeDriver();
    //  System.out.println("Chrome");
    //   baseUrl = "https://www.gloriajeans.com.tr/";
    //  driver.manage().window().maximize();
    //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

    public void setDriver(String testBrowser) throws MalformedURLException{

        switch (testBrowser){
            case "grid-firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                driver = new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOptions);
                System.out.println("----- Selenium Grid Chrome ------");
                break;
            }
            case "grid-chrome":{
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                System.out.println("------ Selenium Chrome -----");
                break;
            }
            case "firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println("-----Browser is firefox ------");
                break;
            }
            case "firefox-headless": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println("---- Browser is firefox-----");
                break;
            }
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                driver = new ChromeDriver(chromeOptions);
                System.out.println("--- Browser is chrome headles-----");
                break;
            }
            default:{
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("---- Browser is chrıome-bonigarcia-------");
                break;
            }
        }

        js = (JavascriptExecutor) driver;
        baseUrl = "https://www.gloriajeans.com.tr/";
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
    }

}
