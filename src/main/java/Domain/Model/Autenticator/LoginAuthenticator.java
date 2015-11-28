package Domain.Model.Autenticator;

import Domain.Model.User.Exceptions.UserNotExistsException;
import Domain.Model.User.User;
import Domain.Model.User.Password;
import Domain.Model.User.UserRepository;

public class LoginAuthenticator {

    private final UserRepository userRepository;

    public LoginAuthenticator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate (String userName, String password) {
        User user = null;
        try {
            user = this.userRepository.findUserByUserName(userName);
        } catch (UserNotExistsException ignored) {
        }
        return user != null && isPasswordCorrect(password, user.getPassword());
    }

    public boolean isPasswordCorrect(String passwordEntry, Password passwordInRepository) {
        return passwordInRepository.equals(passwordEntry);
    }
}
