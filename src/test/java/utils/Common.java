package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The {@code Common} class provides utility methods for initializing and managing
 * Selenium WebDriver browser instances.
 * <p>
 * Supported browsers include:
 * <ul>
 *     <li>Chrome</li>
 *     <li>Firefox</li>
 *     <li>Edge</li>
 * </ul>
 * <p>
 * This class simplifies browser setup, navigation, and shutdown for automation scripts.
 * 
 * @author ramesh
 */
public class Common {
    
    /**
     * The WebDriver instance used for interacting with the browser.
     */
    private WebDriver driver;

    /**
     * Launches the specified browser and navigates to the provided URL.
     * <p>
     * Supported browser types (case-insensitive): {@code "chrome"}, {@code "firefox"}, {@code "edge"}.
     * <p>
     * If the provided URL is blank or empty, the browser will open with {@code about:blank}.
     * <p>
     * If an unsupported browser is specified, the test will print an error message and terminate execution.
     *
     * @param browser the name of the browser to launch (e.g., "chrome", "firefox", "edge")
     * @param url the URL to open in the browser
     */
    public void setupBrowser(String browser, String url) {
        // open the browser
        if (browser.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else if (browser.equalsIgnoreCase("edge"))
            driver = new EdgeDriver();
        else {
            System.out.println("valid browser is not provided, hence quitting the automation run");
            System.exit(0);
        }

        // open the url
        if (!url.isBlank())
            driver.get(url);
        else
            driver.get("about:blank");
    }

    /**
     * Returns the current {@link WebDriver} instance.
     * 
     * @return the active WebDriver instance
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Closes all browser windows and ends the WebDriver session.
     * <p>
     * Recommended to call this method at the end of a test to free up resources.
     */
    public void quitBrowser() {
        driver.quit();
    }

    /**
     * Closes the current browser tab or window.
     * <p>
     * Does not end the WebDriver session if other tabs/windows remain open.
     */
    public void closeTab() {
        driver.close();
    }

}
