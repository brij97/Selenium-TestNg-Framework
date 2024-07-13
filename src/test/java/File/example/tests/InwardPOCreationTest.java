package File.example.tests;

import File.example.factory.PageinstancesFactory;
import File.example.pages.InwardPOCreationPage;
import File.example.util.AssertUtils;
import File.example.util.OtherUtils;
import File.example.util.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static File.example.context.WebDriverContext.getDriver;

@Test(testName = "Atlas inwardPOcreation test", description = "Atlas inwardPOcreation test")
public class InwardPOCreationTest extends BaseTest {
    private WebDriver driver;
  //  private WaitUtil wait;

    @Test
    public void inwardPOCreationTest() throws InterruptedException {


        WebDriver driver = getDriver();
        WaitUtil wait = new WaitUtil(driver);
        OtherUtils p = new OtherUtils(driver);
        AtlasLoginTest a = new AtlasLoginTest();
        a.atlasLoginTest();
        InwardPOCreationPage inwardPOCreationPage = PageinstancesFactory.getInstance(InwardPOCreationPage.class);
        assert inwardPOCreationPage != null;

        wait.waitForElementVisible(inwardPOCreationPage.getInwardText());
        inwardPOCreationPage.getInwardText().click();
        AssertUtils.assertElementIsDisplayed(inwardPOCreationPage.getInwardText());

        wait.waitForElementVisible(inwardPOCreationPage.getPurchaseOrderLabel());
        inwardPOCreationPage.getPurchaseOrderLabel().click();

        wait.waitForElementVisible(inwardPOCreationPage.getCreatePOButton());
        inwardPOCreationPage.getCreatePOButton().click();

        wait.waitForElementVisible(inwardPOCreationPage.getInwardSellerName());
        inwardPOCreationPage.getInwardSellerName().click();
        inwardPOCreationPage.getInwardSellerName().sendKeys("AARZOOFLIPKART");
        Thread.sleep(2000);
       // driver.findElement(By.cssSelector("div.ant-select-item-option-content"));
        inwardPOCreationPage.getInwardSellerName().sendKeys(Keys.RETURN);


        wait.waitForElementVisible(inwardPOCreationPage.getInwardVendorName());
        inwardPOCreationPage.getInwardVendorName().click();
        Thread.sleep(5000);
        inwardPOCreationPage.getInwardVendorName().sendKeys("XYZ1_AARZO");
        Thread.sleep(7000);
       /// wait.waitForElementVisible(driver.findElement(By.cssSelector("div.ant-select-item-option-content")));
        driver.findElement(By.cssSelector("div.ant-select-item-option-content"));
        inwardPOCreationPage.getInwardVendorName().sendKeys(Keys.RETURN);

        wait.waitForElementVisible(inwardPOCreationPage.getInwardExpectedDate());
        Thread.sleep(5000);
        inwardPOCreationPage.getInwardExpectedDate().click();
        Thread.sleep(5000);
        String currentDate = OtherUtils.getCurrentDate("dd-MM-yyyy");
        inwardPOCreationPage.getInwardExpectedDate().sendKeys(currentDate);
        Thread.sleep(2000);
        inwardPOCreationPage.getTodaydate().click();
       // inwardPOCreationPage.getInwardExpectedDate().sendKeys(Keys.RETURN);
        Thread.sleep(3000);

        wait.waitForElementVisible(inwardPOCreationPage.getPoAddButton());
        inwardPOCreationPage.getPoAddButton().click();
        Thread.sleep(3000);

        inwardPOCreationPage.getPopUpConfirmation().click();
        Thread.sleep(2000);
        p.performMouseHover(inwardPOCreationPage.getPoAddButton());
    }
}
