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
public class EmailUsTest {
    static WebDriver driver;
    String title;
    
    public EmailUsTest() {
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
        //driver.quit();
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

    
    // click on contact us
    WebElement element4=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/nav/div/div[2]/app-top-menu/div/app-contact-us/div/a"));  
    assertNotNull(element4);
    element4.click();
    
        // click on Email Us
    WebElement element5=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/nav/div/div[2]/app-top-menu/div/app-contact-us/div/ul/li[2]/a"));  
    assertNotNull(element5);
    element5.click();
    

    }
}