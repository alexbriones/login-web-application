package Domain.Model.User;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordTest {

    @Test
    public void passwordShouldBeEncryptedWhenIsConstructed() {
        assertNotEquals(new Password("password"), "password");
    }

    @Test
    public void twoPasswordAreEqualsIfAfterEncryptationAreEquals() {
        Password password = new Password("password");

        assertTrue(password.equals("password"));
    }
}