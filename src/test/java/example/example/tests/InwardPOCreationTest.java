package example.example.tests;

import example.example.factory.PageinstancesFactory;
import example.example.pages.InwardPOCreationPage;
import example.example.util.ActionUtil;
import example.example.util.AssertUtils;
import example.example.util.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static example.example.context.WebDriverContext.getDriver;

@Test(testName = "Atlas inwardPOcreation test", description = "Atlas inwardPOcreation test")
public class InwardPOCreationTest extends BaseTest {
//    private WebDriver driver;
//    private WaitUtil wait;

    @Test
    public void inwardPOCreationTest() throws InterruptedException {
        WebDriver driver = getDriver();
        WaitUtil wait = new WaitUtil(driver);
        AtlasLoginTest a = new AtlasLoginTest();
       // wait = new WaitUtil(driver);
        ActionUtil act = new ActionUtil(driver);
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
        driver.findElement(By.cssSelector("div.ant-select-item-option-content"));
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
        inwardPOCreationPage.getInwardExpectedDate().sendKeys("19-06-2024");
        Thread.sleep(5000);

        wait.waitForElementVisible(inwardPOCreationPage.getPoAddButton());
        inwardPOCreationPage.getPoAddButton().click();
        Thread.sleep(6000);


    }
}
