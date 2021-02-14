package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PersonalInfoPage {

	WebDriver driver;

	public PersonalInfoPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getMrs() {
		return driver.findElement(By.id("id_gender2"));
	}

	public void clickMrs() {
		this.getMrs().click();
	}

	public WebElement getMr() {
		return driver.findElement(By.id("id_gender1"));
	}

	public void clickMr() {
		this.getMr().click();
	}

	public WebElement getEmailField() {
		return driver.findElement(By.xpath("//*[@id=\"email\"]"));
	}

	public void updateEmailField(String mail) {
		this.getEmailField().clear();
		this.getEmailField().sendKeys(mail);
	}

	public void setDayBirth(int day) {
		Select dayDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
		dayDropdown.selectByValue(Integer.toString(day));
	}

	public void setMonthBirth(int month) {
		Select monthDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
		monthDropdown.selectByValue(Integer.toString(month));
	}

	public void setYearBirth(int year) {
		Select yearDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
		yearDropdown.selectByValue(Integer.toString(year));
	}

	public WebElement getFirstNameField() {
		return driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
	}

	public void updateFirstName(String firstName) {
		this.getFirstNameField().clear();
		this.getFirstNameField().sendKeys(firstName);
	}

	public WebElement getLastNameField() {
		return driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
	}

	public void updateLastName(String lastName) {
		this.getLastNameField().clear();
		this.getLastNameField().sendKeys(lastName);
	}

	public WebElement getCurrentPassword() {
		return driver.findElement(By.xpath("//*[@id=\"old_passwd\"]"));
	}

	public void enterCurrentPass(String pass) {
		this.getCurrentPassword().sendKeys(pass);
	}

	public WebElement getNewPasswordField() {
		return driver.findElement(By.id("passwd"));
	}

	public void enterNewPassword(String newPassword) {
		this.getNewPasswordField().clear();
		this.getNewPasswordField().sendKeys(newPassword);
	}

	public WebElement getConfirmationField() {
		return driver.findElement(By.id("confirmation"));
	}

	public void enterConfirmationPass(String confirm) {
		this.getConfirmationField().clear();
		this.getConfirmationField().sendKeys(confirm);
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button"));
	}

	public void clickSaveButton() {
		this.getSaveButton().click();
	}

	public WebElement getPersonalInfo() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
	}
}
