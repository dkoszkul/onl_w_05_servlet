package pl.coderslab.web.day3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 1. Wchodzimy na http://localhost:8080/form1.html
 * 2. Wypełnamy formatke danymi
 * 3. Klikamy submit/wyślij
 * 4. Obsługujemy dane w servlecie
 * 5. Zwracamy użytkownikowi text "Witaj, name lastname
 * 6. I w tym momencie w pasku URL powinniśmy być przekierowani na http://localhost:8080/post1
 */
@WebServlet("/post1")
public class Form1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");

        response.getWriter().append("Witaj, ").append(imie).append(" ").append(nazwisko);
    }
}
