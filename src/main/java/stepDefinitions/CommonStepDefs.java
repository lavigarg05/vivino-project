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
	  private List<String> listLocations;
	  private String keyword;
	  Map<String,String> selectedItem=new HashMap<>();
	  
	  @Before()
	  public void before() {
		  System.out.println("********************************START TEST****************************************");
		  sa=new SoftAssert();
	  }
	  
	  @After
	  public void After(){
		  driver.quit();
		  sa.assertAll();	
		  System.out.println("********************************END TEST******************************************");
		  System.out.println();
		  System.out.println();
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
		  driver.get(website);
		  System.out.println("Website "+website +" launched successfully on browser "+browser);
	  }
	
	
	  /**
	 * @param keyword : string to search in searchbox
	 * @throws Throwable
	 * description : search for given keyword.
	 */
	@When("^Search for \"(.*)\"$")
	    public void searchForKeyword(String keyword) throws Throwable {
		  this.keyword=keyword;
		  HomePage.searchKeyword(driver, keyword);
		  System.out.println("Keyword '"+keyword+"' search completed");
	  }
	
	/**
	 * Description : This glue code fetches data of all wine listed in search result.
	 * The data is stored in data structure of type List<Map <String,String>> 
	 * The fields stored for each item are : name, region, country, rating, ratingCount
	 */
	@When("^collect information of all wines$")
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
			System.out.println("Fetching info for wine "+i+": "+title);
			Assert.assertTrue("Region or country for item "+i+" not found", SearchPage.getEachItemRegion(driver, i).size()==2);
			
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
	
	
	/**
	 * @param Keyword : Keyword to be verified
	 * Description : this glue code verifies whether given keyword is included in title or region or country of each wine present in search result
	 */
	@Then("^verify each wine data for \"(.*)\"$")
	public void verifyItemdata(String Keyword) {
		
		String [] arrKeyword=Keyword.split(" ");
		System.out.println("Verifying each searched item contains keyword: "+Keyword+"...");
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
				System.err.println("FAIL : No attribute of wine "+title+" contains keyword "+Keyword);
			}
			sa.assertEquals(flag, 1, "FAIL: No attribute of wine "+title+" contains keyword "+Keyword);
			System.out.println();
		}
	}
	
	/**
	 * Description : This glue code selects a random wine from the search result
	 */
	@When("^select a random wine$")
	public void selectItem() {
		Random random = new Random();
		SelectedItem=random.nextInt(itemCount) + 1;
		WebElement itemSelected=SearchPage.getEachItem(driver, SelectedItem);	
		System.out.println("Selected item : "+itemSelected.getText());
		itemSelected.click();
			
	}
	
	/**
	 * Description : This glue code collects data for selcted wine and stores in structure Map<String,String> selectedItem . This map has keys - name ,rating, ratingCount
	 * All locations found on selected item is stored in List<String> listLocations
	 */
	@When("^collect information for selected wine$")
	public void selectItemInfo() {
		
		System.out.println("Collecting data from selected item...");
		
		String headline=ItemPage.getTitle(driver).get(0).getText();
		String vintage =ItemPage.getTitle(driver).get(1).getText();
		String title= headline.trim()+" "+vintage.trim();
		listLocations = ItemPage.allLocations(driver);
		String averageRating=ItemPage.getAverageRating(driver).getText();
		String ratingCount=ItemPage.getRatingCount(driver).getText();
		
		selectedItem.put("name", title);
		selectedItem.put("rating", averageRating.trim());
		selectedItem.put("ratingCount", ratingCount.trim());
		//System.out.println(listLocations);
		//System.out.println(selectedItem);
	}
	
	/**
	 * Description : This glue code compares data between - data of wine selected on search result page (Map<String,String> searchedItem) TO data found on wine specific page after wine is selected(Map<String,String> selectedItem) 
	 * It also checks if keyword is present in data of selected wine
	 */
	@Then("^verify selected wine data$")
	public void final_verification(){
		
		System.out.println("Verifying each attribute value is equal to one stored in the structure created earlier...");
		Map<String,String> searchedItem=new HashMap<String,String>();
		searchedItem=itemData.get(SelectedItem-1);
		
		//comparing titles
		if(searchedItem.get("name").trim().equals(selectedItem.get("name").trim())) {
			System.out.println("PASS: Searched item Title and Selected Item Title is same: "+selectedItem.get("name").trim());
			if(selectedItem.get("name").trim().contains(keyword)) 
				System.out.println("PASS: Selected item Title contains keyword: "+keyword);			
		}
		else 
			System.err.println("FAIL: Searched item Title and Selected Item Title is different: "+selectedItem.get("name").trim()+" vs "+searchedItem.get("name").trim());
			
		//comparing region and country	
		int regionFlag=0;
		int countryFlag=0;
		for(String location:listLocations) {
			if(location.equals(searchedItem.get("region")))
				regionFlag++;
			if(location.equals(searchedItem.get("country")))
				countryFlag++;			
		}
		
		if(regionFlag==1) {
			System.out.println("PASS: Searched item region and Selected Item region is same: "+searchedItem.get("region").trim());
			if(searchedItem.get("region").trim().contains(keyword)) 
				System.out.println("PASS: Selected item region contains keyword: "+keyword);			
		}
		else 
			System.err.println("FAIL: region not present in selected item: "+searchedItem.get("region").trim());
		
		if(countryFlag==1) {
			System.out.println("PASS: Searched item country and Selected Item country is same: "+searchedItem.get("country").trim());
			if(searchedItem.get("country").trim().contains(keyword)) 
				System.out.println("PASS: Selected item country contains keyword: "+keyword);			
		}
		else 
			System.err.println("FAIL: country not present in selected item: "+searchedItem.get("country").trim());

		
		//comparing Average Rating
		if(searchedItem.get("rating").trim().equals(selectedItem.get("rating").trim())) 
			System.out.println("PASS: Searched item rating and Selected Item rating is same: "+selectedItem.get("rating").trim());
		else 
			System.err.println("FAIL: Searched item rating and Selected Item rating is different: "+selectedItem.get("rating").trim()+" vs "+searchedItem.get("rating").trim());
		
		//comparing rating count
		if(searchedItem.get("ratingCount").trim().equals(selectedItem.get("ratingCount").trim())) 
			System.out.println("PASS: Searched item ratingCount and Selected Item ratingCount is same: "+selectedItem.get("ratingCount").trim());
		else 
			System.err.println("FAIL: Searched item ratingCount and Selected Item ratingCount is different: "+selectedItem.get("ratingCount").trim()+" vs "+searchedItem.get("ratingCount").trim());

		
		sa.assertEquals(selectedItem.get("name").trim(), searchedItem.get("name").trim(),"Title mismatch (actual) "+selectedItem.get("name").trim()+" (expected) "+searchedItem.get("name").trim());
		sa.assertEquals(selectedItem.get("rating").trim(), searchedItem.get("rating").trim(),"Average rating Value mismatch (actual) "+selectedItem.get("rating").trim()+" (expected) "+searchedItem.get("rating").trim());
		sa.assertEquals(selectedItem.get("ratingCount").trim(), searchedItem.get("ratingCount").trim(),"Rating count mismatch (actual) "+selectedItem.get("ratingCount").trim()+" (expected) "+searchedItem.get("ratingCount").trim());
	}
}