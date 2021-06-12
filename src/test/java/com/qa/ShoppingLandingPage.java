package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingLandingPage {

	public final static String URL = "http://automationpractice.com/index.php";

	private WebDriver driver;

	// 1
	public ShoppingLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static String getUrl() {
		return URL;
	}
	
	@FindBy(id = "search_query_top")
	private WebElement searchinput;
	
	@FindBy(name  = "submit_search")
	private WebElement submitbutton;
	
	public void searchItem(String item) {

		searchinput.sendKeys(item);
		
		submitbutton.click();
	}
	
	

}
