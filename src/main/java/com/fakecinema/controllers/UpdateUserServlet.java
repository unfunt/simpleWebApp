package com.fakecinema.controllers;

import com.fakecinema.dto.UserDto;
import com.fakecinema.model.Role;
import com.fakecinema.model.Sex;
import com.fakecinema.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by Vova on 07.06.2019.
 */
@WebServlet (name = "UpdateUserServlet", urlPatterns = "/admin/updateUser")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        UserDto userDto = userService.getById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("userDto", userDto);
        req.getRequestDispatcher("/jsp/admin/updateUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        userService.updateUser(Integer.parseInt(req.getParameter("id")),
                new UserDto(req.getParameter("firstName"),
                        req.getParameter("secondName"),
                        req.getParameter("username"),
                        LocalDate.parse(req.getParameter("birthDay"), formatter),
                        Sex.valueOf(req.getParameter("sex")),
                        Role.valueOf(req.getParameter("role"))));
        resp.sendRedirect(req.getContextPath() + "/admin");
    }
}
