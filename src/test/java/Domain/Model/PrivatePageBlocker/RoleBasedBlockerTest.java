package Domain.Model.PrivatePageBlocker;

import Domain.Model.User.Password;
import Domain.Model.User.Role;
import Domain.Model.User.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class RoleBasedBlockerTest {

    RoleBasedBlocker roleBasedBlocker;

    @Test
    public void userCanNotAccessPageWhenNoHaveTheCorrectRole() {
        User user = new User("user_test", new Password("test"), new HashSet<>((Arrays.asList((Role.PAGE_1)))));
        roleBasedBlocker = new RoleBasedBlocker(user);
        assertFalse(this.roleBasedBlocker.hasPrivilegesToAccessPage(Role.PAGE_2.toString()));
    }

    @Test
    public void userCanAccessPageWhenHaveTheCorrectRole() {
        User user = new User("user_test", new Password("test"), new HashSet<>((Arrays.asList((Role.PAGE_1)))));
        roleBasedBlocker = new RoleBasedBlocker(user);
        assertTrue(this.roleBasedBlocker.hasPrivilegesToAccessPage(Role.PAGE_1.toString()));
    }
}