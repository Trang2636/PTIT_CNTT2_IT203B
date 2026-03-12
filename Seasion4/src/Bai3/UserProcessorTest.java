package Bai3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserProcessorTest {

    private UserProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new UserProcessor();
    }

    @Test
    void shouldReturnValidEmailWhenFormatCorrect() {

        // Arrange
        String email = "user@gmail.com";

        // Act
        String result = processor.processEmail(email);

        // Assert
        assertEquals("user@gmail.com", result);
    }

    @Test
    void shouldThrowExceptionWhenEmailMissingAtSymbol() {

        // Arrange
        String email = "usergmail.com";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }

    @Test
    void shouldThrowExceptionWhenDomainMissing() {

        // Arrange
        String email = "user@";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }

    @Test
    void shouldNormalizeEmailToLowercase() {

        // Arrange
        String email = "Example@Gmail.com";

        // Act
        String result = processor.processEmail(email);

        // Assert
        assertEquals("example@gmail.com", result);
    }
}
