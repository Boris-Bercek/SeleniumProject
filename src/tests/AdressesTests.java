package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdressesTests extends BaseTest {

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}

	@Test(priority = 0)
	public void updateAddress() throws InterruptedException {
		login();
		accountPage.clickMyAddresses();
		Thread.sleep(1000);
		addressesPage.clickUpdateButton();
		Thread.sleep(2000);
		String newAddress = excelReader.getData("updateAddress", 10, 5);
		addressesPage.inputNewAddress(newAddress);
		addressesPage.clickSaveGreenButton();
		Thread.sleep(1000);
		excelReader.asserting("updateAddress", 10, 5, addressesPage.getNewAddressLabel().getText());

		restoreOriginalAddress();
	}

	@Test(priority = 3)
	public void addAddress() throws InterruptedException {
		login();
		accountPage.clickMyAddresses();
		Thread.sleep(1000);
		addressesPage.clickAddNewAddressButton();
		addNewAddressPage.addAddress(excelReader.getData("addAddress", 10, 5));
		addNewAddressPage.addCity(excelReader.getData("addAddress", 11, 5));
		addNewAddressPage.getState(4);
		addNewAddressPage.inputZipCode(excelReader.getData("addAddress", 13, 5));
		addNewAddressPage.inputHomePhone(excelReader.getData("addAddress", 14, 5));
		addNewAddressPage.inputAlias(excelReader.getData("addAddress", 15, 5));
		addNewAddressPage.clickSaveButton();
		Thread.sleep(2000);
		Assert.assertTrue(addNewAddressPage.getNewAddressSection().isDisplayed());
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void removeAddress() throws InterruptedException {
		login();
		accountPage.clickMyAddresses();
		Thread.sleep(2000);
		addressesPage.clickDeleteButtonOfAddedAddress();
		driver.switchTo().alert().accept();
		assertTrue(isNewAddressDisplayed() == false);
	}

	@Test(priority = 6)
	public void removeLastAddress() throws InterruptedException {
		login();
		accountPage.clickMyAddresses();
		Thread.sleep(2000);
		addressesPage.clickDeleteButton();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		Assert.assertTrue(addressesPage.noAddressesAvailableMassage().isDisplayed());
		Thread.sleep(2000);

		returnDeletedAddress();
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);

	}

	public void restoreOriginalAddress() throws InterruptedException {
		addressesPage.clickUpdateButton();
		Thread.sleep(2000);
		addressesPage.inputNewAddress("18735 Munchy Branch Road");
		addressesPage.clickSaveGreenButton();
		Thread.sleep(1000);
	}

	public void returnDeletedAddress() {
		addressesPage.clickAddNewAddressButton();
		addNewAddressPage.addAddress("18735 Munchy Branch Road");
		addNewAddressPage.addCity("Rehoboth Beach");
		addNewAddressPage.getState(8);
		addNewAddressPage.inputZipCode("19971");
		addNewAddressPage.inputHomePhone("3025694347");
		addNewAddressPage.inputAlias("bercekboris@gmail.com");
		addNewAddressPage.clickSaveButton();
	}
	
	public boolean isNewAddressDisplayed() {
	    try 
	    {
	    	addNewAddressPage.getNewAddressSection();
	        return true;
	    } 
	    catch (org.openqa.selenium.NoSuchElementException e) 
	    {
	        return false;
	    }
	}
}