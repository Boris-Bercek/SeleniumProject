package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

	WebDriver driver;

	public AccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getMyAccountButton() {
		return driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
	}

	public void clickMyAccount() {
		this.getMyAccountButton().click();
	}

	public WebElement getMyWishlist() {
		return driver.findElement(By.className("icon-heart"));
	}

	public void clickMyWishlist() {
		this.getMyWishlist().click();
	}

	public WebElement getMyPersonalinfo() {
		return driver.findElement(By.className("icon-user"));
	}

	public void clickMyPersonalInfo() {
		this.getMyPersonalinfo().click();
	}

	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}

	public void clickSignOutButton() {
		this.getSignOutButton().click();
	}

	public WebElement getMyAddresses() {
		return driver.findElement(By.className("icon-building"));
	}
	
	public WebElement getMyAccountName() {
		return driver.findElement(By.className("header_user_info"));
	}

	public void clickMyAddresses() {
		this.getMyAddresses().click();
	}

}
