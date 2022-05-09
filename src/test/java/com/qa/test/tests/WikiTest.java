package com.qa.test.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class WikiTest extends BaseTest {

    public static String date_wiki = null;
    public static String country_wiki = null;
    FileInputStream fis;
    Properties prop1;
    HashMap<String, String> wikiMovieDetails = null;

    @BeforeClass
    public void init() throws IOException {
        fis = new FileInputStream(System.getProperty("user.dir") + "\\srctestresources\\config\\movie_details.properties");
        prop1 = new Properties();
        prop1.load(fis);
    }

    @Test
    public void verifyDateWikiDate() {
        driver.get(prop.getProperty("url"));
        wikiMovieDetails = wikiPage.getMovieDetails();
        for (Map.Entry<String, String> entry : wikiMovieDetails.entrySet()) {
            if (entry.getKey().equals("Date")) {
                date_wiki = entry.getValue();
            }
        }
        //here we are verifying wiki movie date with imdb details
        Assert.assertEquals(date_wiki, prop1.getProperty("Date"), "date not matched with imdb");

    }

    @Test
    public void verifyDateWikiCountry() throws IOException {
        driver.get(prop.getProperty("url"));
        wikiMovieDetails = wikiPage.getMovieDetails();
        for (Map.Entry<String, String> entry : wikiMovieDetails.entrySet()) {
            if (entry.getKey().equals("Country")) {
                country_wiki = entry.getValue();
            }
        }
        //here we are verifying wiki movie country with imdb details
        Assert.assertEquals(country_wiki, prop1.getProperty("Country"), "country not matched with imdb");

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
