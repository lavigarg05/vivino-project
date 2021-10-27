package stepDefinitions;


import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.HomePage;
import objectRepository.ItemPage;
import objectRepository.SearchPage;
import vivino.common.GetBrowser;

public class CommonStepDefs {
	
	  private GetBrowser browserObj; 	  
	  WebDriver driver;	
	  List<Map <String,String>> itemData=new ArrayList<Map<String,String>>();
	  private int itemCount;
	  private SoftAssert sa;
	  private int SelectedItem;
	  Map<String,String> selectedItem=new HashMap<>();
	  
	  @Before()
	  public void before() {
		  sa=new SoftAssert();
	  }
	  
	  @After
	  public void After(){
		  sa.assertAll();
	  }
	  
	  
	  /**
	 * @param website : name of the website to launch
	 * @param browser : name of browser 
	 * description : this glue code launches the website in given browser. The browser to be supported can be scaled up by defining in GetBrowser class
	 */
	@Given("^Launch website (.*) in (\\w+) browser$")
	  public void launchWebsite(String website,String browser) {
		  System.out.println("Launching "+website+" on browser "+browser);
		  browserObj= new GetBrowser(browser);
		  driver=browserObj.getDriver();
		  Assert.assertNotEquals("Driver object could not be created. Refer logs for more info.", driver, null);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  //driver.get(website);
		  driver.get("https://www.vivino.com/eight-sides-eight-sides-viognier/w/3783627");
		  System.out.println("Website "+website +" launched successfully on browser "+browser);
	  }
	
	
	  /**
	 * @param keyword : string to search in searchbox
	 * @throws Throwable
	 * description : search for given keyword.
	 */
	@When("^Search for (.*)$")
	    public void searchForKeyword(String keyword) throws Throwable {
		  HomePage.searchKeyword(driver, keyword);
		  System.out.println("Keyword '"+keyword+"' search completed");
	  }
	
	@When("^collect information of all items$")
	public void collectInfo() {
		System.out.println("collecting info for items displayed on search results");

		itemCount = SearchPage.findAllItems(driver).size();
		String title;
		String region;
		String country;
		String rating;
		String ratingCount;
		String element;

		for(int i=1;i<=itemCount;i++) {
			
			Map<String,String> itemMap=new HashMap<String,String>();
			title=SearchPage.getEachItem(driver, i).getText();
			
			Assert.assertTrue("Region and country for item "+i+" not found", SearchPage.getEachItemRegion(driver, i).size()>0);
			
			Assert.assertNotEquals("Average rating for item "+i+" not found", SearchPage.getEachItemAverageRating(driver, i),null);
			Assert.assertNotEquals("Average Rating Count for item "+i+" not found", SearchPage.getEachItemAverageRatingCount(driver, i),null);

			region=SearchPage.getEachItemRegion(driver, i).get(0).getText();
			country=SearchPage.getEachItemRegion(driver, i).get(1).getText();
			rating=SearchPage.getEachItemAverageRating(driver, i).getText().trim();
			ratingCount=SearchPage.getEachItemAverageRatingCount(driver, i).getText().trim();
			itemMap.put("name", title);
			itemMap.put("region", region);
			itemMap.put("country", country);	
			itemMap.put("rating", rating);
			itemMap.put("ratingCount", ratingCount);
			itemData.add(itemMap);
		}
		System.out.println("Data collection for items displayed on search results completed");

	}		
	
	
	@Then("^verify item data for (.*)$")
	public void verifyItemdata(String Keyword) {
		
		String [] arrKeyword=Keyword.split(" ");
		
		for(int i=0;i<itemCount;i++) {
			int flag=0;
			String title=itemData.get(i).get("name");
			String country=itemData.get(i).get("country");
			String region=itemData.get(i).get("region");
			System.out.println("ITEM : "+(i+1));
			
			for(String key : arrKeyword) {
				if(title.contains(key)) {
					flag=1;
					System.out.println("PASS: Title: "+title+" contains keyword "+key);
				}
				if(country.contains(key)) {
					flag=1;
					System.out.println("PASS: Country: "+country+" contains keyword "+key);
				}
			
				if(region.contains(key)) {
					flag=1;
					System.out.println("PASS: Region: "+region+" contains keyword "+key);
				}
			}
			
			if(flag==0) {
				System.out.println("FAIL : No attribute of wine "+title+" contains keyword "+Keyword);
			}
			sa.assertEquals(flag, 1, "FAIL: No attribute of wine "+title+" contains keyword "+Keyword);
			System.out.println();
		}
	}
	
	@When("^select a random wine$")
	public void selectItem() {
		Random random = new Random();
		SelectedItem=random.nextInt(itemCount) + 1;
		SearchPage.getEachItem(driver, SelectedItem).click();
	
	}
	
	@When("^collect information for selected item$")
	public void selectItemInfo() {
		String headline=ItemPage.getTitle(driver).get(0).getText();
		String vintage =ItemPage.getTitle(driver).get(1).getText();
		List<String> listLocations = ItemPage.allLocations(driver);
		
		String title= headline.trim()+" "+vintage.trim();
		
		selectedItem.put("name", title);
		System.out.println(title);
		System.out.println(listLocations);
	}
}