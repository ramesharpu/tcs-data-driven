package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * Page Object Model class representing the login page.
 * This class uses Selenium PageFactory to initialize web elements and provides
 * methods to interact with the login page, including entering credentials and clicking the login button.
 * 
 * Assumes the use of TestNG for logging purposes via Reporter.
 * 
 * Author: ramesh
 */
public class Login {

	private WebDriver driver;

	@CacheLookup
	@FindBy(className = "_8eso")
	WebElement welMsg;

	@CacheLookup
	@FindBy(id = "email")
	WebElement email;

	@CacheLookup
	@FindBy(id = "pass")
	WebElement passwd;

	@CacheLookup
	@FindBy(tagName = "button")
	WebElement loginBtn;

	@CacheLookup
	@FindBy(partialLinkText = "Forgotten password?")
	WebElement forgotPasswordLink;

	/**
	 * Constructor for Login class.
	 * Initializes WebElements using PageFactory.
	 *
	 * @param driver WebDriver instance passed from the test class.
	 */
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/**
	 * Retrieves the welcome message text displayed on the login page.
	 *
	 * @return Welcome message as a String.
	 */
	public String getWelcomeMessage() {
		return welMsg.getText();
	}

	/**
	 * Retrieves the placeholder text of the email/username input field.
	 *
	 * @return Email input placeholder as a String.
	 */
	public String getEmailPlaceholder() {
		return email.getDomAttribute("placeholder");
	}

	/**
	 * Retrieves the placeholder text of the password input field.
	 *
	 * @return Password input placeholder as a String.
	 */
	public String getPasswordPlaceholder() {
		return passwd.getDomAttribute("placeholder");
	}

	/**
	 * Retrieves the text displayed on the login button.
	 *
	 * @return Login button text as a String.
	 */
	public String getloginButtonText() {
		return loginBtn.getText();
	}

	/**
	 * Clears and enters the provided email or username into the corresponding field.
	 * Logs the username to the TestNG Reporter.
	 *
	 * @param username Email or username to be entered.
	 */
	public void enterEmailOrUsername(String username) {
		Reporter.log("Username = " + username);
		email.clear();
		email.sendKeys(username);
	}

	/**
	 * Clears and enters the provided password into the password field.
	 * Logs the password to the TestNG Reporter.
	 *
	 * @param password Password to be entered.
	 */
	public void enterPassword(String password) {
		Reporter.log("Password = " + password);
		passwd.clear();
		passwd.sendKeys(password);
	}

	/**
	 * Clicks on the login button to attempt login.
	 */
	public void clickLoginBtn() {
		loginBtn.click();
	}

	/**
	 * Performs the login operation by entering username and password.
	 * Note: Does not click the login button; that line is commented.
	 *
	 * @param username Email or username to be entered.
	 * @param password Password to be entered.
	 */
	public void loginWithCredentials(String username, String password) {
		enterEmailOrUsername(username);
		enterPassword(password);
//		clickLoginBtn();		
	}
}
