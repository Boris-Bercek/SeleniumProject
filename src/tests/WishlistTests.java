package tests;

import static org.testng.Assert.assertTrue;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishlistTests extends BaseTest {
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@Test(priority = 0)
	public void RemoveWishListIfExist() throws InterruptedException{
		login();
		accountPage.clickMyWishlist();
		while(isTableDisplayed() == true)
		{
			wishlistPage.deleteWishlist();
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
		}
			
		Assert.assertEquals(wishlistPage.getNumberOfWishlists(), 0);
		assertTrue(isTableDisplayed() == false);	
	}
	
	@Test(priority = 1)
	public void addWishlist() throws InterruptedException {
		String summerWishList = excelReader.getData("addWishlist", 9, 5);

		login();
		accountPage.clickMyWishlist();
		addWishList(summerWishList);
		Assert.assertEquals(wishlistPage.getAssertSummerWishlist().getText(), summerWishList);
	}

	@Test(priority = 3)
	public void addMultipleWishlists() throws InterruptedException {
		String winterWishList = excelReader.getData("addMultipleWishlists", 11, 5);
		String springWishList = excelReader.getData("addMultipleWishlists", 13, 5);

		login();
		accountPage.clickMyWishlist();
		addWishList(winterWishList);
		Thread.sleep(2000);
		addWishList(springWishList);
		Thread.sleep(2000);
		Assert.assertEquals(wishlistPage.getAssertWinterWishlist().getText(), winterWishList);
		Assert.assertEquals(wishlistPage.getAssertSpringWishlist().getText(), springWishList);
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void removeWishList() throws InterruptedException {
		login();
		accountPage.clickMyWishlist();
		String summer = excelReader.getData("addMultipleWishlists", 9, 5);
		deleteWishlist(summer);
	}

	@Test(priority = 9)
	public void removeAllWishLists() throws InterruptedException {
		login();
		accountPage.clickMyWishlist();
		while(isTableDisplayed() == true)
		{
			wishlistPage.deleteWishlist();
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
		}
		
		Assert.assertEquals(wishlistPage.getNumberOfWishlists(), 0);
		assertTrue(isTableDisplayed() == false);
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	public void addWishList(String name) throws InterruptedException {
		wishlistPage.inputWishlist(name);
		wishlistPage.clickSaveButton();
	}

	public void deleteWishlist(String wishlistName) throws InterruptedException {
		int numberOfWishlistsBefore = wishlistPage.getNumberOfWishlists();
		wishlistPage.clickDeletebutton(wishlistName);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.navigate().refresh();
		int numberOfWishlistsAfter = wishlistPage.getNumberOfWishlists();
		Assert.assertTrue(numberOfWishlistsBefore > numberOfWishlistsAfter);
	}

	public boolean isTableDisplayed() {
		try {
			wishlistPage.getWishlistTable();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
}
