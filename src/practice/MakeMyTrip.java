package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MakeMyTrip {

	WebDriver driver = new ChromeDriver();
	Actions actions = new Actions(driver);

	@BeforeTest
	public void setUp() {
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void bookTrip() {
		driver.findElement(By.xpath("//span[@class = 'commonModal__close' ]")).click();
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("mumbai");
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(30));

		
		actions.moveByOffset(380, 350).click().perform();
		driver.findElement(By.xpath("//span[text()= 'Departure']")).click();
		myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Tue Jul 01 2025']"))).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		driver.findElement(By.xpath("//span[@class='bgProperties overlayCrossIcon icon20']")).click();
		
	}

	@AfterTest
	public void close() {
		//driver.quit();
	}
}
