package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	
	WebDriver driver;
	WebElement signOutButton;
	WebElement myAddresses;
	
	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}
   public void clickSignOutButton() {
	   this.getSignOutButton().click();
   }
	public WebElement getMyAddresses() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a"));
	}
	public void clickMyAddresses() {
		this.getMyAddresses().click();
	}
   
}
