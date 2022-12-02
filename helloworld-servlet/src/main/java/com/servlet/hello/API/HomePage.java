package com.servlet.hello.API;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create Web Servlet use @WebServlet annotation
 * @author Duy Pham
 * @version 0.0.1 Release
 * @see https://github.com/duyhelloworld
 * @serial 0184466
 */
@WebServlet(name = "Servlet 3.0", urlPatterns = {"/home"},
description = "Apache Maven 3.6.3 Maven home: /usr/share/maven Java version: 17.0.5, vendor: Private Build, runtime: /usr/lib/jvm/java-17-openjdk-amd64 Default locale: en_US, platform encoding: UTF-8 OS name: \"linux\", version: \"5.15.0-53-generic\", arch: \"amd64\", family: \"unix\"" )
public class HomePage extends HttpServlet{
    private static final long serialVersionUID = 1L;
    String title = "Home page";
    @Override
    public void doGet(HttpServletRequest rq, HttpServletResponse rps) throws IOException, ServletException {
        rps.setContentType("text/html");
        PrintWriter writer = rps.getWriter();
        writer.print("<!DOCTYPE html>");
        writer.print("<head>");
        writer.print("<title>" + title + "</title>");
        writer.print("</head>");
        writer.print("<body>");
        writer.print(
                "<h3>Servlet Name : " + getServletName()
                        + ";</h3>" + "<br>"
                        + "<h3>Servlet Info : " + getServletInfo()
                        + ";</h3>" + "<br>"
                        + "<h3>Servlet Context : " + getServletContext()
                        + ";</h3>" + "<br>"
                        + "<h3>Servlet Config : " + getServletConfig()
                        + ";</h3>" + "<br>"
                        + "<h3>Last Modified : " + getLastModified(rq)
                        + ";</h3>" + "<br>"
                        + "<h3>Serial ID : " + serialVersionUID
                        + ";</h3> <br>"
                        + "<button>" + title + "</button>"
                        + "<script> let btn = document.querySelector('button'); btn.onclick = (e) => {console.log(\"Hello " + getServletName() + " \"), console.log(e.target);} </script>"
        );
        writer.print("</body>");
        writer.print("</html>");
        writer.close();
    }
}
