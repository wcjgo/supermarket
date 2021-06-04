package com.smbs.ctrl;

import com.smbs.dao.ProviderDao;
import com.smbs.pojo.SuperProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/postUpdateProvider")
public class PostUpdateProviderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String proId = request.getParameter("proId");
        String proName = request.getParameter("proName");
        String proDesc = request.getParameter("proDesc");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        SuperProvider p = new SuperProvider();
        p.setProviderId(Integer.parseInt(proId));
        p.setProviderName(proName);
        p.setProviderDesc(proDesc);
        p.setProviderTel(phone);
        p.setProviderAddress(address);

        ProviderDao providerDao = new ProviderDao();
        providerDao.updateProvider(p);
        response.sendRedirect("selectAllProvider");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
