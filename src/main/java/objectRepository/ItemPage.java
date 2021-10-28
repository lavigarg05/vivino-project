package objectRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {
	private static List<WebElement> elements;
	private static WebElement element;
	
	/**
	 * @param driver
	 * @return headline and vintage title
	 * Description : on Selected Wine page fetches the title
	 */
	public static List<WebElement> getTitle(WebDriver driver){		
		elements=driver.findElements(By.xpath("//div[@class='row header breadCrumbs']//h1/span"));
		return elements;		
	}
	
	
	/**
	 * @param driver
	 * @return list of locations available
	 * Description : on Selected Wine page fetches all the locations
	 */
	public static List<WebElement> getLocation(WebDriver driver){		
		elements=driver.findElements(By.xpath("//div[@class='breadCrumbs__breadCrumbs--2pkcX']/span/a"));
		return elements;		
	}
	
	/**
	 * @param driver
	 * @return WebElement for average rating
	 * Description : on Selected Wine page fetches average rating
	 */
	public static WebElement getAverageRating(WebDriver driver){		
		element=driver.findElement(By.xpath("//div[@class='vivinoRating__averageValue--3Navj']"));
		return element;		
	}
	
	/**
	 * @param driver
	 * @return WebElement for average rating count
	 * Description : on Selected Wine page fetches rating count
	 */
	public static WebElement getRatingCount(WebDriver driver){		
		element=driver.findElement(By.xpath("//div[@class='vivinoRating__caption--3tZeS']"));
		return element;		
	}
	
	public static List<String> allLocations(WebDriver driver) {
		List<WebElement> spans=getLocation(driver);
		List<String> locationList=new ArrayList<String>();
		for(WebElement span : spans) {
			String location=span.getText();
			locationList.add(location);
		}
		
		return locationList;
	}
}
