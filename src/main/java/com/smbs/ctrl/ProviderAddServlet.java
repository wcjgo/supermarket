package com.smbs.ctrl;

import com.smbs.dao.ProviderDao;
import com.smbs.pojo.SuperProvider;
import com.smbs.pojo.SuperUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/provider.do")
public class ProviderAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        SuperProvider p = new SuperProvider();
        p.setProviderName(request.getParameter("proName"));
        p.setProviderDesc(request.getParameter("proDesc"));
        p.setProviderTel(request.getParameter("phone"));
        p.setProviderAddress(request.getParameter("address"));
        SuperUser superUser = (SuperUser) request.getSession().getAttribute("superUser");
        p.setCreator(superUser.getUserId());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        p.setCreateTime(sdf.format(date));
        ProviderDao providerDao = new ProviderDao();
        Boolean flag = providerDao.addProvider(p);
        if (flag)
            response.sendRedirect("selectAllProvider");
        else
            response.sendRedirect("error_add.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
