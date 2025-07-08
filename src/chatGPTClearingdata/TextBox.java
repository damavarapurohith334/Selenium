package chatGPTClearingdata;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TextBox {

	WebDriver driver = new ChromeDriver();

	// Method is used written to eliminate the extra lines of code
	public void fillTextBoxs(By locaters, String value) {
		driver.findElement(locaters).sendKeys(value);
	}

	@BeforeTest
	public void setup() {
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();

	}

	@Ignore
	@Test(description = "This is the normal method")
	public void addProducts() {
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Rohith");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("rohith@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Rohith");
		driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Rohith");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}

	@Ignore
	@Test(description = "This method scrolls to the submit button using Java script")
	public void testData() throws InterruptedException {
		fillTextBoxs(By.xpath("//input[@id='userName']"), "Rohith");
		fillTextBoxs(By.xpath("//input[@id='userEmail']"), "rohith@gmail.com");
		fillTextBoxs(By.xpath("//textarea[@id='currentAddress']"), "Rohith");
		fillTextBoxs(By.xpath("//textarea[@id='permanentAddress']"), "Rohith");
		WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
		Thread.sleep(3000);
		submitButton.click();
		Thread.sleep(3000);
	}

	@Test(description = "This method clicks the submit button using Java script", priority = 1)
	public void testData1() throws InterruptedException {
		fillTextBoxs(By.xpath("//input[@id='userName']"), "Rohith");
		fillTextBoxs(By.xpath("//input[@id='userEmail']"), "rohith@gmail.com");
		fillTextBoxs(By.xpath("//textarea[@id='currentAddress']"), "Rohith");
		fillTextBoxs(By.xpath("//textarea[@id='permanentAddress']"), "Rohith");
		WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
		// click the submit button using the javaScript
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
		Thread.sleep(3000);
		submitButton.click();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void testSubmitedText() {
		String testText = driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']")).getText();
		System.out.println(testText);

		List<String> getTest = new ArrayList<String>();
		List<String> needToBeTested = new ArrayList<String>();
		getTest.add("//p[@id='name']");
		getTest.add("//p[@id='email']");
		getTest.add("//p[@id='currentAddress']");
		getTest.add("//p[@id='permanentAddress']");
		for (String string : getTest) {
			String testTextgot = driver.findElement(By.xpath(string)).getText();
			needToBeTested.add(testTextgot);

		}

		assertEquals(needToBeTested.get(0), "Name:Rohith");
		assertEquals(needToBeTested.get(1), "Email:rohith@gmail.com");
		assertEquals(needToBeTested.get(2), "Current Address :Rohith");
		assertEquals(needToBeTested.get(3), "Permananet Address :Rohith");
		System.out.println(needToBeTested);
	}

	@AfterTest
	public void closing() {
		driver.quit();
	}

}
