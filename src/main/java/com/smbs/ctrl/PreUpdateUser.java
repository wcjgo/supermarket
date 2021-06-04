package com.smbs.ctrl;

import com.smbs.dao.UserDao;
import com.smbs.pojo.SuperUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/preUpdateUser")
public class PreUpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uid = request.getParameter("uid");
        UserDao UserDao = new UserDao();
        SuperUser User = UserDao.selectById(uid);
        request.setAttribute("oldUser",User);
        request.getRequestDispatcher("userUpdate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
