/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com;




import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Roma
 */
public class EmergencyContactTest {
    static WebDriver driver;
    String CSV_PATH="C:\\data\\Detail.csv"; 
    public EmergencyContactTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     //Start Search test
    public void TestEmergencyContact()throws IOException{
       //Open page
      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    //assertNotNull(driver); 
      
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

 
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"12\"]/a/span[2]")));
    WebElement element4=driver.findElement(By.xpath("//*[@id=\"12\"]/a/span[2]"));
    element4.click();
    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/section/div/app-account-information/div/div/div/div/div[2]/div/div[2]/a/span")));
    WebElement element5=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/app-account-information/div/div/div/div/div[2]/div/div[2]/a/span"));
    element5.click();
    
    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/section/div/app-account-information/div/div/div/div/div[2]/div/div[2]/a/span")));
    WebElement element6=driver.findElement(By.xpath("//*[text()='Add Emergency Contact']"));
    element6.click();
    
    //Use Test data form CSV
    CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
  String [] csvCell;
  //while loop will be executed till the last line In CSV.
  while ((csvCell = reader.readNext()) != null) {   
   String LName = csvCell[0];
   String FName = csvCell[1];
   String Relat = csvCell[2];
   String HPhone = csvCell[3];
   String WPhone = csvCell[4];
   String Mobile = csvCell[5];
   
   System.out.println(LName);
   System.out.println(FName);
   System.out.println(Relat);
   System.out.println(HPhone);
   System.out.println(WPhone);
   System.out.println(Mobile);
   

  // WebDriver driver = new ChromeDriver();
    //driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
   driver.findElement(By.name("lastName")).sendKeys(LName);
   driver.findElement(By.name("firstName")).sendKeys(FName);
   driver.findElement(By.name("relation")).sendKeys(Relat);
   driver.findElement(By.name("homePhone")).sendKeys(HPhone);
   driver.findElement(By.name("workPhone")).sendKeys(WPhone);
   driver.findElement(By.xpath("//*[@name='mobilePhone']")).sendKeys(Mobile);
   driver.findElement(By.xpath("//*[text()='Save and Close']")).click();
   
  }
    
    
    
    
    
//String bodyText = driver.findElement(By.tagName("body")).getText();
//Assert.assertTrue("Text not found!", bodyText.contains("Quick Document Search"));

//List<WebElement> elementsList = driver.findElements(By.tagName("input"));
//System.out.println("Links count is: "+elementsList.size());

System.out.println("Test Done");
    }
    }
