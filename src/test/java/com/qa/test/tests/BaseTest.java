package com.qa.test.tests;

import java.util.Properties;

import com.qa.test.pages.IMDBPage;
import com.qa.test.pages.WikiPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.qa.test.factory.DriverFactory;
import org.testng.asserts.SoftAssert;

public class BaseTest {
	 Properties prop;
	 WebDriver driver;
	 DriverFactory df;
	 IMDBPage imdbPage;
	 WikiPage wikiPage;

	 SoftAssert softassert;

	 
	 @BeforeClass
	 public void setup() throws InterruptedException
	 {
		 df=new DriverFactory();
		 prop=df.init_prop();
		 driver=df.init_driver(prop);
		 wikiPage=new WikiPage(driver);
		 imdbPage=new IMDBPage(driver);
		 softassert=new SoftAssert();
	 }

}
