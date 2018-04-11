
package test.com;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.awt.SystemColor.text;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Roma
 */
public class SwitchLang {
   static WebDriver driver;
    public SwitchLang() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
         System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-mbe50.mybenefitexpress.com/home");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void switchLanguage() {
         
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    assertNotNull(driver);  
    
      System.out.println("Starting test");
    //driver.get("https://qa-mbe50.mybenefitexpress.com/home");
    //driver.findElement(By.id("ddlCulture"));
    Select selectSpanish = new Select(driver.findElement(By.name("Culture")));
    selectSpanish.selectByVisibleText("Español");
    
    
     WebElement elem = driver.findElement(By.id("Username"));
if (elem.getText().contains("Username")) {
    System.out.println("It's English!");
} else if (elem.getText().contains("Nombre de usuario")) {
    System.out.println("It's Spanish!");
}
//Assert Spanish
String bodyText = driver.findElement(By.tagName("body")).getText();
Assert.assertTrue("Text not found!", bodyText.contains("Olvidó su Contraseña?"));

Select selectFrench = new Select(driver.findElement(By.name("Culture")));
  selectFrench.selectByVisibleText("Français");
  
  //Assert French
//  String bodyText1 = driver.findElement(By.tagName("body")).getText();
//Assert.assertTrue("Text not found!", bodyText1.contains("Olvidó su Contraseña?"));
     }
}