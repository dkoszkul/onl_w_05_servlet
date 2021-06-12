package pl.coderslab.web.day3.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session2")
public class Session2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("<form action=\"/session2\" method=\"POST\">")
                .append("<input type=\"text\" name=\"ocena\"><\\br>")
                .append("<input type=\"submit\">")
                .append("</form>");
        response.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Double> oceny = (List<Double>) session.getAttribute("oceny");
        if (oceny == null) {
            oceny = new ArrayList<>();
        }
        double ocena = Double.parseDouble(request.getParameter("ocena"));
        oceny.add(ocena);
        session.setAttribute("oceny", oceny); // update listy w sesji!!!!!!!!

        double suma = 0d;
        for (Double o : oceny) {
            suma+=o;
            response.getWriter().append(String.valueOf(o)).append(",");
        }
        double srednia = suma/oceny.size();

        response.getWriter().append("\n").append("Srednia: ").append(String.valueOf(srednia));
    }
}
