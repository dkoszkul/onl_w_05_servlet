package pl.coderslab.web.day3.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addToSession")
public class Session3Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("<form action=\"/addToSession\" method=\"POST\">\n" +
                "    <label>\n" +
                "        Klucz:\n" +
                "        <input type=\"text\" name=\"key\">\n" +
                "    </label>\n" +
                "    <label>\n" +
                "        Wartość:\n" +
                "        <input type=\"text\" name=\"value\">\n" +
                "    </label>\n" +
                "    <input type=\"submit\">\n" +
                "</form>");
        response.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute(request.getParameter("key"), request.getParameter("value"));
    }
}
