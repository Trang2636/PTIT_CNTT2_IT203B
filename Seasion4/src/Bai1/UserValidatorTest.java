package Bai1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    UserValidator validator = new UserValidator();

    @Test
    void testValidUsername() {

        // Arrange
        String username = "user123";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertTrue(result);
    }

    @Test
    void testUsernameTooShort() {

        // Arrange
        String username = "abc";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertFalse(result);
    }

    @Test
    void testUsernameContainsSpace() {

        // Arrange
        String username = "user name";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertFalse(result);
    }
}
