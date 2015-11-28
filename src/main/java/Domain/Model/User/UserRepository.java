package Domain.Model.User;

import Domain.Model.User.Exceptions.UserAlreadyExistsException;
import Domain.Model.User.Exceptions.UserNotExistsException;

public interface UserRepository {
    User findUserByUserName(String userName) throws UserNotExistsException;
    void saveUser(User user) throws UserAlreadyExistsException;
}
