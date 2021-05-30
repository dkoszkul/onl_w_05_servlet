package pl.coderslab.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/get1")
public class Get1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startString = request.getParameter("start");
        String endString = request.getParameter("end");

        if (startString == null || endString == null) {
            response.getWriter().println("BRAK");
        } else {
            int start = Integer.parseInt(startString);
            int end = Integer.parseInt(endString);

            for (int i = start; i<end;i++) {
                response.getWriter().append(i + " ");
            }
        }
    }
}
