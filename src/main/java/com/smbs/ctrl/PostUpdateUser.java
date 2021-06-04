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

@WebServlet("/postUpdateUser")
public class PostUpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uid = request.getParameter("uid");
        String username = request.getParameter("username");
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
        u.setUsername(username);
        u.setUserId(uid);
        u.setuBirthday(birthday);
        u.setPhone(phone);
        u.setAddress(address);
        u.setRole(Integer.parseInt(auth));

        UserDao userDao = new UserDao();
        userDao.updateUser(u);

        response.sendRedirect("selectAllUser");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
