package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public static WebElement element = null;
	public static List<WebElement> elements = null;
	
	
	/**
	 * @param driver 
	 * @return element list
	 * description : fetches all items on the search page
	 *  
	 */
	public static List<WebElement> findAllItems(WebDriver driver) {
		elements=driver.findElements(By.xpath("//div[@class='card card-lg']"));
		return elements;
	}
	
	
	/**
	 * @param driver
	 * @param itemcount : index of item to be fetched
	 * @return : WebElment
	 * description : fetches wine of index itemcount in search results
	 */
	public static WebElement getEachItem(WebDriver driver,int itemcount) {
		element=driver.findElement(By.xpath("//div[@class='card card-lg']["+itemcount+"]//span[@class='header-smaller text-block wine-card__name']//span[@class='bold']"));
		return element;
	}
	
	
	/**
	 * @param driver
	 * @param itemcount : index of item to be fetched
	 * @return : List<WebElement>
	 * description : fetches region and country of wine at index itemcount in search results. Region is found at index 0 of list and country at index 1.
	 */
	public static List<WebElement> getEachItemRegion(WebDriver driver,int itemcount) {
		try {
			elements=driver.findElements(By.xpath("//div[@class='card card-lg']["+itemcount+"]//span[@class='text-block wine-card__region']//a"));
		}
		catch(NoSuchElementException e) {
			System.err.println("Unable to find element Region for item "+itemcount);
			throw e;
		}
		return elements;
	}
	
	
	/**
	 * @param driver
	 * @param itemcount : index of item to be fetched
	 * @return : WebElement
	 * description : fetches Average Rating of wine at index itemcount in search results
	 */
	public static WebElement getEachItemAverageRating(WebDriver driver,int itemcount) {
		try {	
			element=driver.findElement(By.xpath("//div[@class='card card-lg']["+itemcount+"]//span[contains(text(),'Average rating')]//following-sibling::div[@class='text-inline-block light average__number']"));
		}
		catch(NoSuchElementException e) {
			System.err.println("Unable to find Average Rating for item "+itemcount);
			element=null;			
		}
		return element;
	}
	
	/**
	 * @param driver
	 * @param itemcount : index of item to be fetched
	 * @return : WebElement
	 * description : fetches Total Rating count of wine at index itemcount in search results
	 */
	public static WebElement getEachItemAverageRatingCount(WebDriver driver,int itemcount) {
		try{
			element=driver.findElement(By.xpath("//div[@class='card card-lg']["+itemcount+"]//div[@class='text-inline-block average__stars']/p[@class='text-micro']"));
		}
		catch(NoSuchElementException e) {
			System.err.println("Unable to find Average Rating Count number for item "+itemcount);
			//throw e;
			element=null;
		}
		return element;
	}
	
}
