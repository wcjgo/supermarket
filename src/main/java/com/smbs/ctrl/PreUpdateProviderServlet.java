package com.smbs.ctrl;

import com.smbs.dao.ProviderDao;
import com.smbs.pojo.SuperProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/preUpdateProvider")
public class PreUpdateProviderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        ProviderDao providerDao = new ProviderDao();
        SuperProvider sp = providerDao.selectById(pid);
        request.setAttribute("oldProvider",sp);
        request.getRequestDispatcher("providerUpdate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
