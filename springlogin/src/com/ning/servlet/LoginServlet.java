package com.ning.servlet;

import com.ning.pojo.Users;
import com.ning.service.UsersService;
import com.ning.service.impl.UsersServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UsersService usersService;
    @Override
    public void init() throws ServletException {
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        usersService = wac.getBean("usersService", UsersServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Users users = new Users();
        users.setUsername(request.getParameter("username"));
        users.setPassword(request.getParameter("password"));
        Users user = usersService.login(users);
        if (user != null) {
            response.sendRedirect("/springLogin/main.jsp");
        }else {
            response.sendRedirect("/springLogin/show.jsp");
        }
    }
}
