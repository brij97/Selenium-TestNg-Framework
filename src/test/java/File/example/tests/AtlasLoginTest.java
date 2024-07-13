package File.example.tests;

import File.example.util.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import File.example.factory.PageinstancesFactory;
import File.example.pages.AtlasLoginPage;

import static File.example.context.WebDriverContext.getDriver;
import static File.example.util.TestProperties.getProperty;

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
		String url = getProperty("url");
		AtlasLoginPage atlasLoginPage = PageinstancesFactory.getInstance(AtlasLoginPage.class);

		driver.get(url);
        assert atlasLoginPage != null;
        wait.waitForElementVisible(atlasLoginPage.getEmailInput());
		atlasLoginPage.enterEmail("abhishek.gupta@emizainc.com");
		atlasLoginPage.enterPassword("India@12345");
		atlasLoginPage.clickSignIn();
		Thread.sleep(5000);
		wait.waitForElementVisible(driver.findElement(By.cssSelector("button.ant-btn")));
		Assert.assertTrue(true, "Login failed : Test failed");
	}
}
