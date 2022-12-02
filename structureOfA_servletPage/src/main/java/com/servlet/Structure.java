package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/"}, loadOnStartup = 1)
public final class Structure extends HttpServlet {

    /**
     * Standard structure of a servlet website
     * 
     * @param args The arguments of the program.
     */
    @Override
    public void init() throws ServletException {
        System.out.println("\t\t\t\tStarted");
    }

    @Override
    public void destroy() {
        System.out.println("\n\t\t\t\tEnded");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("Method : " + req.getMethod());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printer = resp.getWriter();
        printer.println("<!DOCTYPE html>");
        printer.println("<html lang=\"en\">");
        printer.println("<head>");
        printer.println("<meta charset=\"UTF-8\">");
        printer.println(
        "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
                        + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        
        printer.println("<title>" + req.getLocalName() + "</title>");
        printer.println("</head>");
        printer.println("<body>");

        printer.println(
            "<style> " + 
            "table {counter-reset: rowNumber;}"
                        + "table tr::before {display: table-cell;counter-increment: rowNumber;content: counter(rowNumber);padding-right: 0.3em;text-align: right;}"
            +"</style>"
        );

        printer.println("<h1>Hello Servlet. Standard structure is here!<h2>");
        printer.println("<table>"
                + "<tr><th>Lesson</th> <th>URL</th></tr>"
                + "<tr><td>" + "Hello Sevlet</td>" + "<td>/</td></tr>"
                + "<tr><td>" + "ServletRequest </td>" + "<td>/req</td></tr>"
                + "<tr><td>" + "ServletResponse  </td>" + "<td>/resp</td></tr>"
                + "<tr><td>" + "ServletConfig </td>" + "<td>/config</td></tr>"
                + "<tr><td>" + "Codes Http </td>" + "<td>/code</td></tr>"
                + "<tr><td>" + "Read Data URl </td>" + "<td>/post</td></tr>"
                + "<tr><td>" + "hello </td>" + "<td>/hello</td></tr>"
                + "<tr><td>" + "hello </td>" + "<td>/hello</td></tr>"
                + "</table>");

        printer.println("</body>");
        printer.println("</html>");

        printer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    /*
     * Chu kì sống 1 servlet (servlet life-cycle)
     * + Khi request đầu gửi đến : tạo 1 đối tượng servlet
     * + Hàm init()
     * + Hàm service()
     * + Hàm destroy()
     * 
     * >> Muốn init() ngay khi chạy server : cho load-at-startup = 1
     * -->
     */

}
