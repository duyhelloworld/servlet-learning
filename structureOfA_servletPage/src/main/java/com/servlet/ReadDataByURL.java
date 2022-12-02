package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post")
public class ReadDataByURL extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        writer.println("Getting ...<br>");
        String name = req.getParameter("name");
        writer.println("Xin chao " + name + "<br>");
        writer.println("Change url to http://localhost:8084/structure/post?name= <span style=\"color: aqua\"contenteditable> Content </span> <br>");
        
        String[] pets = req.getParameterValues("pets");
        writer.println("<br><br>Then change to http://localhost:8084/structure/post?name=Duy&pets=Snake&pets=Dog&pets=Chicken to make active the below form! <br>");
        writer.println("Your pets is : <ul>");
        for (String pet : pets) {
            writer.println("<li>" + pet + "</li>");
        }
        writer.println("</ul>");
        writer.close();
    }
}
