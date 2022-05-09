package com.qa.test.utils;



	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.List;

	import com.qa.test.factory.DriverFactory;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.Wait;
	import org.openqa.selenium.support.ui.WebDriverWait;





	public class ElementUtil {

		private WebDriver driver;


		public ElementUtil(WebDriver driver) {
			this.driver = driver;

		}

		public By getBy(String locatorType, String locatorValue) {
			By locator = null;

			switch (locatorType.toLowerCase()) {
			case "id":
				locator = By.id(locatorValue);
				break;
			case "name":
				locator = By.name(locatorValue);
				break;
			case "classname":
				locator = By.className(locatorValue);
				break;
			case "xpath":
				locator = By.xpath(locatorValue);
				break;
			case "cssselector":
				locator = By.cssSelector(locatorValue);
				break;
			case "linktext":
				locator = By.linkText(locatorValue);
				break;

			default:
				System.out.println("please pass the right locator type and value.....");
				break;
			}

			return locator;

		}

		public WebElement getElement(By locator) {
			WebElement element = driver.findElement(locator);
			if (Boolean.parseBoolean(DriverFactory.highlight)) {

			}
			return element;
		}
		/*public WebElement getElement(By locator) {
			return driver.findElement(locator);
		}*/



		public List<WebElement> getElements(By locator) {
			return driver.findElements(locator);
		}

		public WebElement getElement(String locatorType, String locatorValue) {
			return driver.findElement(getBy(locatorType, locatorValue));
		}

		public void doClear(By locator) {
			getElement(locator).clear();
		}

		public void doSendKeys(By locator, String value) {
			doClear(locator);
			getElement(locator).sendKeys(value);
		}

		public void doSendKeys(String locatorType, String locatorValue, String value) {
			getElement(locatorType, locatorValue).sendKeys(value);
		}



		public void doClick(By locator) {
			getElement(locator).click();
		}

		public void doClick(String locatorType, String locatorValue) {
			getElement(locatorType, locatorValue).click();
		}



		public String doGetText(By locator) {
			return getElement(locator).getText();
		}

		public String getAttributeValue(By locator, String attrName) {
			String attrVal = getElement(locator).getAttribute(attrName);
			System.out.println(attrVal);
			return attrVal;
		}


















	}
	
	
	
	
	
	
	
	

