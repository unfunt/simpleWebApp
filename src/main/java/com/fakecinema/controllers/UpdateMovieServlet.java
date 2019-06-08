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
@WebServlet (name = "UpdateMovieServlet", urlPatterns = "/admin/updateMovie")
public class UpdateMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieService movieService = MovieService.getInstance();
        MovieDto movieDto = movieService.getById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("movieDto", movieDto);
        req.getRequestDispatcher("/jsp/admin/updateMovie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieService movieService = MovieService.getInstance();
        movieService.updateMovie(Integer.parseInt(req.getParameter("id")),
                new MovieDto(req.getParameter("title"),
                        req.getParameter("duration"),
                        req.getParameter("description")));
        resp.sendRedirect(req.getContextPath() + "/admin");
    }
}
