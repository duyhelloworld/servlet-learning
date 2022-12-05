package com.servlet.ServletContext;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

class InfoWebApp {
    final String author = "duipham";
    final String fe_version = "18.2.0";
    final String be_version = "3.0.0";
    final String db_version = "8.0.31";
    final String deploy_link = "https://github.com";

    public String toString() {
        return "<ul>" 
                            + "<li>" + "FE version : " +  this.fe_version + "</li>"
                            + "<li>" + "BE version : " + this.be_version+ "</li>"
                            + "<li>" + "DBMS version : " + this.db_version + "</li>"
                            + "<li>" + "DeployLink : " + this.deploy_link + "</li>"
                            + "<li>" + "Author : " + this.author + "</li>"
             + "</ul>";
    }
}
@WebServlet(urlPatterns = {"/context"})
public class ContextTest extends HttpServlet{
    
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
            PrintWriter printer = resp.getWriter();

            // Servlet Context is Object have key-value that can read from every where of website
            // - == filter '/*' + httpServletResponse.setInitParam / filter.Config.setInit

            // There is only one ServletContext object per web application. 
            // --> Used to get information about webapp
            
            getServletContext().setAttribute("front_end", "React");
            getServletContext().setAttribute("back_end", "Spring Boot");
            getServletContext().setAttribute("database", "MySQL");
            InfoWebApp webapp = new InfoWebApp();
            getServletContext().setAttribute("webapp", webapp);
    
            printer.println("Created Servlet Context");
    }
}
