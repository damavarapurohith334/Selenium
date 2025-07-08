package chatGPTClearingdata;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBox {

	WebDriver driver = new ChromeDriver();


	@BeforeTest
	public void setup() {
		driver.get("https://demoqa.com/checkbox");
		driver.manage().window().maximize();

	}

	@Test
	public void checkBox() {
		driver.findElement(By.xpath("//button[@type='button' and @class='rct-option rct-option-expand-all']")).click();
		WebElement element = driver.findElement(By.xpath("//span[text()='Desktop']/preceding-sibling::span[@class='rct-checkbox']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		String result = driver.findElement(By.id("result")).getText();
		System.out.println(result);
		assertTrue(result.toLowerCase().contains("desktop"),"Desktop not selected!");
	}

	@AfterTest
	public void closing() {
	//	driver.quit();
	}

}
