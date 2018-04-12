/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com;
import java.util.List;
//import java.awt.List;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Roma
 */
public class ID4QuickSearchTest {
    static WebDriver driver;
    public ID4QuickSearchTest() {
    }
    
     @BeforeClass
    public static void setUpClass() {
        //executes only once before all testes
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
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
    //
   
     @Test
     //Start Search test
    public void TestSearch() {
       //Open page
      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    assertNotNull(driver); 
      
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //Username and Password
    WebElement element1=driver.findElement(By.id("Username"));
    assertNotNull(element1);
    element1.sendKeys("sandra123");
        
    WebElement element2=driver.findElement(By.id("Password"));
    assertNotNull(element2);
    element2.sendKeys("test");
    //Click
    WebElement element3=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[1]/div/form/div[4]/button"));
    System.out.println("the element name "+element3.getText());
    assertNotNull(element3);
    element3.click();
    
    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    
//    WebDriverWait wait = new WebDriverWait(driver, 10);
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"widgetsColumn2\"]/app-document-search-panel/app-document-search-shared/div/div[2]/form/div/div/div[1]/input")));

 
   
   WebElement element4=driver.findElement(By.xpath("//input[@name='searchText']"));
   List <WebElement> list=driver.findElements(By.xpath("//*[@id=\"widgetsColumn2\"]/app-document-search-panel/app-document-search-shared/div/div[2]/form/div/div/div[1]/input"));
   for(WebElement w:list)
             System.out.println("the result:"+ w.getText());
 assertNotNull(element4);
 element4.sendKeys("doc");
 
  WebElement element5=driver.findElement(By.xpath("//*[@id=\"widgetsColumn2\"]/app-document-search-panel/app-document-search-shared/div/div[2]/form/div/div/button"));
    element5.click();
    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"result-entry\"]/td[1]/a")));
    WebElement element6=driver.findElement(By.xpath("//*[@id=\"result-entry\"]/td[1]/a"));
    element6.click();
    

//String bodyText = driver.findElement(By.tagName("body")).getText();
//Assert.assertTrue("Text not found!", bodyText.contains("Quick Document Search"));

List<WebElement> elementsList = driver.findElements(By.tagName("input"));
System.out.println("Links count is: "+elementsList.size());

System.out.println("Test Done");

    }
}