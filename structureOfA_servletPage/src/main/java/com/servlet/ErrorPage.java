package com.servlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/error-handler")
public class ErrorPage extends HttpServlet {

    private void processError(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.");
        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");

        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) req.getAttribute("javax.servlet.error.request_uri");

        if (requestUri == null) {
            requestUri = "Unknown";
        }

        resp.setContentType("text/html");
        PrintWriter printer = resp.getWriter();
        String title = "Error Information";
        printer.println("<!DOCTYPE html>"
                + "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n");

        if (throwable == null && statusCode == null) {
            printer.println("<h2>Error information is missing</h2>");
            printer.println("Please return to the <a href=\"" +
                    resp.encodeURL("http://localhost:8080/structure/")
                    + "\">Home Page</a>.");
        } else if (statusCode != null) {
            printer.println("The status code : " + statusCode);
        } else {
            printer.println("<h2>Error information</h2>");
            printer.println("Servlet Name : " + servletName + "</br></br>");
            printer.println("Exception Type : " + throwable.getClass().getName() + "</br></br>");
            printer.println("The request URI: " + requestUri + "<br><br>");
            printer.println("The exception message: " + throwable.getMessage());
        }
        printer.println("</body>");
        printer.println("</html>");
        printer.close();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }    
}