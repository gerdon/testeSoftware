package selenium;

import static org.junit.Assert.fail;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSiteGoogle {
	private WebDriver driver;
	private String driverPath = "D:/Dev/Dev_Java/chromedriver.exe";
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando o browser Chrome");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		baseUrl = "https://www.google.com.br/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testSiteGoogle() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.ByName.name("q")).clear();
		driver.findElement(By.ByName.name("q")).sendKeys("portal inova");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}


}
