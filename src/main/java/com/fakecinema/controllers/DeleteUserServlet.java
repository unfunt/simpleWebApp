package com.fakecinema.controllers;

import com.fakecinema.dto.DeleteUserDto;
import com.fakecinema.dto.UserDto;
import com.fakecinema.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vova on 07.06.2019.
 */
@WebServlet (name = "DeleteUserServlet", urlPatterns = "/admin/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        List<DeleteUserDto> listUsers = userService.getAllUsersToDelete();
        req.setAttribute("listUsers", listUsers);
        req.getRequestDispatcher("/jsp/admin/deleteUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        userService.deleteUser(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(req.getContextPath() + "/admin");
    }
}
