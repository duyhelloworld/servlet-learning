package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/req"}, loadOnStartup = 1)
public class GetRequester extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writter = resp.getWriter();
        // resp.setContentType("text/txt");
        // writter.println("URI : " + req.getRequestURI());

        // writter.println("ContextPath : " + req.getContextPath());
        // writter.println("Auth type : " + req.getAuthType());
        // writter.println("Content : \n\tType : " + req.getContentType() + "\n\tLength : " + req.getContentLength());
        // writter.println("Encode : " + req.getCharacterEncoding());
        // writter.println("LocalName : " + req.getLocalName());
        // writter.println("LocalAddress : " + req.getLocalAddr());
        // writter.println("Method : " + req.getMethod());
        // writter.println("Protocol : " + req.getProtocol());
        // writter.println("Request URL : " + req.getRequestURL());
        // writter.println("Query String : " + req.getQueryString());

        // + JSON
        resp.setContentType("text/json");
        @SuppressWarnings("unchecked")
        final Enumeration<String> keys = req.getHeaderNames();

        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            writter.println("{\n\t\"Key\" : \"" + key + "\",\n\t\"Value\" : \"" + req.getHeaders(key) + "\"\n}");
        }
        writter.close();
    }
}