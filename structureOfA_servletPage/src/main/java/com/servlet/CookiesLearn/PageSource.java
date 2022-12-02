package com.servlet.CookiesLearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/get-cookies")
public class PageSource extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.println("Home Page<br>");
        Cookie name = new Cookie("name", "Pham Duc Duy");
        Cookie age = new Cookie("age", "19");

        // name.setMaxAge(11);
        name.setMaxAge(7);
        resp.addCookie(name);
        // resp.addCookie(name);
        age.setMaxAge(10);
        resp.addCookie(age);
        // age.setMaxAge(10);
        // writer.println("Cookie 1 : <br>" + name.getName() + "<br>" + name.getValue() + "<br>");
        // writer.println("Cookie 2 : <br>" + age.getName() + "<br>" + age.getValue() + "<br>");
    }
}
