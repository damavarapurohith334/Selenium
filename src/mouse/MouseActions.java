package mouse;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class MouseActions {

	
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void setup() {
		driver.get("https://www.kvb.co.in/");
		driver.manage().window().maximize();
	}

	
	@Test
	public void addProducts() throws InterruptedException {
	Actions actions = new Actions(driver);
	actions.moveToElement(driver.findElement(By.xpath("//a[@class='d-block' and text() = 'Personal']"))).pause(3000)
		.moveToElement(driver.findElement(By.xpath("//a[@class='mega-menu-tab__list__item' and @href='#p-loans']"))).pause(3000)
		.moveToElement(driver.findElement(By.xpath("//a[@class='text-underline' and text()='Vehicle Loans']")))
		.perform();
	Thread.sleep(3000);
	}

	@AfterTest
	public void closing() {
		driver.quit();
	}

}
