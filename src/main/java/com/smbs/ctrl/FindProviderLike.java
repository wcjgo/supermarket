package com.smbs.ctrl;

import com.smbs.dao.ProviderDao;
import com.smbs.pojo.SuperProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findProviderLike")
public class FindProviderLike extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String providerName = request.getParameter("providerName");
        String providerDesc = request.getParameter("providerDesc");
        ProviderDao providerDao = new ProviderDao();
        List<SuperProvider> providerList = providerDao.selectLike(providerName, providerDesc);
        request.setAttribute("providerList",providerList);
        request.getRequestDispatcher("providerAdmin.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
