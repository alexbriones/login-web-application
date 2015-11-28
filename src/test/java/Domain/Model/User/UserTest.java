package Domain.Model.User;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class UserTest {

    @Test
    public void userShouldHaveTheSameRoleAfterCreation() {
        User user = new User("user_name", new Password("password"), new HashSet<>((Arrays.asList((Role.PAGE_1)))));
        assertTrue(user.hasRole(Role.PAGE_1));
    }

    @Test
    public void userShouldNotHaveOneRoleThatItsNotInCreation(){
        User user = new User("user_name", new Password("password"), new HashSet<>((Arrays.asList((Role.PAGE_1)))));
        assertFalse(user.hasRole(Role.PAGE_2));
    }
}