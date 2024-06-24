package example.example.tests;

import com.aventstack.extentreports.ExtentReports;
import example.example.util.ActionUtil;
import example.example.util.TestProperties;
import example.example.util.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import example.example.factory.PageinstancesFactory;
import example.example.pages.AtlasLoginPage;

import static example.example.context.WebDriverContext.getDriver;

/**
 * The Class atlasloginTest.
 *
 * @author Brijesh
 */
@Test(testName = "Atlas login test", description = "Atlas login test")
public class AtlasLoginTest extends BaseTest {
  //  private static WaitUtil wait;


	@Test
	public void atlasLoginTest() throws InterruptedException {
		WebDriver driver = getDriver();
		WaitUtil wait = new WaitUtil(driver);
	//	String url = TestProperti es.getProperty("url");
		AtlasLoginPage atlasLoginPage = PageinstancesFactory.getInstance(AtlasLoginPage.class);

		driver.get("https://google.com/");
        assert atlasLoginPage != null;
        wait.waitForElementVisible(atlasLoginPage.getEmailInput());
		atlasLoginPage.enterEmail("brijesh@gmail.com");
		atlasLoginPage.enterPassword("India@12345");
		atlasLoginPage.clickSignIn();
		Thread.sleep(5000);
		wait.waitForElementVisible(driver.findElement(By.cssSelector("button.ant-btn")));
		Assert.assertTrue(true, "Login failed : Test failed");
	}
}
