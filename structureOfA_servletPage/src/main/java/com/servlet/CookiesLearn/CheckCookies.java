package com.servlet.CookiesLearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/check-cookies")
public class CheckCookies extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        

        for (Cookie c : cookies) {
            writer.println("Cookie : <br>"
                    + "Name cookie : " + c.getName() + "<br>"
                    + "Value cookies : " + c.getValue() + "<br>"
            // + "Version : " + c.getVersion() + "<br>"
            // + "Domain : " + c.getDomain() + "<br>"
            // + "Comment : " + c.getComment() + "<br>"
            // + "Path : " + c.getPath() + "<br>"
            );
        }
        
        // ! Delete cookies
        for (Cookie cookie : cookies) {
            if (cookie.getName() == "name") {
                writer.print(cookie.toString());
                cookie.setMaxAge(0);
                writer.print(cookie.toString());
            }
        }
        if (cookies == null) {
            writer.print("No cookies");
            resp.reset();
        }
    }
}
