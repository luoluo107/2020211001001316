package com.week5;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/t_pay",
                    "username", "password");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // 用户名和密码正确
                req.getSession().setAttribute("username", username);
                resp.sendRedirect("home.jsp"); // 重定向到主页
                System.out.println("login success!");
            } else {
                // 用户名或密码错误
                resp.sendRedirect("myjsp.jsp"); // 重定向回登录页
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
