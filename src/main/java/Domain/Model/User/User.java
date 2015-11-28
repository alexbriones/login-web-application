package Domain.Model.User;

import java.util.Set;

public class User {
    private String userName;
    private Password password;
    private Set<Role> roles;

    public User(String userName, Password password, Set<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }
    public String getUserName() {
        return userName;
    }

    public Password getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public boolean hasRole(Role role)
    {
        return this.roles.contains(role);
    }
}
