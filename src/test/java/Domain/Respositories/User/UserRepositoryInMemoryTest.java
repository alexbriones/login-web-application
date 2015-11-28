package Domain.Respositories.User;

import Domain.Model.User.Exceptions.UserAlreadyExistsException;
import Domain.Model.User.Exceptions.UserNotExistsException;
import Domain.Model.User.Password;
import Domain.Model.User.Role;
import Domain.Model.User.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class UserRepositoryInMemoryTest {

    UserRepositoryInMemory userRepositoryInMemory;

    @Before
    public void setUp() {
        userRepositoryInMemory = new UserRepositoryInMemory();
    }

    @Test(expected = UserNotExistsException.class)
    public void shouldThrowExceptionIfUserNotExists() throws UserNotExistsException {
        User user = userRepositoryInMemory.findUserByUserName("user_not_exists");
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void shouldThrowExceptionIfTryToSaveUserThatAlreadyExist() throws UserAlreadyExistsException {
        UserRepositoryInMemory userRepositoryInMemory = new UserRepositoryInMemory();
        User userAlreadyCreated = new User("user_one", new Password("one"), new HashSet<>((Arrays.asList((Role.PAGE_1)))));
        userRepositoryInMemory.saveUser(userAlreadyCreated);
    }
}