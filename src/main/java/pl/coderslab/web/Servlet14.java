package pl.coderslab.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet14")
public class Servlet14 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Adres IP: ").append(request.getRemoteAddr())
                .append("\n")
                .append("Inaczej adres IP ale może nie działać u każdego: ").append(request.getHeader("X-Forwarded-For"))
                .append("\n")
                .append("Browser: ").append(request.getHeader("User-Agent"));
    }
}
