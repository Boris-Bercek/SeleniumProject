package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
	
	WebDriver driver;
	WebElement updateButton;
	WebElement deleteButton;
	WebElement addNewAddressButton;
	WebElement inputNewAddress;
	WebElement saveGreenButton;
	
	public WebElement getSaveGreenButton() {
		return driver.findElement(By.id("submitAddress"));
	}
	public void clickSaveGreenButton() {
		this.getSaveGreenButton().click();
	}
	public WebElement getInputNewAddress() {
		return driver.findElement(By.id("address1"));
	}
	public void inputNewAddress(String address) {
		this.getInputNewAddress().clear();
		this.getInputNewAddress().sendKeys(address);
	}
	public MyAddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getUpdateButton() {
		return driver.findElement(By.name("Update"));
	}
	public void clickUpdateButton() {
		this.getUpdateButton().click();
	}
	public WebElement getDeleteButton() {
		return driver.findElement(By.name("Delete"));
	}
	public void clickDeleteButton() {
		this.getDeleteButton().click();
	}
	public WebElement getAddNewAddressButton() {
		return driver.findElement(By.cssSelector("btn.btn-default.button.button-medium"));
	}
	public void clickAddNewAddressButton() {
		this.getAddNewAddressButton().click();
	}
	

}
