/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com;

import java.util.List;
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
import org.openqa.selenium.support.ui.Select;
import static test.com.LoginTest.driver;

/**
 *
 * @author Sergii
 */
public class Search {
    
    public Search() {
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
    public void TestLogin() {
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
       
    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
    
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    
    WebElement element4=driver.findElement(By.name("searchText"));
    assertNotNull(element4);
    element4.sendKeys("form");
    
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//*[@id=\"widgetsColumn2\"]/app-document-search-panel/app-document-search-shared/div/div[2]/form/div/div/button")).click();
    
//    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//    driver.findElement(By.xpath("//*[@id=\"result-entry\"]/td[1]/a")).click();
    }
    
    
    //driver.findElement(By.xpath("")).click();
//    
//    driver.switchTo().activeElement();
//    
//    String text=driver.findElement(By.xpath("/html/body/app-root/ng-component/app-modal/div/app-document-search-result/div/div/div[1]/h2")).getText();
//    assertEquals(text, "Search Results");
//        
//        
//    
//    List<WebElement> elements=driver.findElements(By.className("btn-mbe btn-teal"));
//        WebElement element5 = elements.get(0);
//        element5.click();

//    WebElement element5=driver.findElement(By.partialLinkText("Add Emergency Contact"));
//    assertNotNull(element5);
//    element5.click();

//    
    
}