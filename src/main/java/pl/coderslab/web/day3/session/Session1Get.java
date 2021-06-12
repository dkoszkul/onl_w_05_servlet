package pl.coderslab.web.day3.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/session1Get")
public class Session1Get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("counter") == null) {
            response.getWriter().append("EMPTY");
        } else {
            int counter = (int)session.getAttribute("counter");
            response.getWriter().append(String.valueOf(counter));
            session.setAttribute("counter", counter+1);
        }

    }
}
