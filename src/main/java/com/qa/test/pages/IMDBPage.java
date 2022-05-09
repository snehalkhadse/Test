package com.qa.test.pages;

import com.qa.test.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class IMDBPage {

    private WebDriver driver;
    private ElementUtil eleUtil;
    public static String movieName = "Pushpa: The Rise";

    //page constructor
    public IMDBPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);

    }

    //by locators
    private By search = By.name("q");
    private By selectMovie = By.xpath("(//div[contains(text(),'Pushpa: The Rise')])[1]");
    private By release_date = By.xpath("//a[contains(text(),'Release date')]/parent::li/div/ul/li/a");
    private By country = By.xpath("//span[contains(text(),'Country of origin')]/parent::li/div/ul/li/a");


    /**
     * This methood is used to get IMDB movie details
     */
    public void getImdbMovieDetails() {
        eleUtil.doSendKeys(search, movieName);
        eleUtil.doClick(selectMovie);
        String date = eleUtil.doGetText(release_date);
        String country1 = eleUtil.doGetText(country);
        System.out.println(date);
        System.out.println(country1);

        Properties properties = new Properties();
        try (OutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+"\\srctestresources\\config\\movie_details.properties")) {
            properties.setProperty("Date", date);
            properties.setProperty("Country", country1);
            // store the values
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
	
	



