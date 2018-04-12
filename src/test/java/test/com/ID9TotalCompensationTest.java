/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Ekaterina
 */
public class ID9TotalCompensationTest {
    static WebDriver driver;
    String title;
    
    public ID9TotalCompensationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        

        //executes only once before all testes
        //System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver.exe");
        //driver = new ChromeDriver();
        
        System.setProperty("webdriver.gecko.driver", "C:\\Data\\geckodriver.exe");
        driver = new FirefoxDriver();
        
        driver.get("https://qa-mbe50.mybenefitexpress.com/home");
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
    
    @Test
    public void TestOpenPage() {
    
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    assertNotNull(driver);
    }
    
    @Test
    public void TestLoginPassword() {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    WebElement element1=driver.findElement(By.id("Username"));
    assertNotNull(element1);
    element1.sendKeys("sandra123");
        
    WebElement element2=driver.findElement(By.id("Password"));
    assertNotNull(element2);
    element2.sendKeys("test");
    
    WebElement element3=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[1]/div/form/div[4]/button"));  
    assertNotNull(element3);
    element3.click();


     // click on enrollment tools 2
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headingOne\"]/h4/a")));
    WebElement element4=driver.findElement(By.xpath("//*[@id=\"headingOne\"]/h4/a"));
    element4.click();
    
    // click on TCS
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hl_0\"]/div/app-client-content/app-view-more-content/div/div/ul/li[6]/a")));
    WebElement element5=driver.findElement(By.xpath("//*[@id=\"hl_0\"]/div/app-client-content/app-view-more-content/div/div/ul/li[6]/a"));
    element5.click();      

    // verification
    String actualString = driver.findElement(By.xpath("//*[@id=\"dvTcsBody\"]/div/div[2]/div/p[3]")).getText();
    assertTrue(actualString.contains("Your Total Compensation program is made up"));

    }
}