package pl.coderslab.web.day3.cookie;

import javax.servlet.http.Cookie;

public class CookieUtil {

    public static Cookie getCookie(Cookie[] cookies, String cookieName) {
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
