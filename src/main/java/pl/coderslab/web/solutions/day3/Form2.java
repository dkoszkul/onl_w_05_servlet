package pl.coderslab.web.solutions.day3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/solution/post2")
public class Form2 extends HttpServlet {

    private List<String> badWords = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        badWords.add("cholera");
        badWords.add("kurde");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        String text = request.getParameter("text");
        System.out.println(check);
        if (!"on".equals(check)) {
            for (String badWord : badWords) {
                text = text.replaceAll(badWord, "*".repeat(badWord.length()));
            }
        }
        response.getWriter().println(text);
    }
}
