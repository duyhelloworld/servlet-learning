package com.servlet.App_Post_Get;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/form")
public class Form extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter printer = resp.getWriter();
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
                "<form action='/structure/app' method=\"post\">"
                        + "<label for='name'>Name</label>"
                        + "<input type='text' name='name'> <br>"

                        + "<label for='age'>Age</label>"
                        + "<input type='number' name='age'> <br>"

                        + "<label for='address'>Address</label>"
                        + "<input type='text' name='address'> <br>"

                        + "<input type='submit' value='Send'>"
            +   "</form>"
        );




        printer.println("</body>"
        +   "</html>");
        
    }
}
