<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>订单列表</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="menu">
    <form method="get" action="findBillLike">
        商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
        是否付款：<select name="payStatus">
        <option value="">请选择</option>
        <option value="1">已付款</option>
        <option value="0">未付款</option>
    </select>
        <input type="submit" name="submit" value="组合查询" class="button" />
    </form>
</div>
<div class="main">
    <div class="optitle clearfix">
        <em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='modify.jsp'" /></em>
        <div class="title">账单管理&gt;&gt;</div>
    </div>
    <div class="content">
        <table class="list">
            <tr>
                <td>序号</td>
                <td>商品名称</td>
                <td>商品数量</td>
                <td>交易金额</td>
                <td>是否付款</td>
                <td>供应商名称</td>
                <td>商品描述</td>
                <td>账单时间</td>
                <td>操作</td>
            </tr>

            <c:forEach items="${requestScope.billList}" var="b" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${b.productName}</td>
                <td>${b.productCount}</td>
                <td>${b.totalPrice}</td>
                <%--是否付款： 1：已付款 0：未付款--%>
                <td>
                    <c:if test="${b.isPayment==1}">是</c:if>
                    <c:if test="${b.isPayment==0}">否</c:if>
                </td>
                <%--供应商名称：使用map集合--%>
                <td>${sessionScope.pMap.get(b.providerId).providerName}</td>
                <td>${b.productDesc}</td>
                <td>${b.createTime}</td>
                <td><a href="preUpdateBill?bid=${b.billId}">修改</a></td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

