package vivino.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author lavigarg
 * class : GetBrowser
 * description : to get driver object for a browser
 */
public class GetBrowser {
	
	private String browserName;
	private WebDriver driver;
	
	public GetBrowser(String browserName){
		this.browserName=browserName;
		setDriver();
	}
	
	private void setDriver() {
		
		switch(browserName.toLowerCase()) {
			case "chrome" :  chromeBrowser();
							 break;
							 
			case "firefox" : firefoxBrowser();
							 break;
		
			default : System.out.print("Invalid Browser/Browser Not Supported Yet");	
		}
	

	}
	
	private void chromeBrowser() {
		//Please provide chromedriver exe version as per current chrome installation
		//this exe is for Chrome version 94
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\browserExeFiles\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("chrome.switches", "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling");
		driver = new ChromeDriver();
	}
	
	private void firefoxBrowser() {
		//Please provide geckodriver exe version as per current firefox installation
		//this exe is for firefox version 72
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\browserExeFiles\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
}
