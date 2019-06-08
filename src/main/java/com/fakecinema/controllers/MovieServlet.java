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
 * Created by Vova on 03.06.2019.
 */
@WebServlet (name = "MovieServlet", urlPatterns = "/movie")
public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieService movieService = MovieService.getInstance();
        MovieDto movieDto = movieService.getById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("movieDto", movieDto);
        req.getRequestDispatcher("/jsp/common/movie.jsp").forward(req, resp);
    }
}
