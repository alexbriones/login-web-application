package Domain.Model.PrivatePageBlocker;

import Domain.Model.User.Role;
import Domain.Model.User.User;

public class RoleBasedBlocker {

    User user;

    public RoleBasedBlocker(User user) {
        this.user = user;
    }



    public boolean hasPrivilegesToAccessPage(String page) {

        try {
            Role rolePage = Role.valueOf(page.toUpperCase());
            return this.user.hasRole(rolePage);
        } catch (Exception exception) {
            return false;
        }
    }
}
