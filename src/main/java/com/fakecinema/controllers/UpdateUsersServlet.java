package com.fakecinema.controllers;

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
@WebServlet (name = "UpdateUsersServlet", urlPatterns = "/admin/updateUsers")
public class UpdateUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        List<UserDto> listUsers = userService.getAll();
        req.setAttribute("listUsers", listUsers);
        req.getRequestDispatcher("/jsp/admin/updateUsers.jsp").forward(req, resp);
    }
}
