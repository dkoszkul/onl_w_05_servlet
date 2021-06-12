package pl.coderslab.web.day3.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteCookie")
public class Cookie1Del extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie userCookie = CookieUtil.getCookie(request.getCookies(), "User");

        if (userCookie == null) {
            response.getWriter().println("BRAK");
        } else {
            userCookie.setMaxAge(0);
            response.addCookie(userCookie);
        }
    }
}
