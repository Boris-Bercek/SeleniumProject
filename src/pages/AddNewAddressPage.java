package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddNewAddressPage {

	WebDriver driver;

	public AddNewAddressPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getNewAddressSection() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul"));
	}

	public WebElement getInputAddressField() {
		return driver.findElement(By.id("address1"));
	}

	public void addAddress(String address) {
		this.getInputAddressField().clear();
		this.getInputAddressField().sendKeys(address);
	}

	public WebElement getInputCityField() {
		return driver.findElement(By.id("city"));
	}

	public void addCity(String city) {
		this.getInputCityField().clear();
		this.getInputCityField().sendKeys(city);
	}

	public void getState(int stateValue) {
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByValue(Integer.toString(stateValue));
	}

	public WebElement getInputZipCodeField() {
		return driver.findElement(By.id("postcode"));
	}

	public void inputZipCode(String zipcode) {
		this.getInputZipCodeField().clear();
		this.getInputZipCodeField().sendKeys(zipcode);
	}

	public WebElement getInputHomePhoneField() {
		return driver.findElement(By.id("phone"));
	}

	public void inputHomePhone(String phone) {
		this.getInputHomePhoneField().clear();
		this.getInputHomePhoneField().sendKeys(phone);
	}

	public WebElement getInputFutureReferenceField() {
		return driver.findElement(By.id("alias"));
	}

	public void inputAlias(String mail) {
		this.getInputFutureReferenceField().clear();
		this.getInputFutureReferenceField().sendKeys(mail);
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}

	public void clickSaveButton() {
		this.getSaveButton().click();
	}
}
