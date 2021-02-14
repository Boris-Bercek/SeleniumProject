package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalInfoTest extends BaseTest {
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
}
	@Test
	public void editPersonalInfo() throws InterruptedException {		
		String firstname = excelReader.getData("editPersonalInfo", 9, 5);
		String lastname = excelReader.getData("editPersonalInfo", 10, 5);
		String email = excelReader.getData("editPersonalInfo", 11, 5);
		String password = excelReader.getData("editPersonalInfo", 12, 5);
		String newpass = excelReader.getData("editPersonalInfo", 13, 5);
		String confirmpass = excelReader.getData("editPersonalInfo", 14, 5);
		String accountName = firstname.concat(" ").concat(lastname);
		
		login();
		accountPage.clickMyPersonalInfo();
        personalInfoPage.clickMrs();
		personalInfoPage.updateFirstName(firstname);
		personalInfoPage.updateLastName(lastname);
		personalInfoPage.updateEmailField(email);
        personalInfoPage.setDayBirth(28);
		personalInfoPage.setMonthBirth(9);
		personalInfoPage.setYearBirth(1993);
	    personalInfoPage.enterCurrentPass(password);
		personalInfoPage.enterNewPassword(newpass);
		personalInfoPage.enterConfirmationPass(confirmpass);

		personalInfoPage.clickSaveButton();
		Thread.sleep(2000);
		Assert.assertTrue(personalInfoPage.getPersonalInfo().isDisplayed());
		Assert.assertTrue(personalInfoPage.getPersonalInfo().getText().equals("Your personal information has been successfully updated."));
		Assert.assertEquals(accountPage.getMyAccountName().getText(), accountName);
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().back();
		accountPage.clickMyPersonalInfo();
	
        returnToPreviousInfo();
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	public void returnToPreviousInfo() throws InterruptedException{
		    personalInfoPage.clickMr();
		    personalInfoPage.updateFirstName("Boris");
			personalInfoPage.updateLastName("Bercek");
		    personalInfoPage.updateEmailField("bercekboris@gmail.com");
			personalInfoPage.setDayBirth(4);
			personalInfoPage.setMonthBirth(5);
			personalInfoPage.setYearBirth(1996);
			personalInfoPage.enterCurrentPass("projekat123");
			personalInfoPage.enterNewPassword("projekat");
			personalInfoPage.enterConfirmationPass("projekat");
			personalInfoPage.clickSaveButton();
			Thread.sleep(2000);
			Assert.assertTrue(personalInfoPage.getPersonalInfo().isDisplayed());
	}
}
