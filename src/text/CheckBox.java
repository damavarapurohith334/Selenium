package text;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;

public class CheckBox {
	
	ExtentReports extent;
	ExtentTest test;

	WebDriver driver = new ChromeDriver();


	@BeforeTest
	public void setup() {
		driver.get("https://demoqa.com/checkbox");
		driver.manage().window().maximize();
		extent=ExtentReportManager.getReportInstance();

	}

	@Test
	public void checkBox() {
		test = extent.createTest("Check Box");
		driver.findElement(By.xpath("//button[@type='button' and @class='rct-option rct-option-expand-all']")).click();
		WebElement element = driver.findElement(By.xpath("//span[text()='Desktop']/preceding-sibling::span[@class='rct-checkbox']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		String result = driver.findElement(By.id("result")).getText();
		System.out.println(result);
		assertTrue(result.toLowerCase().contains("desktop"),"Desktop not selected!");
		test.pass("submitted succesfully");
	}

	@AfterTest
	public void closing() {
		driver.quit();
		extent.flush();
	}

}
