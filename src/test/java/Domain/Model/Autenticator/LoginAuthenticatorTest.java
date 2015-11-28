package Domain.Model.Autenticator;

import Domain.Model.User.Exceptions.UserNotExistsException;
import Domain.Model.User.Password;
import Domain.Respositories.User.UserRepositoryInMemory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginAuthenticatorTest {

    private LoginAuthenticator loginAuthenticator;
    private UserRepositoryInMemory userRepositoryInMemory;

    @Before
    public void setUp() {
        userRepositoryInMemory = new UserRepositoryInMemory();
        loginAuthenticator = new LoginAuthenticator(userRepositoryInMemory);
    }


    @Test
    public void authenticationShouldBeFalseIfUserNotExists() {
        String userNotExists = "no_one";
        String password = "";

        assertFalse(loginAuthenticator.authenticate(userNotExists , password));
    }


    @Test
    public void authenticationShouldBeTrueIfExistsUserWithThisCredentials() {
        String userName = "user_one";
        String rightPassword = "one";

        assertTrue(loginAuthenticator.authenticate(userName, rightPassword));
    }

    @Test
    public void authenticationShouldBeFalseIfNotExistsUserWithThisCredentials() {
        String userName = "user_one";
        String wrongPassword = "wrong_password";

        assertFalse(loginAuthenticator.authenticate(userName, wrongPassword));
    }

    @Test
    public void passwordIsCorrectWhenIsEqualsToTheOneLocatedInRepository() throws UserNotExistsException {
        Password passwordInRepository = userRepositoryInMemory.findUserByUserName("user_one").getPassword();
        Password password = new Password("one");
        assertArrayEquals(passwordInRepository.getPasswordEncryted(), password.getPasswordEncryted());
    }

    @Test
    public void passwordIsWrongWhenIsDifferentToTheOneLocatedInRepository() throws UserNotExistsException {
        Password passwordInRepository = userRepositoryInMemory.findUserByUserName("user_one").getPassword();
        Password wrongPassword = new Password("xxxxxxx");

        assertNotEquals(passwordInRepository, wrongPassword);
    }
}