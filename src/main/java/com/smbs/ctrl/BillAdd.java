package com.smbs.ctrl;

import com.smbs.dao.BillDao;
import com.smbs.pojo.SuperBill;
import com.smbs.pojo.SuperUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/billAdd")
public class BillAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String pName = request.getParameter("pName");
        String pCount = request.getParameter("pCount");
        String price = request.getParameter("price");
        String pDesc = request.getParameter("pDesc");
        String isPay = request.getParameter("isPay");
        String pId = request.getParameter("pId");
        SuperBill b = new SuperBill();
        b.setProductName(pName);
        b.setProductCount(Integer.parseInt(pCount));
        b.setTotalPrice(Double.parseDouble(price));
        b.setProductDesc(pDesc);
        b.setIsPayment(Integer.parseInt(isPay));
        b.setProviderId(Integer.parseInt(pId));

        SuperUser superUser = (SuperUser) request.getSession().getAttribute("superUser");
        b.setCreator(superUser.getUserId());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        b.setCreateTime(sdf.format(date));
        BillDao billDao = new BillDao();
        Boolean flag = billDao.addBill(b);
        if (flag)
            response.sendRedirect("selectAllBill");
        else
            response.sendRedirect("error_add.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
