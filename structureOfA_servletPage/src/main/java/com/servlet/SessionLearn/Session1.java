package com.servlet.SessionLearn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/session1"})
public class Session1 extends HttpServlet{
    
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            HttpSession session1 = req.getSession();
            HttpSession session2 = req.getSession();
            
            session1.setAttribute("Servlet API Version", "3.0-alpha-1");
            session2.setAttribute("Servlet Version", "4.0.1");

            resp.setContentType("text/html");
            PrintWriter printer = resp.getWriter();
        
            // +++ If not set cookie, session id will equal cookies
            printer.println("Session ID 1 : " + session1.getId()
                + "<br>Current Session 1 value : " + session1.getAttribute("Servlet API Version")
                + "<br>To String : " + session1.toString());
                
            printer.println("<br>Session ID 2 : " + session2.getId()
                + "<br>Current Session 2 value : " + session2.getAttribute("Servlet Version") 
                + "<br>To String : " + session2.toString());

            Calendar calendar = Calendar.getInstance();
            printer.println("<br>Session set at " + calendar.getTime().toString());

            printer.close();
    }
    
}
