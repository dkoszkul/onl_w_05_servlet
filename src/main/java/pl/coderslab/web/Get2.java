package pl.coderslab.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/get2")
public class Get2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();

            response.getWriter().append(key).append(" : ").append(getValuesAsString(value));
        }

        System.out.println("JEstem w serwlecie");

    }

    /**
     * Tutaj stworzyłem sobie metodę pomocniczą, ponieważ do metody append() nie mogę
     * dodać tablicy stringów. Przerabiam więc ją na String przy pomocy StringBuildera ;)
     * @param value
     * @return
     */
    private String getValuesAsString(String[] value) {
        StringBuilder builder = new StringBuilder();
        for (String s : value) {
            builder.append(s).append(",");
        }
        return builder.toString();
    }
}
