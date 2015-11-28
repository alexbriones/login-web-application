package Domain.Respositories.User;

import Domain.Model.User.Exceptions.UserAlreadyExistsException;
import Domain.Model.User.Exceptions.UserNotExistsException;
import Domain.Model.User.UserRepository;
import Domain.Model.User.Password;
import Domain.Model.User.Role;
import Domain.Model.User.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class UserRepositoryInMemory implements UserRepository {

    private final HashMap<String, User> users = new HashMap<>();

    public UserRepositoryInMemory() {
        try {
            saveUser(
                    new User(
                            "user_one",
                            new Password("one"),
                            new HashSet<>((Arrays.asList((Role.PAGE_1))))
                    )
            );
            saveUser(
                    new User(
                            "user_two",
                            new Password("two"),
                            new HashSet<>((Arrays.asList((Role.PAGE_2))))
                    )
            );
            saveUser(
                    new User(
                            "user_three",
                            new Password("three"),
                            new HashSet<>((Arrays.asList((Role.PAGE_3))))
                    )
            );
            saveUser(
                    new User("user_four",
                            new Password("four"),
                            new HashSet<>((Arrays.asList((Role.PAGE_1), Role.PAGE_2)))
                    )
            );
            saveUser(
                    new User("user_five",
                            new Password("five"),
                            new HashSet<>((Arrays.asList((Role.PAGE_1), Role.PAGE_2, Role.PAGE_3)))
                    )
            );
        } catch (Exception ignored) {

        }

    }

    @Override
    public User findUserByUserName(String userName) throws UserNotExistsException {
        User user = users.get(userName);

        if (user == null) {
            throw new UserNotExistsException();
        }

        return user;
    }

    @Override
    public void saveUser(User user) throws UserAlreadyExistsException {
        if (this.users.get(user.getUserName()) != null) {
            throw new UserAlreadyExistsException();
        }
        this.users.put(user.getUserName(), user);
    }
}
