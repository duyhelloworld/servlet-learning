package com.servlet.hello;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// Extend HttpServlet class
@WebServlet(urlPatterns = { "/helloworld", "/greeting"})
public class HelloWorld extends HttpServlet {

   private String message;
   private static final long serialVersionUID = 1L;

   public void init() throws ServletException {
      // Do required initialization
      message = "Hello World";
   }
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String title = "hello servlet";
      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.print("<html>");
      out.print("<title>" + title +"</title>");
      out.print("<body>");
      out.println("<h1>" + message + "</h1>");
      out.print("</body>");
      out.print("</html>");
      out.close();
   }

   public void destroy() {
       // do nothing.
   }
}