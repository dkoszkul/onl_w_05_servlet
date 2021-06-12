package pl.coderslab.web.day3.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session4")
public class Session4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<CartItem> cartItemList = (List<CartItem>) session.getAttribute("cartItems");
        double suma = 0d;
        for (CartItem cartItem : cartItemList) {
            double partialSum = cartItem.getPrice() * cartItem.getQuantity();
            response.getWriter()
                    .append(cartItem.getName())
                    .append(" - ")
                    .append(String.valueOf(cartItem.getQuantity()))
                    .append(" x ")
                    .append(String.valueOf(cartItem.getPrice()))
                    .append("zł")
                    .append(" = ")
                    .append(String.valueOf(partialSum))
                    .println("zł");
            suma+=partialSum;
        }
        response.getWriter().append("SUMA: ").println(suma);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nazwa = request.getParameter("nazwa");
        Integer ilosc = Integer.parseInt(request.getParameter("ilosc"));
        Double cena = Double.parseDouble(request.getParameter("cena"));

        CartItem cartItem = new CartItem(nazwa, ilosc, cena);


        List<CartItem> cartItemList = (List<CartItem>) session.getAttribute("cartItems");
        if (cartItemList == null) {
            cartItemList = new ArrayList<>();
        }

        cartItemList.add(cartItem);
        session.setAttribute("cartItems", cartItemList); // update
    }
}
