package test;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.Login;
import utils.ReadFiles;

/**
 * LoginValidationWithYaml is a data-driven TestNG test class that performs login validations
 * using credentials loaded from an external YAML file (`user.yaml`).
 * 
 * This class extends {@link BaseTest} to utilize WebDriver setup and teardown logic.
 * It reads test data before the test execution begins and uses it for login validations.
 *
 * Author: ramesh
 */
public class LoginValidationWithYaml extends BaseTest {

    /** Holds parsed YAML data as a map of user credentials. */
    private HashMap<String, Object> map;

    /**
     * Loads user credentials from a YAML file before any test methods run.
     * 
     * Uses {@link ReadFiles#readYamlFile(String)} to parse `user.yaml` and stores
     * the data in a map for later use in test methods.
     */
    @BeforeClass
    public void beforeClass() {
        ReadFiles obj = new ReadFiles();
        map = obj.readYamlFile("user.yaml");
    }

    /**
     * Validates login using the credentials of user1 (e.g., Dan).
     * 
     * Extracts the username and password from the YAML map under key "user1"
     * and performs a login using the {@link Login} page object.
     */
    @Test
    public void danUserValidation() {
        HashMap<String, String> danUser = (HashMap<String, String>) map.get("user1");
        String username = danUser.get("username");
        String password = danUser.get("password");

        Login login = new Login(driver);
        login.loginWithCredentials(username, password);
    }

    /**
     * Validates login using the credentials of user2 (e.g., John).
     * 
     * Extracts the username and password from the YAML map under key "user2"
     * and performs a login using the {@link Login} page object.
     */
    @Test
    public void johnUserValidation() {
        HashMap<String, String> johnUser = (HashMap<String, String>) map.get("user2");
        String username = johnUser.get("username");
        String password = johnUser.get("password");

        Login login = new Login(driver);
        login.loginWithCredentials(username, password);
    }
}
