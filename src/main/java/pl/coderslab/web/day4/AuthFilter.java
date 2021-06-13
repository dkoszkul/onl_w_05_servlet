package pl.coderslab.web.day4;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            ((HttpServletResponse)response).sendRedirect("/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}
