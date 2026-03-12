package Bai2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    UserService userService = new UserService();

    @Test
    void testAge18ShouldBeValid() {

        // Arrange
        int age = 18;

        // Act
        boolean result = userService.checkRegistrationAge(age);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void testAge17ShouldBeInvalid() {

        // Arrange
        int age = 17;

        // Act
        boolean result = userService.checkRegistrationAge(age);

        // Assert
        assertEquals(false, result);
    }

    @Test
    void testNegativeAgeShouldThrowException() {

        // Arrange
        int age = -1;

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            userService.checkRegistrationAge(age);
        });
    }
}
