
package test.com;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Elena
 */
    public class ID3ContactUs {
    static WebDriver driver;
    
    public ID3ContactUs() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
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
    ////public void ContactUS()
  // @org.junit.Test 
    @Test
    public void testSomething(){     
     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     WebElement element=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[1]/div/form/div[1]/input"));
     //WebElement element=driver.findElement(By.id("Username")); /html/body/div[2]/div/div/div/div[1]/div[1]/div[1]/div/form/div[1]/input
     assertNotNull(element);
     element.sendKeys("sandra123");
     
     
     //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     WebElement element1=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[1]/div/form/div[2]/input"));
     assertNotNull(element1);
     element1.sendKeys("test");
     
     WebElement element2=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[1]/div/form/div[4]/button"));
     assertNotNull(element2);
     element2.click();
     
     //WelcomePage //Clicking on Contact Us Top menu bar
     
    // driver.waitForPageToLoads("5000");
     
//    WebElement element3=driver.findElement(By.className("mbe-header-icon-text hidden-xs"));
//                                                     
//     assertNotNull(element3);
//     element3.click();

     
     WebElement element4=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/nav/div/div[2]/app-top-menu/div/app-contact-us/div/a/i[1]"));
     assertNotNull(element4);
     element4.click();
     
     
     WebElement element5 = (new WebDriverWait(driver, 90)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/ng-component/div/nav/div/div[2]/app-top-menu/div/app-contact-us/div/ul/li[2]/a")));
     element5.click();
     element5.click();
//    WebElement element5=driver.findElement(By.xpath("/html/body/app-root/ng-component/div/nav/div/div[2]/app-top-menu/div/app-contact-us/div/ul/li[2]/a"));
//    assertNotNull(element5);
//    element5.click();
   
    //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    
    WebElement element6=driver.findElement(By.xpath("/html/body/app-root/ng-component/div/section/div/app-user-request/div/div/div/div/div[2]/a"));
    assertNotNull(element6);
    element6.click();
    
    
    
  
    WebElement element7=driver.findElement(By.xpath("/html/body/app-root/ng-component/app-modal/div/app-user-request-form-modal/div/div/form/div[1]/form/div/div/table/tbody/tr[9]/td[2]/div/input"));
    assertNotNull(element7);
    element7.sendKeys("7473261213");

   WebElement element8=driver.findElement(By.xpath("/html/body/app-root/ng-component/app-modal/div/app-user-request-form-modal/div/div/form/div[1]/form/div/div/table/tbody/tr[13]/td[2]/select"));
     assertNotNull(element8);
     element8.click();
     
     
     Select drpReason = new Select(driver.findElement(By.xpath("/html/body/app-root/ng-component/app-modal/div/app-user-request-form-modal/div/div/form/div[1]/form/div/div/table/tbody/tr[13]/td[2]/select")));
     drpReason.selectByValue("84");
     
     WebElement element9=driver.findElement(By.xpath("/html/body/app-root/ng-component/app-modal/div/app-user-request-form-modal/div/div/form/div[1]/form/div/div/table/tbody/tr[16]/td[2]/textarea"));
     assertNotNull(element9);
     element9.sendKeys("tes");
     
     WebElement element12=driver.findElement(By.xpath("/html/body/app-root/ng-component/app-modal/div/app-user-request-form-modal/div/div/form/div[2]/button[1]"));
     assertNotNull(element12);
     element12.click();
     
     System.out.println("test Done");
}
}