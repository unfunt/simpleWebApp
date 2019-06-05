package com.fakecinema.controllers;

import com.fakecinema.dto.LoginDto;
import com.fakecinema.helper.Hash;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vova on 05.06.2019.
 */
@WebServlet (name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        LoginDto loginDto = (new LoginDto()).getByUsername(login);
        if (Hash.hashPass(password).equals(loginDto.getPassword())) {
            req.setAttribute("LoggedAs", login);
            req.getRequestDispatcher("/").forward(req, resp);
        } else {
            req.setAttribute("LoggedAs", null);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/common/login.jsp").forward(req, resp);
    }
}
