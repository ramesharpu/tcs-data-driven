package test;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.Login;

/**
 * LoginValidation is a TestNG test class that performs functional and UI validations
 * on the Facebook login page. It extends {@link BaseTest} to inherit WebDriver setup and teardown.
 *
 * This test class covers:
 * <ul>
 *     <li>Validation of welcome message</li>
 *     <li>Email and password field placeholders</li>
 *     <li>Login button text</li>
 *     <li>Various login credential combinations (positive and negative test cases)</li>
 * </ul>
 *
 * Author: ramesh
 */
public class LoginValidation extends BaseTest {

    /**
     * Verifies the welcome message displayed on the login page.
     */
    @Test
    public void welcomeMessageValdiation() {
        String expectedResult = "Facebook helps you connect and share with the people in your life.";

        Login login = new Login(driver);
        String actualResult = login.getWelcomeMessage();

        Reporter.log("Expected Result  = " + expectedResult);
        Reporter.log("Actual Result = " + actualResult);

        assertTrue(actualResult.equals(expectedResult), "Mismatch in the welcome message,");
    }

    /**
     * Verifies the placeholder text in the email/username input field.
     */
    @Test
    public void emailPlaceholderValdiation() {
        String expectedResult = "Email address or phone number";

        Login login = new Login(driver);
        String actualResult = login.getEmailPlaceholder();

        Reporter.log("Expected Result  = " + expectedResult);
        Reporter.log("Actual Result = " + actualResult);

        assertTrue(actualResult.equals(expectedResult), "Mismatch in the email placeholder,");
    }

    /**
     * Verifies the placeholder text in the password input field.
     */
    @Test
    public void passwordPlaceholderValdiation() {
        String expectedResult = "Password";

        Login login = new Login(driver);
        String actualResult = login.getPasswordPlaceholder();

        Reporter.log("Expected Result  = " + expectedResult);
        Reporter.log("Actual Result = " + actualResult);

        assertTrue(actualResult.equals(expectedResult), "Mismatch in the password placeholder,");
    }

    /**
     * Verifies the text displayed on the login button.
     */
    @Test
    public void loginButtonTextValdiation() {
        String expectedResult = "Log in";

        Login login = new Login(driver);
        String actualResult = login.getloginButtonText();

        Reporter.log("Expected Result  = " + expectedResult);
        Reporter.log("Actual Result = " + actualResult);

        assertTrue(actualResult.equals(expectedResult), "Mismatch in the login button text,");
    }

    /**
     * Tests login with valid username and valid password.
     *
     * @param username Valid username
     * @param password Valid password
     */
    @Parameters({"validUsername", "validPassword"})
    @Test
    public void validUsernameValidPasswordTest(String username, String password) {
        Login login = new Login(driver);
        login.loginWithCredentials(username, password);
    }

    /**
     * Tests login with valid username and invalid password.
     *
     * @param username Valid username
     * @param password Invalid password
     */
    @Parameters({"validUsername", "invalidPassword"})
    @Test
    public void validUsernameInvalidPasswordTest(String username, String password) {
        Login login = new Login(driver);
        login.loginWithCredentials(username, password);
    }

    /**
     * Tests login with invalid username and valid password.
     *
     * @param username Invalid username
     * @param password Valid password
     */
    @Parameters({"invalidUsername", "validPassword"})
    @Test
    public void invalidUsernameValidPasswordTest(String username, String password) {
        Login login = new Login(driver);
        login.loginWithCredentials(username, password);
    }

    /**
     * Tests login with invalid username and invalid password.
     *
     * @param username Invalid username
     * @param password Invalid password
     */
    @Parameters({"invalidUsername", "invalidPassword"})
    @Test
    public void invalidUsernameInvalidPasswordTest(String username, String password) {
        Login login = new Login(driver);
        login.loginWithCredentials(username, password);
    }

    /**
     * Tests login with blank username and valid password.
     *
     * @param password Valid password
     */
    @Parameters({"validPassword"})
    @Test
    public void blankUsernameValidPasswordTest(String password) {
        String username = "";
        Login login = new Login(driver);
        login.loginWithCredentials(username, password);
    }

    /**
     * Tests login with valid username and blank password.
     *
     * @param username Valid username
     */
    @Parameters({"validUsername"})
    @Test
    public void validUsernameBlankPasswordTest(String username) {
        String password = "";
        Login login = new Login(driver);
        login.loginWithCredentials(username, password);
    }

    /**
     * Tests login with both username and password fields blank.
     */
    @Test
    public void blankUsernameBlankPasswordTest() {
        String username = "";
        String password = "";
        Login login = new Login(driver);
        login.loginWithCredentials(username, password);
    }
}
