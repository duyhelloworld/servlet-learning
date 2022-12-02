package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/config", loadOnStartup = 1, initParams = {
        @WebInitParam(name = "Param", value = "Duy Youtube Channel")
})
public class ServletConfiguration extends HttpServlet {

    ServletConfig config = new ServletConfig() {
            @Override
            public String getServletName() {
            return "Canical name : " + super.getClass().getCanonicalName()
                    + "<br>Simple Name : " + super.getClass().getSimpleName()
                    + "<br>Super Name : " + super.getClass().getName();
            }

            @Override
            public ServletContext getServletContext() {
                return null;
            }

            @Override
            public String getInitParameter(String name) {
                return "Initital : " + name ;
            }

            @Override
            public Enumeration<String> getInitParameterNames() {
                return null;
            }
    };
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = super.getServletConfig().getInitParameter("Param");

        
        resp.setContentType("text/html");
        PrintWriter writter = resp.getWriter();
        writter.println("<h1>No Object Override </h1><br><h2> Hello " + name + "</h1>");
        writter.println("<h1>Object Overriden</h1> <br> <h2>Servlet Context : " + config.getServletContext() + "</h2>");
        writter.println("<h2>" + config.getServletName() + "</h2>");
        writter.println("<h2>" + config.getInitParameter("Initial name") + "</h2>");
        writter.println("<h2>Init Parameters : " + config.getInitParameterNames() + "</h2>");
        writter.close();
    }
}
