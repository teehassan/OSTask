package stepDefinition;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.BaseUtil;

public class Hook extends BaseUtil {
	private BaseUtil base;
	public Hook (BaseUtil base){
		this.base = base;
	}

	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		base.driver = new ChromeDriver();
		base.driver.manage().window().maximize();
	}
	
	
	@After
	public void teardown() {
		base.driver.quit();
	}
}
