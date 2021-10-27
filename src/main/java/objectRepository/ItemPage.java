package objectRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {
	private static List<WebElement> elements;
	
	public static List<WebElement> getTitle(WebDriver driver){		
		elements=driver.findElements(By.xpath("//div[@class='row header breadCrumbs']//h1/span"));
		return elements;		
	}
	
	
	public static List<WebElement> getLocation(WebDriver driver){		
		elements=driver.findElements(By.xpath("//div[@class='breadCrumbs__breadCrumbs--2pkcX']/span/a"));
		return elements;		
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
