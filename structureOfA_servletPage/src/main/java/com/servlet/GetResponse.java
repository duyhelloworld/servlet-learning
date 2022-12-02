package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/resp", loadOnStartup = 1)
public class GetResponse extends HttpServlet{
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        // resp.sendError(200);
        resp.addHeader("key", "value");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html> <html> <head> <title>Not Plain Text </title> </head> <body>");
        if (resp.containsHeader("keys")) {
            writer.println("<h1>Contain Header!\nResponse : " + resp.toString() + "</h1>");
            // resp.sendRedirect("https://google.com");
        }
        else {
            writer.println("<h1>Response conmmited : " + resp.isCommitted() + "</h1>");
            // resp.sendRedirect("https://google.com");
        }
        // writer.flush();
        // -- Clear all written line above it
        
        // resp.reset();
        // -- Reset all response, response only exec the below code.
        writer.println("</body> </html>");
        writer.close();
    }
}
