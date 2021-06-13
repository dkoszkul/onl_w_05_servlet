package pl.coderslab.web.day4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/mvc12")
public class Mvc12 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startString = request.getParameter("start");
        String endString = request.getParameter("end");

        int start = Integer.parseInt(startString);
        int end = Integer.parseInt(endString);

        request.setAttribute("s", start + 10);
        request.setAttribute("e", end + 10);

        getServletContext().getRequestDispatcher("/jsp2.jsp").forward(request, response);
    }

}
