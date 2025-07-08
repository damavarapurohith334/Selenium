package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utils.ExtentReportManager;

public class BaseTest {
	
	public static WebDriver driver;
	
	public ExtentReports extent;
	public ExtentTest test;
	

	@BeforeMethod
	public void browserSetup() {
		driver= new ChromeDriver();
			driver.get("https://demoqa.com/text-box");
			driver.manage().window().maximize();
			extent=ExtentReportManager.getReportInstance();

		
	}
	// Method is used written to eliminate the extra lines of code
		public void fillTextBoxs(By locaters, String value) {
			driver.findElement(locaters).sendKeys(value);
		}
		
		@AfterMethod
		public void closing() {
			driver.quit();
			extent.flush();
		}
}
