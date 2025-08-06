package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.Common;

/**
 * BaseTest class for setting up and tearing down the WebDriver environment.
 * 
 * This class is intended to be extended by other test classes. It initializes the
 * WebDriver based on provided parameters (browser and URL) and ensures the driver
 * is properly closed after test execution.
 * 
 * Uses TestNG annotations for pre- and post-test operations.
 * 
 * Author: ramesh
 */
public class BaseTest {

    /** Utility class for common WebDriver operations. */
    public Common common;

    /** Static WebDriver instance shared across test classes. */
    public static WebDriver driver;

    /**
     * Setup method to initialize the browser and open the specified URL.
     * This method runs before any test methods in the test class.
     *
     * @param browser The name of the browser to launch (e.g., "chrome", "firefox").
     * @param url The URL to navigate to after browser launch.
     */
    @Parameters({"browser", "url"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        common = new Common();
        common.setupBrowser(browser, url);
        driver = common.getDriver();
    }

    /**
     * Teardown method to quit the WebDriver instance.
     * This method runs after all test methods in the test class have finished execution.
     */
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
