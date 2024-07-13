package File.example.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OtherUtils {

        private WebDriver driver;
        private WebDriverWait wait;
        private Actions actions;

        public OtherUtils(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            this.actions = new Actions(driver);
        }

    public void performMouseHover(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public static String  getCurrentDate(String format) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return currentDate.format(formatter);
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void contextClickElement(WebElement element) {
        actions.contextClick(element).perform();
    }

    public void clickAndHoldElement(WebElement element) {
        actions.clickAndHold(element).perform();
    }

    public void doubleClickElement(WebElement element) {
        actions.doubleClick(element).perform();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollByOffset(int xOffset, int yOffset) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", xOffset, yOffset);
    }

}
