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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static test.com.LoginTest.driver;

/**
 *
 * @author Sergii
 */
public class EnrollTest {
    
    public EnrollTest() {
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
    public void testopenpage() {
    
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    assertNotNull(driver);
    }
    
    @Test
    public void TestLoginPassword() {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    WebElement element1=driver.findElement(By.id("Username"));
    //assertNotNull(element1);
    element1.sendKeys("sandra123");
    }
}
