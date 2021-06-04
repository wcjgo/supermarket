package com.smbs.ctrl;

import com.smbs.dao.UserDao;
import com.smbs.pojo.SuperUser;

import java.io.IOException;

@javax.servlet.annotation.WebServlet("/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        UserDao userDao = new UserDao();
        SuperUser su = userDao.selectById(userName);
        String pwd = su.getPassword();
        if (pwd != null && pwd.equals(passWord)){
            request.getSession().setAttribute("superUser",su);
            response.sendRedirect("admin_index.jsp");
        }else{
            response.sendRedirect("login.html");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
