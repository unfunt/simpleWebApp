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

/**
 * Created by Vova on 07.06.2019.
 */
@WebServlet (name = "AddUserServlet", urlPatterns = "/admin/addUser")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        userService.addUser(new UserDto(req.getParameter("firstName"),
                req.getParameter("secondName"),
                req.getParameter("username"),
                req.getParameter("password"),
                LocalDate.parse(req.getParameter("birthDay"), formatter),
                req.getParameter("eMail"),
                Sex.valueOf(req.getParameter("sex")),
                Role.valueOf(req.getParameter("role"))));
        resp.sendRedirect(req.getContextPath() + "/admin");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/admin/addUser.jsp").forward(req, resp);
    }
}
