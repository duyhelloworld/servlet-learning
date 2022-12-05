package com.servlet.FilterInServlet.LimitRateAccess;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/web"})
public class Web extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printer = resp.getWriter();

        int i_count = 0;
        if (req.getCookies() != null) {
            Cookie[] cookies = req.getCookies();
            for (Cookie cookie : cookies) {
                String s_count = cookie.getValue();
                i_count = Integer.valueOf(s_count);
            }
            // + Limit
            if (i_count > 7) {
                printer.println("<script>alert('We think that you have suspicious actions. Fill in all form below to improve yourself.')</script>");
                resp.sendRedirect("/structure/capcha");
            }
            else {
                printer.println("<h1 align='ceenter>'My Website</h1>");
                printer.println("You are access to this website " + i_count + (i_count >= 2 ? " times" : " time"));
            }

        }
        else {
            printer.println("Leng = 0");
        }


        printer.close();
    }    
}
