package servlets;

import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the current user from the session
        User user = (User ) req.getSession().getAttribute("user");

        // Check if the user is logged in
        if (user == null) {
            // Redirect to the login page if the user is not logged in
            resp.sendRedirect("login.jsp");
            return;
        }

        // Set the user object as a request attribute
        req.setAttribute("user", user);

        // Forward the request to the profile JSP page
        req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, resp);
    }
}