package com.servlet.CookiesLearn.AppLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class AppLog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printer = resp.getWriter();
        
        printer.println("<form action=\"/structure/login\" method='post'>");
        printer.println("Username : <input type=\"text\" name=\"username\">");
        printer.println("Password : <input type=\"password\" name=\"password\">");
        printer.println("<input type=\"submit\" value=\"Log in\">");
        printer.println("</form>");
        printer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("duyhelloworld") && password.equals("12345")) {

            Cookie cookie = new Cookie("Username", username);
            cookie.setMaxAge(10);
            resp.addCookie(cookie);
            
            resp.sendRedirect("/structure/home");
        }
        else {
            resp.sendRedirect("/structure/login");
        }
    }
}

