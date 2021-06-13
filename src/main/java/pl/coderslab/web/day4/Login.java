package pl.coderslab.web.day4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    private final static String USER = "admin";
    private final static String PASSWORD = "coderslab";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        if (user.equals(USER) && pass.equals(PASSWORD)) {
            session.setAttribute("username", user);
            response.sendRedirect("/admin");
            // dodaj dane do sesji pod kluczem: username
            // przekieruj na adres /admin
        } else {
            // wyświetl informacje o błędnych danych
            response.getWriter().println("Podałeś niepoprawne dane. Spróbuj jeszcze raz...");
        }
    }
}
