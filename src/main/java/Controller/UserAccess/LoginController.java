package Controller.UserAccess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Domain.Model.Autenticator.LoginAuthenticator;
import Domain.Model.User.User;
import Domain.Model.User.UserRepository;
import Domain.Respositories.User.UserRepositoryInMemory;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private static final int MAX_TIME_INACTIVE = 300;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        setContentType(response);

        if (isUserLogged(request)) {
            response.sendRedirect("userhome.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        setContentType(response);
        UserRepository userRepository = new UserRepositoryInMemory();
        LoginAuthenticator authenticator = new LoginAuthenticator(userRepository);

        if (authenticator.authenticate(request.getParameter("username"), request.getParameter("password"))) {
            request.getSession().setAttribute("user", getUserLogged(userRepository, request.getParameter("username")));
            request.getSession().setMaxInactiveInterval(MAX_TIME_INACTIVE);
            response.sendRedirect("userhome.jsp");
        } else {
            request.getSession().setAttribute("error","Not valid user/password");
            response.sendRedirect("login.jsp");
        }
    }

    private User getUserLogged(UserRepository userRepository, String userName) {
        User user = null;

        try {
            user = userRepository.findUserByUserName(userName);
        } catch (Exception ignored) {}

        return user;
    }

    private void setContentType(HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
    }

    private boolean isUserLogged(HttpServletRequest request)
    {
        return request.getSession() != null;
    }
}
