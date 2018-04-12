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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void Enroll() {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //login
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
       
     //enroll   
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.partialLinkText("Enroll Now")).click();
    
    //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    
    //click Change button
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnEnroll\"]")));
    driver.findElement(By.id("btnEnroll")).click();
    
    
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    WebElement element5=driver.findElement(By.name("chkAcknowledgement"));
     assertNotNull(element5);
    element5.click();
    
    driver.findElement(By.partialLinkText("Save and Continue")).click();
      //add emergency contact
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
//    driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/div/div/div[2]/app-emergency-contacts-enrollment/div/app-emergency-contacts/div/a")).click();   
//    driver.findElement(By.name("lastName")).sendKeys("Jonson");
//    driver.findElement(By.name("firstName")).sendKeys("Mike");
//    driver.findElement(By.name("relation")).sendKeys("Supose");
//    driver.findElement(By.name("homePhone")).sendKeys("7774445566");
//    driver.findElement(By.name("homeIntCode")).sendKeys("777");
//    driver.findElement(By.name("homeComments")).sendKeys("Test Home Comment");
//    driver.findElement(By.name("workPhone")).sendKeys("7776667788");
//    driver.findElement(By.name("workIntCode")).sendKeys("777");
//    driver.findElement(By.name("workComments")).sendKeys("Test Work Comment");
//    driver.findElement(By.name("mobilePhone")).sendKeys("7770008899");
//    driver.findElement(By.name("mobileIntCode")).sendKeys("777");
//    driver.findElement(By.name("mobileComments")).sendKeys("Test Mobile Comment");
//    driver.findElement(By.xpath("/html/body/app-root/ng-component/app-modal/div/app-emergency-contacts-form-modal/form/div/div/div[3]/button[1]")).click();

    WebElement element6=driver.findElement(By.partialLinkText("Save and Continue"));
     assertNotNull(element6);
    element6.click();
    
      //add dependent
//    WebElement element7=driver.findElement(By.id("submitButton"));
//     assertNotNull(element7);
//    element7.click();
//    WebElement e8=driver.findElement(By.id("foreignNational"));
//        Select s1=new Select(e8);
//        s1.selectByVisibleText("Yes");
//    driver.findElement(By.id("ssn")).sendKeys("111444459");
//    driver.findElement(By.id("firstName")).sendKeys("Michel");
//    driver.findElement(By.id("lastName")).sendKeys("Thomson");
//    driver.findElement(By.id("birthDate")).sendKeys("07/03/1990");
//    WebElement e9=driver.findElement(By.id("gender"));
//        Select s2=new Select(e9);
//        s2.selectByVisibleText("Male");
//    WebElement e10=driver.findElement(By.id("relationship"));
//        Select s3=new Select(e10);
//        s3.selectByVisibleText("Son");
//    driver.findElement(By.xpath("/html/body/app-root/ng-component/app-modal/div/app-my-dependents-form/div/div/form/div[2]/button[1]")).click();   
//    
    //Continue   
    new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/app-navigation-bar/div/div/div/div/div/div[2]/a[2]")));
    WebElement element12=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/app-navigation-bar/div/div/div/div/div/div[2]/a[2]"));
    assertNotNull(element12);
    element12.click();
    element12.click();
    
     //Go to Confirmation
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/app-navigation-bar/div/div/div/div/div/div[2]/a")));
    WebElement element17=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/app-navigation-bar/div/div/div/div/div/div[2]/a"));
    assertNotNull(element17);
    element17.click();
    element17.click();
    
    //Close
    new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/ng-component/app-modal/div/app-more-enrollment-modal/div/div/div[3]/button[2]")));
    WebElement element18=driver.findElement(By.xpath("/html/body/app-root/ng-component/app-modal/div/app-more-enrollment-modal/div/div/div[3]/button[2]"));
    //assertNotNull(element18);
    element18.click();
    element18.click();
    
    
//    //let's do it
//    WebElement element13=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/div/div/div[2]/ng-component/div/div[2]/div/div/div/div/div/div/a"));
//    assertNotNull(element13);
//    element13.click();
//    driver.findElement(By.name("postalCode")).sendKeys("60008");
//    driver.findElement(By.name("salary")).sendKeys("95700");
//    driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/div/div/div[2]/ng-component/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div/div/button[1]")).click();
//    
//    //radiobuttons
//    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/div/div/div[2]/ng-component/div/div[2]/div[3]/div/div/table/tbody/tr[2]/td[6]/div[1]/label/input")));
//    WebElement element14=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/div/div/div[2]/ng-component/div/div[2]/div[3]/div/div/table/tbody/tr[2]/td[6]/div[1]/label/input"));
//    element14.click();
//    element14.click();
//    
//    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/div/div/div[2]/ng-component/div/div[2]/div[3]/div/div/table/tbody/tr[3]/td[6]/div[1]/label/input")));
//    WebElement element15=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/div/div/div[2]/ng-component/div/div[2]/div[3]/div/div/table/tbody/tr[3]/td[6]/div[1]/label/input"));
//    element15.click();
//    element15.click();
//    
//    //Continue
//    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/app-navigation-bar/div/div/div/div/div/div[2]/a[2]")));
//    WebElement element16=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/app-navigation-bar/div/div/div/div/div/div[2]/a[2]"));
//     assertNotNull(element14);
//    element16.click();
//    element16.click();
//   
//    //Go to Confirmation
//    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/app-navigation-bar/div/div/div/div/div/div[2]/a")));
//    WebElement element17=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/ng-component/app-navigation-bar/div/div/div/div/div/div[2]/a"));
//    assertNotNull(element17);
//    element17.click();
//    element17.click();
//    
//    
    
    
    
    }
}
