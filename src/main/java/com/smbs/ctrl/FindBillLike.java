package com.smbs.ctrl;

import com.smbs.dao.BillDao;
import com.smbs.pojo.SuperBill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findBillLike")
public class FindBillLike extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String productName = request.getParameter("productName");
        String payStatus = request.getParameter("payStatus");
        BillDao billDao = new BillDao();
        List<SuperBill> billList = billDao.selectLike(productName,Integer.parseInt(payStatus));
        request.setAttribute("billList",billList);
        request.getRequestDispatcher("admin_bill_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
