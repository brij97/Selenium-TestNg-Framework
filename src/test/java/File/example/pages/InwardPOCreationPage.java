package File.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InwardPOCreationPage extends BasePage{


    @FindBy(xpath = "//span[text()='Inward']")
    private WebElement inwardText;

    @FindBy(xpath = "//span[text()='Purchase Order']")
    private WebElement purchaseOrderLabel;

    @FindBy(xpath = "//*[text()='Create PO']")
    private WebElement createPOButton;

    @FindBy(id = "seller_name")
    private WebElement inwardSellerName;

    @FindBy(id = "vendor_name")
    private WebElement inwardVendorName;

    @FindBy(id = "expected_delivery_date")
    private WebElement inwardExpectedDate;

    @FindBy(xpath = "//*[text()='Proceed to Add Items']")
    private WebElement poAddButton;

    @FindBy(xpath = "//*[text()='Yes']")
    private WebElement popUpConfirmation;

    @FindBy(xpath = "//a[text()='Today']")
    private WebElement todayDate;

    /**
     * Instantiates a new base page.
     *
     * @param driver the driver
     */
    public InwardPOCreationPage(WebDriver driver) {
        super(driver);
    }

    public void clickInward(){
        inwardText.click();
    }

    public WebElement getInwardText(){
        return inwardText;
    }

    public WebElement getTodaydate(){
        return  todayDate;
    }

    public WebElement getPurchaseOrderLabel(){
        return purchaseOrderLabel;
    }

    public WebElement getInwardSellerName(){
        return inwardSellerName;
    }

    public WebElement getInwardVendorName(){
        return inwardVendorName;
    }

    public WebElement getInwardExpectedDate(){
        return inwardExpectedDate;
    }

    public WebElement getPoAddButton() {
        return poAddButton;
    }

    public WebElement getCreatePOButton(){

        return  createPOButton;
    }

    public WebElement getPopUpConfirmation(){
        return popUpConfirmation;
    }
}
