package example.example.util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * The Class is responsible for Action perform actions over webelement
 *
 * @autor Brijesh
 */

public class ActionUtil {

    private WebDriver driver;
    private final WebDriverWait wait;
    Actions actions = new Actions(driver);

    public ActionUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Scroll to a specific WebElement
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Scroll by a specific number of pixels
    public void scrollBy(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    // Scroll to the bottom of the page
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Scroll to the top of the page
    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }

    public void moveToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(element).perform();
    }

    public void selectFromDropdown(By locator, String visibleText) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visibleText);
    }

    public void switchToFrame(By locator) {
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.switchTo().frame(frame);
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }


    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.click(element).perform();
    }

    public void doubleClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.doubleClick(element).perform();
    }

    public void contextClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(element).perform();
    }

    public void clickAndHold(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.clickAndHold(element).perform();
    }

    public void release(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.release(element).perform();
    }

    public void dragAndDrop(By sourceLocator, By targetLocator) {
        WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
        actions.dragAndDrop(source, target).perform();
    }

    public void dragAndDropBy(By sourceLocator, int xOffset, int yOffset) {
        WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
        actions.dragAndDropBy(source, xOffset, yOffset).perform();
    }

    public void sendKeys(By locator, CharSequence... keys) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.sendKeys(element, keys).perform();
    }

    public void keyDown(Keys key) {
        actions.keyDown(key).perform();
    }

    public void keyUp(Keys key) {
        actions.keyUp(key).perform();
    }

    public void perform() {
        actions.perform();
    }

    public void build() {
        actions.build().perform();
    }


    // Methods related to Date Format
    public static String getCurrentDate(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.now().format(formatter);
    }

    // Method to get the current date and time as a string
    public static String getCurrentDateTime(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.now().format(formatter);
    }

    // Method to add days to the current date
    public static String addDaysToCurrentDate(int days, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.now().plusDays(days).format(formatter);
    }

    // Method to add days to a specific date
    public static String addDaysToDate(String date, int days, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date parsedDate = sdf.parse(date);
        long newTimeInMillis = parsedDate.getTime() + TimeUnit.DAYS.toMillis(days);
        return sdf.format(new Date(newTimeInMillis));
    }

    // Method to convert a date string from one format to another
    public static String convertDateFormat(String date, String oldFormat, String newFormat) throws ParseException {
        SimpleDateFormat oldFormatter = new SimpleDateFormat(oldFormat);
        SimpleDateFormat newFormatter = new SimpleDateFormat(newFormat);
        Date oldDate = oldFormatter.parse(date);
        return newFormatter.format(oldDate);
    }

    // Method to calculate the difference between two dates in days
    public static long getDifferenceInDays(String date1, String date2, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date startDate = sdf.parse(date1);
        Date endDate = sdf.parse(date2);
        long diffInMillis = endDate.getTime() - startDate.getTime();
        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }

    // Method to check if a date is in the past
    public static boolean isDateInPast(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date parsedDate = sdf.parse(date);
        return parsedDate.before(new Date());
    }

    // Method to check if a date is in the future
    public static boolean isDateInFuture(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date parsedDate = sdf.parse(date);
        return parsedDate.after(new Date());
    }
}
