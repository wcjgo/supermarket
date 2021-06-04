package com.smbs.ctrl;

import com.smbs.dao.BillDao;
import com.smbs.dao.ProviderDao;
import com.smbs.pojo.SuperBill;
import com.smbs.pojo.SuperProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/selectAllBill")
public class SelectAllBill extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillDao billDao = new BillDao();
        List<SuperBill> billList =  billDao.selectAllBill();
        request.setAttribute("billList",billList);

        ProviderDao providerDao = new ProviderDao();
        List<SuperProvider> providerList = providerDao.selectAllProvider();
        Map<Integer, SuperProvider> providerMap = new HashMap<>();
        for (SuperProvider p : providerList) {
            providerMap.put(p.getProviderId(),p);
        }
        request.getSession().setAttribute("pMap",providerMap);
        request.getRequestDispatcher("admin_bill_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
