package Bai5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccessControlServiceTest {

    private AccessControlService service = new AccessControlService();

    private User admin;
    private User moderator;
    private User user;

    @Test
    void testAdminPermissions() {

        admin = new User(Role.ADMIN);

        assertAll(
                () -> assertTrue(service.canPerformAction(admin, Action.DELETE_USER)),
                () -> assertTrue(service.canPerformAction(admin, Action.LOCK_USER)),
                () -> assertTrue(service.canPerformAction(admin, Action.VIEW_PROFILE))
        );
    }

    @Test
    void testModeratorPermissions() {

        moderator = new User(Role.MODERATOR);

        assertAll(
                () -> assertFalse(service.canPerformAction(moderator, Action.DELETE_USER)),
                () -> assertTrue(service.canPerformAction(moderator, Action.LOCK_USER)),
                () -> assertTrue(service.canPerformAction(moderator, Action.VIEW_PROFILE))
        );
    }

    @Test
    void testUserPermissions() {

        user = new User(Role.USER);

        assertAll(
                () -> assertFalse(service.canPerformAction(user, Action.DELETE_USER)),
                () -> assertFalse(service.canPerformAction(user, Action.LOCK_USER)),
                () -> assertTrue(service.canPerformAction(user, Action.VIEW_PROFILE))
        );
    }

    @AfterEach
    void cleanUp() {
        admin = null;
        moderator = null;
        user = null;
    }
}
