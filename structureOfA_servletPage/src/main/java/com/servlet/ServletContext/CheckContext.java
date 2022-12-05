package com.servlet.ServletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/check_context")
    public class CheckContext extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
            PrintWriter printer = resp.getWriter();

            String info = getServletContext().getServerInfo();
            Object fe = getServletContext().getAttribute("front_end");
            Object be = getServletContext().getAttribute("back_end");
            Object db = getServletContext().getAttribute("database");
            Object webapp = getServletContext().getAttribute("webapp");

            printer.println(
                    "Front end : " + (String) fe + "<br>"
                            + "Back end : " + (String) be + "<br>"
                            + "DDMS : " + (String) db + "<br>"
                            + "Server : " + (String) info + "<br>"
            + "Web app : " + webapp.toString()
            );
        }
    }
