package com.smbs.ctrl;

import com.smbs.dao.UserDao;
import com.smbs.pojo.SuperUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/userAdd")
public class UserAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String birthdayStr = request.getParameter("birthday");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = format.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String auth = request.getParameter("auth");
        SuperUser u = new SuperUser();
        u.setUserId(userid);
        u.setUsername(username);
        u.setPassword(password);
        u.setuBirthday(birthday);
        u.setPhone(phone);
        u.setAddress(address);
        u.setRole(Integer.parseInt(auth));

        UserDao userDao = new UserDao();
        Boolean flag = userDao.addUser(u);
        if (flag)
            response.sendRedirect("selectAllUser");
        else
            response.sendRedirect("error_add.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
