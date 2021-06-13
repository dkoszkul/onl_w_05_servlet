package pl.coderslab.web.day4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/mvc11")
public class Mvc11 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");

        if (role == null) {
            // tutaj nic nie robimy
        } else {
            role = "ROLE_" + role.toUpperCase();
            request.setAttribute("userRole", role);
        }

        getServletContext().getRequestDispatcher("/jsp1.jsp").forward(request, response);
    }
}
