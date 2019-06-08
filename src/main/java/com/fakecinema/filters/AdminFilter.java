package com.fakecinema.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vova on 06.06.2019.
 */
@WebFilter (filterName = "AdminFilter", urlPatterns = {"/admin", "/admin/*"})
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String loggedAs = (String) httpServletRequest.getSession().getAttribute("LoggedAs");
        if (loggedAs != null) {
            chain.doFilter(request, response);
        } else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {

    }
}
