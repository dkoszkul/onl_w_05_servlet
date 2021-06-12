package pl.coderslab.web.day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/post2")
public class Form2 extends HttpServlet {

    private List<String> badWords;

    @Override
    public void init() throws ServletException {
        super.init();
        badWords = new ArrayList<>();
        badWords.add("kurde");
        badWords.add("cholera");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pole = request.getParameter("pole");
        String check = request.getParameter("check");

        System.out.println(check);
        if (!"on".equals(check)) {
            // Tutaj będziemy sprawdzać i podmieniać wszystkie brzydkie słowa
            for (String badWord : badWords) {
                // Dla Java 9+
                pole = pole.replaceAll(badWord, "*".repeat(badWord.length()));

                // Dla Java 8
//                pole = pole.replaceAll(badWord, generateStartInsteadOf(badWord));
            }
        }

        response.getWriter().append(pole);
    }

    // Java 8 nie ma metody .repeat() więc trzeba sobie radzić inaczej ;)
    private String generateStartInsteadOf(String badWord) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < badWord.length(); i++) {
            builder.append("*");
        }

        return builder.toString();
    }
}
