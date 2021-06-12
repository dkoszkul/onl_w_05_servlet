package pl.coderslab.web.day3.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;

@WebServlet("/showAllSessions")
public class Session3All extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Iterator<String> stringIterator = session.getAttributeNames().asIterator();
        for (Iterator<String> s = stringIterator; s.hasNext(); ) {
            String key = s.next();
            response.getWriter().append(key).append(" ").println(session.getAttribute(key));

        }
    }

}
