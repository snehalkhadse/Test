package com.qa.test.pages;

import com.qa.test.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class WikiPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	//page constructor
	public WikiPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		
	}
	//by locators
	private By search=By.name("search");
	private By selectMovie=By.id("searchButton");
	private By release_date=By.xpath("//div[contains(text(),'Release date')]/ancestor::tr/td/div/ul/li");
	private By country=By.xpath("//th[contains(text(),'Country')]/parent::tr/td");

	

	public HashMap<String, String> getMovieDetails() {
		eleUtil.doSendKeys(search, "Pushpa: The Rise");
		eleUtil.doClick(selectMovie);
		String date = eleUtil.doGetText(release_date);
		String country1 = eleUtil.doGetText(country);

		HashMap<String, String> hm = new HashMap<>();
		hm.put("Date", date);
		hm.put("Country", country1);
		return hm;
	}
	
	


}
