package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {

	WebDriver driver;

	public AuthenticationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getEmailRequiredLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}

	public String emailRequiredLabel() {
		return this.getEmailRequiredLabel().getText();
	}

	public WebElement getAuthenticationFailedLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}

	public String authenticationFailedLabel() {
		return this.getAuthenticationFailedLabel().getText();
	}

	public WebElement getMyAccountLabel() {
		return driver.findElement(By.className("page-heading"));
	}

	public String myAccountLabel() {
		return this.getMyAccountLabel().getText();
	}

	public WebElement getInputEmail() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getInputPassword() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));

	}

	public void logIn(String email, String password) throws InterruptedException {
		this.getInputEmail().clear();
		this.getInputEmail().sendKeys(email);
		Thread.sleep(2000);
		this.getInputPassword().clear();
		this.getInputPassword().sendKeys(password);
		Thread.sleep(2000);
		this.clickGreenSignIn();
	}

	public void clickGreenSignIn() {
		this.getSignInButton().click();
	}

}
