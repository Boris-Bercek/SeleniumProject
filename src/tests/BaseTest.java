package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AddNewAddressPage;
import pages.AuthenticationPage;
import pages.MainPage;
import pages.AccountPage;
import pages.AddressesPage;
import pages.WishlistPage;
import pages.PersonalInfoPage;

public class BaseTest {
	
	WebDriver driver;
	ExcelReader excelReader;
//  Pages
	MainPage mainPage;
	AuthenticationPage authenticationPage;
	AccountPage accountPage;
	AddressesPage addressesPage;
	AddNewAddressPage addNewAddressPage;
	PersonalInfoPage personalInfoPage;
	WishlistPage wishlistPage;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.mainPage = new MainPage(driver);
		this.authenticationPage = new AuthenticationPage(driver);
		this.excelReader = new ExcelReader("data/seleniumProject.xlsx");
		this.accountPage = new AccountPage(driver);
		this.addressesPage = new AddressesPage(driver);
		this.addNewAddressPage = new AddNewAddressPage(driver);
		this.personalInfoPage = new PersonalInfoPage(driver);
		this.wishlistPage = new WishlistPage(driver);
		driver.manage().window().maximize();
	}
    
	@AfterClass
	public void afterClass() throws IOException {
		driver.close();
		excelReader.fis.close();
    }  
    
    public void login() throws InterruptedException {
    	mainPage.clickSignInButton();
    	String email = excelReader.getData("validCredentials", 5, 5);
		String password = excelReader.getData("validCredentials", 6, 5);
    	authenticationPage.getInputEmail().sendKeys(email);
    	authenticationPage.getInputPassword().sendKeys(password);
    	authenticationPage.clickGreenSignIn();
    	Thread.sleep(2000);
    }
}

