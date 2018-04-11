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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static test.com.LoginTest.driver;

/**
 *
 * @author Elham
 */
public class TestTransitPanel {
    static WebDriver driver;
    String title;
    public TestTransitPanel() {
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
    public void testopenpage() {
    
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    assertNotNull(driver);
    }
    
   @Test
    public void testTransitPanel() {
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.get("https://qa-mbe50.mybenefitexpress.com/home");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //username
        WebElement element1 = driver.findElement(By.id("Username"));
        //assertNotNull(element1);
        element1.sendKeys("sandra123");

        //password
        WebElement element2 = driver.findElement(By.id("Password"));
        // assertNotNull(element2);
        element2.sendKeys("test");

        //login
        WebElement element3 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[1]/div/form/div[4]/button"));
        element3.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        //change button
        WebElement element = driver.findElement(By.xpath("//*[@id=\"widgetsColumn2\"]/app-reimbursement-widget[1]/div/div[2]/div/div[2]/p[2]/a"));
        assertNotNull(element);
        element.click();

        //cancel election button
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/section/div/app-transit-initial-election/div/div/div/div[1]/div/div[2]/div[2]/form/app-transit-choice/div[1]/div/table/tbody/tr[2]/td[2]/div/input")));
        element = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/app-transit-initial-election/div/div/div/div[1]/div/div[2]/div[2]/form/app-transit-choice/div[1]/div/table/tbody/tr[2]/td[2]/div/input"));

        assertNotNull(element);
        element.sendKeys("10");

        element = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/app-transit-initial-election/div/div/div/div[1]/div/div[2]/div[2]/form/app-transit-choice/div[2]/div/table/tbody/tr[2]/td[2]/div/input"));
        assertNotNull(element);
        element.sendKeys("20");

        element = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/app-transit-initial-election/div/div/div/div[2]/div/div/a"));
        assertNotNull(element);
        element.click();

        //cancel elections button
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        element = driver.findElement(By.xpath("//*[@title='Cancel Elections']"));
        assertNotNull(element);
        element.click();

        //confirm button
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.switchTo().activeElement();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println("active popup title: " + driver.findElement(By.xpath("/html/body/app-root/ng-component/app-modal/div/app-transit-cancel-election-modal/div/div/div[1]/h2")).getText());

        element = driver.findElement(By.xpath("/html/body/app-root/ng-component/app-modal/div/app-transit-cancel-election-modal/div/div/div[3]/button[1]"));
        System.out.println("element name: " + element.getText());
        if (element.isDisplayed()) {
            System.out.println("the element name " + element.getText());
            assertNotNull(element);
            element.click();
        }

    }
}
