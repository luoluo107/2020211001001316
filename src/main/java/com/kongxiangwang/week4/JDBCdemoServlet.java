package com.kongxiangwang.week4;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "JDBCdemoServlet", value = "/jdbc")
public class JDBCdemoServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
//        String driver = "com.mysql.cj.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/db2024?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true";
//        String username = "root";
//        String password = "123456";
//
//        ServletConfig config = getServletConfig();
//        String driver = config.getInitParameter("driver");
//        String url = config.getInitParameter("url");
//        String username = config.getInitParameter("username");
//        String password = config.getInitParameter("password");
//
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//            System.out.println(con+"init()...");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        con = (Connection) getServletContext().getAttribute("con");
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql = "select * from t_pay";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()){
                System.out.println(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try{
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
