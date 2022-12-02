package com.servlet;

import java.io.IOException;
// import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/code" })
public class CodesHttp extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        // resp.sendError(404);
        // resp.sendError(401);

        // PrintWriter printer = resp.getWriter();
        // printer.println("<!DOCTYPE html>");
        // printer.println("<html lang=\"en\">");
        // printer.println("<head>");
        // printer.println("<meta charset=\"UTF-8\">");
        // printer.println(
        //         "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
        //                 + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");

        // printer.println("<title>Codes Http</title>");
        // printer.println("</head>");
        // printer.println("<body>");
        // printer.println("<h1 style=\"text-align: center\">404 Not Found<h1>");

        // printer.println("</body>");
        // printer.println("</html>");
        // printer.close();

        // *** If sendError --> Not response can be return to client 
        // resp.sendError(200);

        resp.sendError(500);

    }
}
