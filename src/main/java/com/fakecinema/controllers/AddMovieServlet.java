package com.fakecinema.controllers;

import com.fakecinema.dto.MovieDto;
import com.fakecinema.services.MovieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vova on 07.06.2019.
 */
@WebServlet (name = "AddMovieServlet", urlPatterns = "/admin/addMovie")
public class AddMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/admin/addMovie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieService movieService = MovieService.getInstance();
        movieService.addMovie(new MovieDto(req.getParameter("title"),
                req.getParameter("duration"),
                req.getParameter("description")));
        resp.sendRedirect(req.getContextPath() + "/admin");
    }
}
