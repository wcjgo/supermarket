package com.smbs.ctrl;

import com.smbs.dao.BillDao;
import com.smbs.pojo.SuperBill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/postUpdateBill")
public class PostUpdateBill extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bId = request.getParameter("bId");
        String pName = request.getParameter("pName");
        String pCount = request.getParameter("pCount");
        String price = request.getParameter("price");
        String pDesc = request.getParameter("pDesc");
        String isPay = request.getParameter("isPay");
        String pId = request.getParameter("pId");
        SuperBill b = new SuperBill();
        b.setBillId(Integer.parseInt(bId));
        b.setProductName(pName);
        b.setProductCount(Integer.parseInt(pCount));
        b.setTotalPrice(Double.parseDouble(price));
        b.setProductDesc(pDesc);
        b.setIsPayment(Integer.parseInt(isPay));
        b.setProviderId(Integer.parseInt(pId));

        BillDao billDao = new BillDao();
        billDao.updateBill(b);
        response.sendRedirect("selectAllBill");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
