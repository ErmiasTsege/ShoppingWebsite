
package com.qa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class Dressespage {
	private final static String URL = "http://automationpractice.com/index.php?id_category=5&controller=category";

	private WebDriver driver;

	public Dressespage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	private WebElement dresses;

	public void dresses() {
		dresses.click();
	}

	public static String getUrl() {
		return URL;
	}

	@FindBy(id = "search_query_top")
	private WebElement searchinput;

	@FindBy(name = "submit_search")
	private WebElement submitbutton;

	public void searchItem(String item) {

		searchinput.sendKeys(item);

		submitbutton.click();
	}

	@FindBy(xpath = "//*[@id=\"center_column\"]/p")
	private WebElement resfound;

	public WebElement searchAssert(String item) {

		return resfound;
	}

}