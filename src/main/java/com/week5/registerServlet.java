package com.week5;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

public class registerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            // 连接到数据库
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/t_pay",
                    "username", "password");
            // 首先检查用户名是否已经存在
            PreparedStatement checkStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            checkStatement.setString(1, username);
            ResultSet resultSet = checkStatement.executeQuery();
            if (resultSet.next()) {
                // 用户名已经存在，返回错误消息
                resp.sendRedirect("register.jsp");
                resp.getWriter().write("注册失败，用户名已经存在。");
            } else {
                // 用户名不存在，将用户名和密码存储到数据库中
                PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
                insertStatement.setString(1, username);
                insertStatement.setString(2, password);
                insertStatement.executeUpdate();
                // 注册成功，重定向到登录页
                resp.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
