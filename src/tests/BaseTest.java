package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AddNewAddressPage;
import pages.AuthenticationPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;


public class BaseTest {
	
	WebDriver driver;
	ExcelReader excelReader;
	MainPage mainPage;
	AuthenticationPage authenticationPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
	AddNewAddressPage addNewAddressPage;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.mainPage = new MainPage(driver);
		this.authenticationPage = new AuthenticationPage(driver);
		this.excelReader = new ExcelReader("data/seleniumProject.xlsx");
		this.myAccountPage = new MyAccountPage(driver);
		this.myAddressesPage = new MyAddressesPage(driver);
		this.addNewAddressPage = new AddNewAddressPage(driver);
		driver.manage().window().maximize();
	}
    @AfterClass
	public void afterClass() throws IOException {
		driver.close();
		excelReader.fis.close();
	}

}
