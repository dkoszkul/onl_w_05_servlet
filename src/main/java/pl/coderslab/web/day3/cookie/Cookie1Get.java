package pl.coderslab.web.day3.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/showCookie")
public class Cookie1Get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie userCookie = CookieUtil.getCookie(request.getCookies(), "User");

        // można sprawdzić czy userCookie istnieje bo inaczej będzie NullPointerException
        response.getWriter().println(userCookie.getValue());
    }
}
