package com.qa.test.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public Properties prop;
	public WebDriver driver;
	public static String highlight;

	/**
	 * This method is used to initialize browser
	 * @param prop prop
	 * @return driver
	 */

	public WebDriver init_driver(Properties prop) {
		String browseName = prop.getProperty("browser");
		System.out.println("browser name:" + browseName);
		highlight = prop.getProperty("highlight");

		if (browseName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browseName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browseName.equals("safari")) {
			driver = new SafariDriver();

		} else {
			System.out.println("please pass the right browse" + browseName);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		return driver;
	}


	public Properties init_prop()
	{
		prop=new Properties();
		FileInputStream ip=null;

		String envName=System.getProperty("env");
		if(envName==null) {
			try {
				ip = new FileInputStream(System.getProperty("user.dir")+"\\srctestresources\\config\\config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Running " + envName);
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		}

}
	
