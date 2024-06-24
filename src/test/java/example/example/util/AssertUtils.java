package example.example.util;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * The Class is responsible for Webelement Assertion
 *
 * @autor Brijesh
 */

public class AssertUtils {


    public static void assertElementIsDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "Element is not displayed: " + element);
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }


    public static void assertNotEquals(Object actual, Object expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    public static void assertElementTextContains(WebElement element, String expectedText) {
        String actualText = element.getText();
        Assert.assertTrue(actualText.contains(expectedText),
                "Expected text to be present: '" + expectedText + "' but was: '" + actualText + "'");
    }

    public static void assertElementAttributeContains(WebElement element, String attribute, String expectedValue) {
        String actualValue = element.getAttribute(attribute);
        Assert.assertTrue(actualValue.contains(expectedValue),
                "Expected attribute '" + attribute + "' to contain: '" + expectedValue + "' but was: '" + actualValue + "'");
    }

}
