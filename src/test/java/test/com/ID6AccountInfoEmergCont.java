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


/**
 *
 * @author Sergii
 */
public class ID6AccountInfoEmergCont {
    static WebDriver driver;
    public ID6AccountInfoEmergCont() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
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

    @Test
    public void TestAccInfo() {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    WebElement element1=driver.findElement(By.id("Username"));
    assertNotNull(element1);
    element1.sendKeys("sandra123");
        
    WebElement element2=driver.findElement(By.id("Password"));
    assertNotNull(element2);
    element2.sendKeys("test");
    
    WebElement element3=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[1]/div/form/div[4]/button"));
    //System.out.println("the element name "+element3.getText());
    assertNotNull(element3);
    element3.click();
        
    //driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
    
    WebElement element4=driver.findElement(By.partialLinkText("Account Information"));
    assertNotNull(element4);
    element4.click();
    
    driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/app-account-information/div/div/div/div/div[2]/div/div[2]/a/span")).click();

    WebElement element5=driver.findElement(By.partialLinkText("Add Emergency Contact"));
    assertNotNull(element5);
    element5.click();
    
    driver.findElement(By.name("lastName")).sendKeys("Smith");
    driver.findElement(By.name("firstName")).sendKeys("Tom");
    driver.findElement(By.name("relation")).sendKeys("Parent");
    driver.findElement(By.name("homePhone")).sendKeys("7734445566");
    driver.findElement(By.name("homeIntCode")).sendKeys("733");
    driver.findElement(By.name("homeComments")).sendKeys("Test Home Comment");
    driver.findElement(By.name("workPhone")).sendKeys("7736667788");
    driver.findElement(By.name("workIntCode")).sendKeys("773");
    driver.findElement(By.name("workComments")).sendKeys("Test Work Comment");
    driver.findElement(By.name("mobilePhone")).sendKeys("7730008899");
    driver.findElement(By.name("mobileIntCode")).sendKeys("773");
    driver.findElement(By.name("mobileComments")).sendKeys("Test Mobile Comment");
    driver.findElement(By.xpath("/html/body/app-root/ng-component/app-modal/div/app-emergency-contacts-form-modal/form/div/div/div[3]/button[1]")).click();
    }
}
