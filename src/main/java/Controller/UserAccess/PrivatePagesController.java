package Controller.UserAccess;

import Domain.Model.PrivatePageBlocker.RoleBasedBlocker;
import Domain.Model.User.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PrivatePagesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getSession() != null) {
            User user = (User) request.getSession().getAttribute("user");
            if (user != null) {

                String pageName = getNamePage(request.getRequestURI());
                RoleBasedBlocker roleBasedBlocker = new RoleBasedBlocker(user);
                if (!roleBasedBlocker.hasPrivilegesToAccessPage(pageName)) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN);
                } else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher(request.getServletPath()+".jsp");
                    dispatcher.forward(request, response);
                }

            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    private String getNamePage(String uri) {
        return uri.substring(uri.lastIndexOf("/")+1);
    }


}
