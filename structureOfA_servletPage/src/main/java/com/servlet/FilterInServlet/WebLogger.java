package com.servlet.FilterInServlet;

import java.io.IOException;
// import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;

@WebFilter(urlPatterns = "/check-cookies", initParams = @WebInitParam(name = "count", value = "0"))
public class WebLogger extends HttpServlet implements Filter {

    int count;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Started filter");
        String nameCount = filterConfig.getInitParameter("count");
        count = Integer.valueOf(nameCount);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        count++;
        System.out.println("\t\t\tFiltering ... " + "\nCount = " + count);
        // Can go to /check-cookies through filter

        // + If want /get-cookies also must go through filter to go to /check-cookies
        // chain.doFilter(req, resp);

        // --- Filter Config
        // ++ Validate
        // PrintWriter writer = resp.getWriter();

        // super.service(req, resp);
        // String ageStr = req.getParameter("age");

        // if (ageStr != null) {

        //     int age = Integer.parseInt(ageStr);
        //     final int max_age = 100;
        //     if (age < 0 && age > max_age) {
        //         resp.setContentType("text/html");
        //         writer.println("Age is a number in range " + 0 + " to " + max_age);
        //     } else {
        //     }
        // }
        // else {
        // }
    }

    @Override
    public void destroy() {
        System.out.println("\t\t\tEnded filter");
    }
    
}
