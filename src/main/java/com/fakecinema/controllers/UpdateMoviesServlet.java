package com.fakecinema.controllers;

import com.fakecinema.dto.MovieDto;
import com.fakecinema.services.MovieService;

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
@WebServlet (name = "UpdateMoviesServlet", urlPatterns = "/admin/updateMovies")
public class UpdateMoviesServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieService movieService = MovieService.getInstance();
        List<MovieDto> listMovies = movieService.getAll();
        req.setAttribute("listMovies", listMovies);
        req.getRequestDispatcher("/jsp/admin/updateMovies.jsp").forward(req, resp);
    }
}
