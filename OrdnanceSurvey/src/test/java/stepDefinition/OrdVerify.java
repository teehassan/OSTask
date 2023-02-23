package stepDefinition;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.BaseUtil;

public class OrdVerify extends BaseUtil{
	private BaseUtil base;
	public OrdVerify(BaseUtil base){
		this.base = base;
	}

	
	@Given("User is on the webpage")
	public void user_is_on_the_webpage() throws InterruptedException {
		base.driver.get("https://osdatahub.os.uk/");
		WebDriverWait wait = new WebDriverWait(base.driver, 40);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.
				xpath("//button[@id='ccc-notify-accept']")));
		element.click();
		Thread.sleep(1000);
	}
	
	// Scenario: Verify page Title and items are displayed on the page
	@And("user can verify title page and see the welcome text")
	public void user_can_verify_title_page_and_see_the_welcome_text() {		
		String expectedTitle = "OS Data Hub | Free Maps & API Data for Developers";
		String actualTitle = base.driver.getTitle();
		System.out.println(actualTitle);		
		Assert.assertEquals(expectedTitle, actualTitle);
		
//		if(base.driver.getPageSource().contains("Welcome to the Ordnance Survey Data Hub")){
//			System.out.println("You are on the osdatahub page");
//		}else {System.out.println("Please can you input the valid website");}
		
	}
	
	// Scenario: Verify items are displayed on the API Dashboard page
	@When("user clicks on API Dashboard")
	public void user_clicks_on_api_dashboard() throws InterruptedException {
		base.driver.findElement(By.xpath("//span[text()='API Dashboard']")).click();
		Thread.sleep(1000);
	}

	@Then("user should see a welcome to OS data hub message")
	public void user_should_see_a_welcome_to_os_data_hub_message() {
		if(base.driver.getPageSource().contains("Dashboard")){
			System.out.println("You are on the API Dashboard page");
		}else {System.out.println("You are not on the API Dashboard page");}
	}
	
	// Scenario: Verify items are displayed on the Download page
	@When("user clicks on download")
	public void user_clicks_on_download() {
		base.driver.findElement(By.xpath("//span[text()='Download']")).click();
		
	}

	@Then("user should see OS OpenData Download")
	public void user_should_see_os_open_data_download() {
		if(base.driver.getPageSource().contains("OS OpenData Downloads")){
			System.out.println("You are on the Download page");
		}else {System.out.println("You are not on the Download page");}
	}

	@When("user clicks on Docs page")
	public void user_clicks_on_docs_page() {
		base.driver.findElement(By.xpath("//span[text()='Docs']")).click();
	}
	
	
	@When("User verifies items on the side menu")
	public void user_verifies_items_on_the_side_menu() {
		
		// Expected side menu items		
		String[] expected = {"Docs", "OS NGD API – Features", "OS Downloads API", "OS Features API",
				"OS Linked Identifiers API", "OS Maps API", "OS Match & Cleanse API", "OS Names API", 
				"OS Places API", "OS Vector Tile API", "OAuth 2 API", "Legal", "Our brand logo"};
		
		// Actual Array of side menu items
		List<WebElement> Element = base.driver.findElements(
				By.xpath("/html/body/div[2]/div[2]/div/nav/ul/li"));					
		ArrayList<String> TextList = new ArrayList<String>();
		for (WebElement x : Element) {
			TextList.add(x.getText());
			}
			
		// Verify actual menu items with expected menu items
		for(int i = 0; i < expected.length; i++) {			
		    String  items = expected[i];
			System.out.println(items);
			
			if (TextList.contains(items)) {
				System.out.println("side menu verified");
			} else {System.out.println("side menu not verified, please try again");}
			}
		
		// Verify actual number of menu items with expected items number
		Assert.assertTrue(TextList.size() == expected.length);				
	}
	

	@Then("user should be able to expand listed sections under OS features API")
	public void user_should_be_able_to_expand_listed_sections_under_os_features_api() throws InterruptedException {
	    
		//Click on OS Features API
		base.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/nav/ul/li[4]")).click();
		
		// Verify expanded listed sections 
		List<WebElement> Element2 = base.driver.findElements(
				By.xpath("/html/body/div[2]/div[2]/div/nav/ul/li[5]/ul/li"));
		
		for(int i = 0; i < Element2.size(); i++) {
			Element2.get(i).click();
			System.out.println("Expanded link clicked");
			Thread.sleep(1000);
		}		

	}

}
