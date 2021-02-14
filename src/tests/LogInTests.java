package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest {

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}

	@Test(priority = 0)
	public void logInWithValidCredentials() throws InterruptedException {

		String username = excelReader.getData("validCredentials", 5, 5);
		String password = excelReader.getData("validCredentials", 6, 5);

		mainPage.clickSignInButton();
		authenticationPage.logIn(username, password);
		Thread.sleep(2000);
		excelReader.asserting("validCredentials", 8, 5, authenticationPage.myAccountLabel());
		Assert.assertTrue(accountPage.getSignOutButton().isDisplayed());
	}

	@Test(priority = 3)
	public void logInWithInvalidCredentials() throws InterruptedException {

		String username = excelReader.getData("invalidCredentials", 5, 5);
		String password = excelReader.getData("invalidCredentials", 6, 5);

		mainPage.clickSignInButton();
		authenticationPage.logIn(username, password);
		Thread.sleep(2000);
		excelReader.asserting("invalidCredentials", 8, 5, authenticationPage.authenticationFailedLabel());
	}

	@Test(priority = 5)
	public void loginWithInvalidPassword() throws InterruptedException {

		String username = excelReader.getData("invalidCredentials", 13, 5);
		String password = excelReader.getData("invalidCredentials", 14, 5);

		mainPage.clickSignInButton();
		authenticationPage.logIn(username, password);
		Thread.sleep(2000);
		excelReader.asserting("invalidCredentials", 16, 5, authenticationPage.authenticationFailedLabel());
	}

	@Test(priority = 8)
	public void loginWithoutCredentials() throws InterruptedException {

		mainPage.clickSignInButton();
		authenticationPage.clickGreenSignIn();
		Thread.sleep(1000);
		excelReader.asserting("emptyCredentials", 6, 5, authenticationPage.authenticationFailedLabel());
	}

	@Test(priority = 10)
	public void logOut() throws InterruptedException {

		logInWithValidCredentials();
		accountPage.clickSignOutButton();
		Thread.sleep(2000);
		excelReader.asserting("logOut", 9, 5, mainPage.getSignInButton().getText());
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {

		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
