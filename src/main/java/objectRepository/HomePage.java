package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public static WebElement element = null;
	public static List<WebElement> elements = null;
	
	/**
	 * Returns the Search text box element
	 * @param driver
	 * @return
	 */
	public static WebElement searchTextBox(WebDriver driver) {
		element =driver.findElement(By.xpath("//input[@placeholder='Search any wine']"));
		return element;
	}
	

	/**
	 * @param driver
	 * @param origin
	 * Enters text in searchbox
	 */
	public static void searchKeyword(WebDriver driver, String keyword) {
		element = searchTextBox(driver);
		element.sendKeys(keyword);
		element.sendKeys(Keys.RETURN);
	}
		
	
}
