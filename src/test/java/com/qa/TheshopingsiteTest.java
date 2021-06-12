
package com.qa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TheshopingsiteTest {

	private WebDriver driver;
	private WebElement searchitems;

	// private final static String URL2 =
	// "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=pant&submit_search=";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
	}

	// 1
	@Test
	public void successfulysearch() throws InterruptedException {

		String item = "robe";

		ShoppingLandingPage landingPage = new ShoppingLandingPage(driver);
		driver.get(ShoppingLandingPage.URL);

		Dressespage dressespage = new Dressespage(driver);
		Tshirtspage tshirtspage = new Tshirtspage(driver);
		Womenpage womenpage = new Womenpage(driver);

		dressespage.dresses();
		dressespage.searchItem(item);
		Thread.sleep(7000);

		womenpage.womenpage();
		womenpage.searchItem(item);
		Thread.sleep(7000);

		tshirtspage.logintshirts();
		tshirtspage.searchItem(item);
		Thread.sleep(7000);

		WebElement target1 = dressespage.searchAssert(item);
		WebElement target2 = womenpage.searchAssert(item);
		WebElement target3 = tshirtspage.searchAssert(item);

		String resultText1 = target1.getText();
		String resultText2 = target2.getText();
		String resultText3 = target3.getText();

		Boolean res1 = resultText1.contains("No results were found for your search ");
		Boolean res2 = resultText2.contains("No results were found for your search ");
		Boolean res3 = resultText3.contains("No results were found for your search ");
// assertEquals(resultText1,"No results were found for your search ");
// assertEquals(resultText2,"No results were found for your search ");
// assertEquals(resultText3,"No results were found for your search ");

		assertTrue(res1);
		assertTrue(res2);
		assertTrue(res3);
		Thread.sleep(7000);
	}



	@After
	public void tearDown() {
		driver.close();
	}
}
