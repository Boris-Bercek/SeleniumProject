package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest {
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	@Test
	public void logInWithValidCredentials() throws InterruptedException {
		mainPage.clickSignInButton();
		String username = excelReader.getData("validCredentials", 5, 6);
		String password = excelReader.getData("validCredentials", 6, 6);
		authenticationPage.logIn(username, password );
		authenticationPage.clickGreenSignIn();
		Thread.sleep(2000);
		excelReader.asserting("validCredentials", 8, 6, authenticationPage.myAccountLabel());
	}
	@Test
	public void logInWithInvalidCredentials() throws InterruptedException {
		mainPage.clickSignInButton();
		String username = excelReader.getData("invalidCredentials", 5, 6);
		String password = excelReader.getData("invalidCredentials", 6, 6);
		authenticationPage.logIn(username, password );
		authenticationPage.clickGreenSignIn();
		Thread.sleep(2000);
		excelReader.asserting("invalidCredentials", 8, 6, authenticationPage.authenticationFailedLabel());
	}
	@Test
	public void loginWithoutCredentials() throws InterruptedException {
		mainPage.clickSignInButton();
		authenticationPage.clickGreenSignIn();
		Thread.sleep(1000);
		excelReader.asserting("emptyCredentials", 6, 6, authenticationPage.authenticationFailedLabel());
	}
	@Test
	public void logOut() throws InterruptedException {
		 logInWithValidCredentials();
		 myAccountPage.clickSignOutButton();
		 Thread.sleep(2000);
		 excelReader.asserting("logOut", 9, 6, mainPage.getSignInButton().getText());
    }
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
