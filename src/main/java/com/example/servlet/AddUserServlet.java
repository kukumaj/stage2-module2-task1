package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add")

public class AddUserServlet extends HttpServlet {
    //write your code here!
    private final Warehouse warehouse = Warehouse.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        request.getRequestDispatcher("jsp/add.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        User user = new User(
                request.getParameter("firstName"),
                request.getParameter("lastName")
        );
        warehouse.addUser(user);
        request.setAttribute("user",user);
        request.getRequestDispatcher("jsp/add.jsp").forward(request, response);

    }

}
