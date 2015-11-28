package Domain.Model.User;

public enum Role
{
    PAGE_1 ("page_1.jsp"),
    PAGE_2 ("page_2.jsp"),
    PAGE_3 ("page_3.jsp");

    private final String roleName;

    Role(String roleName)
    {
        this.roleName = roleName;
    }
}