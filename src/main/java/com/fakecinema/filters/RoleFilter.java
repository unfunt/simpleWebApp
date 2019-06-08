package com.fakecinema.filters;

import com.fakecinema.model.Role;
import com.fakecinema.services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vova on 08.06.2019.
 */
@WebFilter (displayName = "RoleFilter", urlPatterns = {"/admin/addUser", "/admin/deleteUser", "/admin/updateUsers", "/admin/updateUser"})
public class RoleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Role role = (Role) httpServletRequest.getSession().getAttribute("UserRole");
        if (role.equals(Role.ADMIN)) {
            chain.doFilter(request, response);
        } else {
            httpServletRequest.getRequestDispatcher("/jsp/common/permissionError.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
