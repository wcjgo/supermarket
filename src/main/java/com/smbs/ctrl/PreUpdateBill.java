package com.smbs.ctrl;

import com.smbs.dao.BillDao;
import com.smbs.pojo.SuperBill;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/preUpdateBill")
public class PreUpdateBill extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        BillDao billDao = new BillDao();
        SuperBill bill = billDao.selectById(Integer.parseInt(bid));
        request.setAttribute("oldBill",bill);
        request.getRequestDispatcher("billUpdate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
