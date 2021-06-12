package pl.coderslab.web.day3.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addToCookies")
public class Cookie2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        Cookie cookie = new Cookie(key, value);
        response.addCookie(cookie);
        response.sendRedirect("/cookie2.html");
    }
}
