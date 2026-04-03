package com.example;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EligibilityServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        double income = Double.parseDouble(request.getParameter("income"));
        String category = request.getParameter("category");

        String result = "Eligible Schemes:\n";

        if (income < 200000) {
            result += "Free Ration\n";
        }
        if (age >= 60) {
            result += "Pension\n";
        }

        // Save to DB
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/smartaid",
                    "root",
                    "Root"
            );

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO users(name, age, income, category) VALUES (?, ?, ?, ?)"
            );

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setDouble(3, income);
            ps.setString(4, category);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("result", result);
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}
