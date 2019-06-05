package com.fakecinema.controllers;

import com.fakecinema.dao.MovieDao;
import com.fakecinema.dto.MovieDto;
import com.fakecinema.model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vova on 13.05.2019.
 */
@WebServlet (name = "MoviesServlet", urlPatterns = "/movies")
public class MoviesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MovieDto> listMovies = (new MovieDto()).getAll();
        req.setAttribute("listMovies", listMovies);
        req.getRequestDispatcher("/jsp/common/movies.jsp").forward(req, resp);
    }
}
