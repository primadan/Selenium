package SampleCheck;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTestng {

    public WebElement element;
    public ChromeOptions options = new ChromeOptions();
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aulia_p502\\IdeaProjects\\Selenium-2\\resources\\windows\\chromedriver.exe");
    }
    public WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @Test (priority = 3)
    public void Test() throws InterruptedException {
        options.addArguments("--headless");
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void TestLogin() throws InterruptedException {
        options.addArguments("--headless");
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        WebElement resuts = driver.findElement(By.xpath("//*[text()='Products']"));
        driver.findElement(By.xpath("//*[text()='Products']"));
        Assert.assertEquals(((WebElement) resuts).getText(), "PRODUCTS");
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void TestScroll() throws InterruptedException {
        options.addArguments("--headless");
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        //js scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(5000);

        WebElement resuts = driver.findElement(By.xpath("//*[text()='7.99']"));
        driver.findElement(By.xpath("//*[text()='7.99']"));
        Assert.assertEquals(((WebElement) resuts).getText(), "$7.99");
        Thread.sleep(5000);
    }

    @Test (priority = 4)
    public void TestAlertOK() throws InterruptedException {
        options.addArguments("--headless");
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href = '#OKTab']")).click();
        driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(5000);
        WebElement resuts = driver.findElement(By.xpath("//*[text()='Automation Demo Site ']"));
        driver.findElement(By.xpath("//*[text()='Automation Demo Site ']"));
        Assert.assertEquals(((WebElement) resuts).getText(), "Automation Demo Site");
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
