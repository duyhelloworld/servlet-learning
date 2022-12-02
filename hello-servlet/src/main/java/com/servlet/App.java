package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/api/*", displayName = "App")
public class App extends HttpServlet{
    public void progressRequest(HttpServletRequest rq, HttpServletResponse rp)
    throws IOException, ServerException {
        rp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = rp.getWriter();
        out.println("<html>");
        out.println("<h1>Hello from java class </h1>");
        out.println("<h3>Servlet at " + rq.getContextPath() + "</h3>");
        String user = rq.getParameter("user");
        out.println("<span>Welcome " + user + " !</span>");
        out.println("</html>");
    }

    // @Override
    // public void doGet(HttpServletRequest rq, HttpServletResponse rp) 
    //         throws IOException, ServerException {
    //     progressRequest(rq, rp);
    // }
    
    // @Override
    // public void doPost(HttpServletRequest rq, HttpServletResponse rp)
    //         throws IOException, ServerException {
    //     progressRequest(rq, rp);
    // }
    
}
