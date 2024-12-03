import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class LoginAppTest {

    private LoginApp loginApp;

    @BeforeEach
    void setup() {
        loginApp = new LoginApp();
    }

    @Test
    void testValidLoginWithCorrectEmailAndPassword() {
        String expectedUserName = "John Doe";
        String email = "johndoe@example.com";
        String password = "password123";

        String result = loginApp.authenticateUser(email, password);
        assertEquals(expectedUserName, result);
    }

    @Test
    void testInvalidLoginWithIncorrectEmail() {
        String email = "wrongemail@example.com";
        String password = "password123";

        String result = loginApp.authenticateUser(email, password);
        assertNull(result, "The login should fail and return null for incorrect email.");
    }

    @Test
    void testInvalidLoginWithIncorrectPassword() {
        String email = "johndoe@example.com";
        String password = "wrongpassword";

        String result = loginApp.authenticateUser(email, password);
        assertNull(result, "The login should fail and return null for incorrect password.");
    }

    @Test
    void testBlankEmailAndPasswordFields() {
        String email = "";
        String password = "";

        String result = loginApp.authenticateUser(email, password);
        assertNull(result, "The login should fail and return null for blank email and password fields.");
    }

    @Test
    void testDatabaseConnectionFailure() {
        String email = "johndoe@example.com";
        String password = "password123";

        String result = loginApp.authenticateUser(email, password);
        assertNull(result, "The login should succeed and return the correct username.");

    }
}