import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

public class LoginAppTest {

    private LoginApp loginApp;

    @BeforeEach
    void setup() {
        loginApp = new LoginApp();
    }

    @Test
    void testValidLoginWithCorrectEmailAndPassword() {
        // Replace with actual test values that exist in your database
        String expectedUserName = "John Doe";
        String email = "johndoe@example.com";
        String password = "password123";

        String result = loginApp.authenticateUser(email, password);
        assertEquals(expectedUserName, result, "Valid login should return the correct username.");
    }

    @Test
    void testInvalidLoginWithIncorrectEmail() {
        String email = "wrongemail@example.com";
        String password = "password123";

        String result = loginApp.authenticateUser(email, password);
        assertNull(result, "Login with an incorrect email should return null.");
    }

    @Test
    void testInvalidLoginWithIncorrectPassword() {
        String email = "johndoe@example.com";
        String password = "wrongpassword";

        String result = loginApp.authenticateUser(email, password);
        assertNull(result, "Login with an incorrect password should return null.");
    }

    @Test
    void testBlankEmailAndPasswordFields() {
        String email = "";
        String password = "";

        String result = loginApp.authenticateUser(email, password);
        assertNull(result, "Login with blank email and password should return null.");
    }
}
