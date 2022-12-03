package com.servlet.SessionLearn;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/session2"})
public class Session2 extends HttpServlet{
    
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
            PrintWriter printer = resp.getWriter();

            String ServletApiVer = "";

            HttpSession session = req.getSession();

            Object obj = session.getAttribute("Servlet API Version");
            // name = set attribute in Session1.java
            if (obj == null) {
                resp.sendRedirect("/structure/session1");
            }
            else {
                ServletApiVer = String.valueOf(obj);
            }
            printer.println("Hello " + ServletApiVer
                    + "<br>Hash Code : " + obj.hashCode()
                    + "<br>== null : " + obj.equals(null)
                + "<br>Get Class Name : " + obj.getClass().getName());
            // servlet Ver is also.
    }
    
}
