package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistPage {

	WebDriver driver;

	public WishlistPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getInputWishlist() {
		return driver.findElement(By.id("name"));
	}

	public void inputWishlist(String wishlist1) {
		this.getInputWishlist().sendKeys(wishlist1);
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}

	public void clickSaveButton() {
		this.getSaveButton().click();
	}

	public WebElement getAssertSummerWishlist() {
		return driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a"));
	}

	public WebElement getAssertWinterWishlist() {
		return driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr[3]/td[1]/a"));
	}

	public WebElement getAssertSpringWishlist() {
		return driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a"));
	}

	public WebElement getRemoveWishlist() {
		return driver.findElement(
				By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr[1]/td[6]/a/i"));
	}

	public void deleteWishlist() {
		this.getRemoveWishlist().click();
	}

	public WebElement getWishlistTable() {
		return driver.findElement(By.xpath("//*[@id=\"block-history\"]/table"));
	}

	private By wishlists = By.xpath("//tr[starts-with(@id ,'wishlist')]");

	public int getNumberOfWishlists() {
		List<WebElement> allWishlists = (List<WebElement>) driver.findElements(wishlists);
		return allWishlists.size();
	}

	public WishlistPage clickDeletebutton(String wishlistName) {
		driver.findElement(By.xpath("//a[contains(text(), \"" + wishlistName
				+ "\")]/parent::td//following-sibling::*//following-sibling::*//following-sibling::*//following-sibling::*//following-sibling::*//a"))
				.click();
		return this;
	}
}
