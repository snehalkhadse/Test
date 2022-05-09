package com.qa.test.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class IMDBTest extends BaseTest {

	@Test
	public void getMovieDetailsTest()
	{

		driver.get(prop.getProperty("url1"));
		imdbPage.getImdbMovieDetails();

	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}





}
