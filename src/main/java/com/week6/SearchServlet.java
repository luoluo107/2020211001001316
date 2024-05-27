package com.week6;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchEngineServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchEngine = request.getParameter("engine");
        String query = request.getParameter("query");
        String url = "";

        if ("baidu".equals(searchEngine)) {
            url = "https://www.baidu.com/s?wd=" + query;
        } else if ("google".equals(searchEngine)) {
            url = "https://www.google.com/search?q=" + query;
        } else if ("newbing".equals(searchEngine)) {
            url = "https://www.newbing.com/search?q=" + query;
        }

        response.sendRedirect(url);
    }
}
