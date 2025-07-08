package radioButtons;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtons {

	WebDriver driver = new ChromeDriver();


	@BeforeTest
	public void setup() {
		driver.get("https://demoqa.com/radio-button");
		driver.manage().window().maximize();

	}

	@Test
	public void checkBox() {
		//driver.findElement(By.xpath("//input[@class='custom-control-input' and @id='yesRadio']")).click();
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", 
				driver.findElement(By.xpath("//input[@class='custom-control-input' and @id='yesRadio']")));
		assertTrue(driver.findElement(By.xpath("//input[@class='custom-control-input' and @id='yesRadio']")).isSelected());
		assertFalse(driver.findElement(By.xpath("//input[@id='impressiveRadio']")).isSelected());
		driver.findElement(By.xpath("//input[@id='noRadio']")).isEnabled();
		assertFalse(driver.findElement(By.xpath("//input[@id='noRadio']")).isEnabled(),"No the button is disabled");
	}

	@AfterTest
	public void closing() throws InterruptedException {
//		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.wait(3000);
		driver.quit();
	}

}
