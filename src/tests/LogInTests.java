package tests;

import org.testng.annotations.Test;

public class LogInTests extends BaseTest {
	
	@Test
	public void logIn() throws InterruptedException {
		driver.navigate().to("http://cms.demo.katalon.com/");
		Thread.sleep(2000);
	}

}
