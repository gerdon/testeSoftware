

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle1 {
  
  private static WebDriver driver;
 
  private static String urlBase;
  
  //Apontar para o arquivo do ChromeDriver.exe que vc baixouq
  private static String driverPath = "D:/Dev/Dev_Java/chromedriver.exe";
  
  
    @BeforeClass 
	public static void setUp() {
		
    	System.setProperty("webdriver.chrome.driver", driverPath);
		
    	driver = new ChromeDriver();
		
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
    	urlBase = "https://www.google.com/";
    }
  
	@Test
	public void testEGoogle1() {
	    
		driver.get(urlBase);
	    
		driver.findElement(By.id("lst-ib")).clear();
	    
		driver.findElement(By.id("lst-ib")).sendKeys("TRT21");
	    
		driver.findElement(By.name("btnK")).click();
	    
		assertTrue(driver.getTitle().contains("TRT21"));
	    
	}
  
    @AfterClass 
	public static void tearDown() {
		driver.close(); 
	}

}
