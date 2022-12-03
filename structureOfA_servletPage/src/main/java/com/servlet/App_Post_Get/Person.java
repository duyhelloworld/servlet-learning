package com.servlet.App_Post_Get;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/app", name = "App Post-Get")
public class Person extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
            PrintWriter printer = resp.getWriter();

            String name = req.getParameter("name");
            String age = req.getParameter("age");
            String address = req.getParameter("address");

            // + HTML
            printer.println("<!DOCTYPE html>");
            printer.println("<html lang=\"en\">");
            printer.println("<head>");
            printer.println("<meta charset=\"UTF-8\">");
            printer.println(
                            "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
                                            + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");

            printer.println("<title>" + req.getServerName() + "</title>");
            printer.println("</head>");
            printer.println("<body>");
            printer.println(
                            "<style>"
                                            + "div {margin: 30px 45px;padding: 40px; background-color: gray; border: 2px solid #999; box-shadow: 2px 2px -2px;}"
                                            + ".text {font-size: 12px; color: yellow; padding: 13px}"
                                            + "</style>");

            printer.println(
                            "<div>"
                                            + "<span class=\"text\">" + "Name : </span>" + name + "<br>"
                                            + "<span class=\"text\">" + "Age : </span>" + age + "<br>"
                                            + "<span class=\"text\">" + "Address : </span>" + address + "<br>"
                                            + "</div>");

            printer.println("</body>"
                            + "</html>");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
            PrintWriter printer = resp.getWriter();
            printer.println("<script>alert('Please change URL to /form')</script>");
            
    }
}
