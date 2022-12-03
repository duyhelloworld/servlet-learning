package com.servlet.CookiesLearn.AppLogin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"})
public class HomePage extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
            PrintWriter printer = resp.getWriter();

            String name = "";
            Cookie[] cookies = req.getCookies();
            if (cookies.equals(null)) {
                // Cookie temp = new Cookie(name, "");
                // resp.addCookie(temp);
                resp.sendRedirect("/structure/login");
            }
            for (Cookie cookie : cookies) {
                name = cookie.getValue();
            }
            if (name.equals("")) {
                resp.sendRedirect("/structure/login");
            }
            printer.println("<script> alert('" + name + " are loggin success!') </script>");
            printer.println("<h1 align=\"center\">Home Page</h1><br>");
            printer.println("Cookies : " + cookies.toString() + "<br>");
    }    
}
