package text;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;

public class TextBox extends BaseTest {

	@Test(priority = 1, description = "Submit form using regular WebElement click")
	public void addProducts(Method method) {
		test = extent.createTest(method.getName()).assignAuthor("Rohith").assignCategory("Smoke");

		try {
			test.info("Entering user details in form");

			driver.findElement(By.id("userName")).sendKeys("Rohith");
			test.pass("Entered Name");

			driver.findElement(By.id("userEmail")).sendKeys("rohith@gmail.com");
			test.pass("Entered Email");

			driver.findElement(By.id("currentAddress")).sendKeys("Rohith");
			test.pass("Entered Current Address");

			driver.findElement(By.id("permanentAddress")).sendKeys("Rohith");
			test.pass("Entered Permanent Address");

			driver.findElement(By.id("submit")).click();
			test.pass("Clicked Submit");

		} catch (Exception e) {
			test.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	@Test(priority = 2, description = "Submit form after scrolling to button with JavaScript")
	public void testData(Method method) throws InterruptedException {
		test = extent.createTest(method.getName()).assignAuthor("Rohith").assignCategory("Functional");

		try {
			fillTextBoxs(By.id("userName"), "Rohith");
			fillTextBoxs(By.id("userEmail"), "rohith@gmail.com");
			fillTextBoxs(By.id("currentAddress"), "Rohith");
			fillTextBoxs(By.id("permanentAddress"), "Rohith");
			test.info("All form fields filled");

			WebElement submitButton = driver.findElement(By.id("submit"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
			test.info("Scrolled to Submit button");

			Thread.sleep(1000);
			submitButton.click();
			test.pass("Form submitted successfully using scroll");

		} catch (Exception e) {
			test.fail("Submission failed: " + e.getMessage());
		}
	}

	@Test(priority = 3, description = "Click submit button using JavaScript")
	public void testData1(Method method) throws InterruptedException {

		test = extent.createTest(method.getName()).assignAuthor("Rohith").assignCategory("Regression");

		try {
			fillTextBoxs(By.id("userName"), "Rohith");
			fillTextBoxs(By.id("userEmail"), "rohith@gmail.com");
			fillTextBoxs(By.id("currentAddress"), "Rohith");
			fillTextBoxs(By.id("permanentAddress"), "Rohith");

			test.info("Filled the form successfully");

			WebElement submitButton = driver.findElement(By.id("submit"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
			test.pass("Clicked submit using JavaScript");

			Thread.sleep(1000);

		} catch (Exception e) {
			test.fail("JavaScript click failed: " + e.getMessage());
		}
	}

	@Test(priority = 4, description = "Verify submitted data")
	public void testSubmitedText(Method method) throws InterruptedException {
	    test = extent.createTest(method.getName()).assignAuthor("Rohith").assignCategory("Validation");

	    try {
	        // Reuse logic from testData1() — do not call it from another instance
	        fillTextBoxs(By.id("userName"), "Rohith");
	        fillTextBoxs(By.id("userEmail"), "rohith@gmail.com");
	        fillTextBoxs(By.id("currentAddress"), "Rohith");
	        fillTextBoxs(By.id("permanentAddress"), "Rohith");

	        WebElement submitButton = driver.findElement(By.id("submit"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

	        Thread.sleep(1000); // Give some time for the result section to appear

	        List<String> getXpaths = List.of(
	            "//p[@id='name']",
	            "//p[@id='email']",
	            "//p[@id='currentAddress']",
	            "//p[@id='permanentAddress']"
	        );

	        List<String> actualTexts = new ArrayList<>();

	        for (String xpath : getXpaths) {
	            WebElement element = driver.findElement(By.xpath(xpath));
	            String text = element.getText();
	            actualTexts.add(text);
	            test.info("Captured: " + text);
	        }

	        assertEquals(actualTexts.get(0), "Name:Rohith");
	        assertEquals(actualTexts.get(1), "Email:rohith@gmail.com");
	        assertEquals(actualTexts.get(2), "Current Address :Rohith");
	        assertEquals(actualTexts.get(3), "Permananet Address :Rohith");

	        test.pass("Submitted text verified successfully");

	    } catch (AssertionError ae) {
	        test.fail("Text verification failed: " + ae.getMessage());
	    } catch (Exception e) {
	        test.fail("Error occurred: " + e.getMessage());
	    }
	}

}
