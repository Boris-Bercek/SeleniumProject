package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewAddressPage {
	
	WebDriver driver;
	WebElement inputAddressField;
	WebElement inputCityField;
    WebElement dropDownForState;
    WebElement alabama;
    WebElement inputZipCodeField;
    WebElement inputHomePhoneField;
    WebElement inputFutureReferenceField;
    WebElement saveButton;
	
    public AddNewAddressPage(WebDriver driver) {
		super();
		this.driver = driver;
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
	public WebElement getDropDownForState() {
		return driver.findElement(By.id("uniform-id_state"));
	}
	public void clickDropDownForState() {
		this.getDropDownForState().click();
	}
	
	public WebElement getInputZipCodeField() {
		return driver.findElement(By.id("postcode"));
	}
    
	public void inputZipCode(String zipcode) {
		this.getInputZipCodeField().clear();
		this.getInputZipCodeField().sendKeys(zipcode);
	}
	public WebElement getInputHomePhoneField() {
		return driver.findElement(By.id("phone_mobile"));
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
