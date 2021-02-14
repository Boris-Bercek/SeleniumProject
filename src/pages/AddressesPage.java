package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressesPage {

	WebDriver driver;

	public AddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getNewAddressLabel() {
		return driver.findElement(By.className("address_address1"));
	}

	public WebElement getSaveGreenButton() {
		return driver.findElement(By.xpath("//*[@id=\"submitAddress\"]"));
	}

	public void clickSaveGreenButton() {
		this.getSaveGreenButton().click();
	}

	public WebElement getInputNewAddress() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[4]/input"));
	}

	public void inputNewAddress(String address) {
		this.getInputNewAddress().clear();
		this.getInputNewAddress().sendKeys(address);
	}

	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/div/div/ul/li[9]/a[1]"));
	}

	public void clickUpdateButton() {
		this.getUpdateButton().click();
	}

	public WebElement getDeleteButtonOfAddedAddress() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[9]/a[2]"));
	}

	public void clickDeleteButtonOfAddedAddress() {
		this.getDeleteButtonOfAddedAddress().click();
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[2]"));
	}

	public void clickDeleteButton() {
		this.getDeleteButton().click();
	}

	public WebElement getAddNewAddressButton() {
		return driver.findElement(By.xpath("//a[@title=\"Add an address\"]"));
	}

	public void clickAddNewAddressButton() {
		this.getAddNewAddressButton().click();
	}

	public WebElement noAddressesAvailableMassage() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]"));
	}
	/*
	 * public void noAddressesAvailableMassage() {
	 * this.getNoAddressesAvailableMassage().getText(); }
	 */
}
