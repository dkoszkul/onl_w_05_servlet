package pl.coderslab.web.day3.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/cookie52")
public class Cookie52 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie51 = CookieUtil.getCookie(request.getCookies(), "cookie51");
        if (cookie51 == null) {
            String message = "Nie odwiedziles jeszcze tej strony";
            response.sendRedirect("cookie51?msg=" + URLEncoder.encode(message, "UTF-8"));
        } else {
            cookie51.setMaxAge(0);
            response.addCookie(cookie51);
            response.getWriter().println("Witamy na stronie Cookie52");
        }


    }

}
