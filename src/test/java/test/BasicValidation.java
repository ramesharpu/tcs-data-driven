package test;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * BasicValidation is a TestNG test class that performs simple UI validations
 * on the Facebook login page. It extends {@link BaseTest} to inherit browser
 * setup and teardown functionality.
 * 
 * The validations include checking:
 * <ul>
 *   <li>Page title matches expected text</li>
 *   <li>Current URL is as expected</li>
 * </ul>
 * 
 * Logs expected and actual results using TestNG's {@link Reporter}.
 * 
 * Author: ramesh
 */
public class BasicValidation extends BaseTest {

    /**
     * Validates the title of the Facebook login page.
     * <p>
     * Compares the actual page title retrieved from WebDriver with the
     * expected hardcoded title. Fails the test with an assertion message
     * if there's a mismatch.
     */
    @Test
    public void titleValdiation() {
        String expectedResult = "Facebook – log in or sign up";
        String actualResult = driver.getTitle();
        
        Reporter.log("Expected Result  = " + expectedResult);
        Reporter.log("Actual Result = " + actualResult);
        
        assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title,");
    }

    /**
     * Validates the current URL of the Facebook login page.
     * <p>
     * Compares the actual URL retrieved from WebDriver with the
     * expected hardcoded URL. Fails the test with an assertion message
     * if there's a mismatch.
     */
    @Test
    public void urlValdiation() {
        String expectedResult = "https://www.facebook.com/";
        String actualResult = driver.getCurrentUrl();
        
        Reporter.log("Expected Result  = " + expectedResult);
        Reporter.log("Actual Result = " + actualResult);
        
        assertTrue(actualResult.equals(expectedResult), "Mismatch in the page URL,");
    }
}
