package com.servlet.FilterInServlet.LimitRateAccess;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/web")
public class Counting implements Filter {
    private int Count;

    public int getCount() {
        return this.Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.setCount(Integer.valueOf(0));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpReq = (HttpServletRequest) request;
        this.setCount(this.getCount() + 1);
        System.out.println(this.getCount());
        Cookie[] cookies = httpReq.getCookies();
        if (cookies == null) {
            String s_count = String.valueOf(this.getCount());
            Cookie cookie = new Cookie("count", s_count);
            httpResponse.addCookie(cookie);
        } else {
            for (Cookie cookie : cookies) {
                String s_count = String.valueOf(this.getCount());
                cookie.setValue(s_count);
                httpResponse.addCookie(cookie);
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Clear Filter");
    }

}
