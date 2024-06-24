package example.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AtlasLoginPage extends BasePage {


	/** The email input. */
	@FindBy(id = "basic_email")
	private WebElement emailInput;

	/** The pass. */
	@FindBy(id = "basic_password")
	private WebElement pass;

	/**
//	 * Instantiates a new atlas login page.
//	 *
//	 * @param driver the driver
//	 *
//	 */
	public AtlasLoginPage(WebDriver driver) {
		super(driver);

    }

	/**
	 * Enter email.
	 *
	 * @param email the email
	 * @return the atlas login page
	 */
	public AtlasLoginPage enterEmail(String email) {
		emailInput.sendKeys(email);
		return this;
	}

	/**
	 * Enter password.
	 *
	 * @param password the password
	 * @return the atlas login page
	 */
	public AtlasLoginPage enterPassword(String password) {
		pass.sendKeys(password);
		return this;
	}

	public void clickSignIn() {
		pass.submit();
	}

	public WebElement getEmailInput() {
		return emailInput;
	}

	public WebElement getPass(){
		return pass;
	}
}
