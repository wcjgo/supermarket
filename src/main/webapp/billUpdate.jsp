<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>订单修改</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="menu">
    <form method="get" action="">
        商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
        是否付款：<select name="payStatus">
        <option value="">请选择</option>
        <option value="1">已付款</option>
        <option value="0">未付款</option>
    </select>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" name="submit" value="组合查询" class="button" />
    </form>
</div>
<div class="main">
    <div class="optitle clearfix">
        <em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='modify.jsp'" /></em>
        <div class="title">账单管理&gt;&gt;</div>
    </div>
    <form method="post" action="postUpdateBill">
        <div class="content">
            <table class="box">
                <tr>
                    <td class="field">商品名称：</td>
                    <td><input type="text" name="pName" class="text" value="${requestScope.oldBill.productName}"/></td>
                </tr>
                <tr>
                    <td class="field">商品数量：</td>
                    <td><input type="text" name="pCount" class="text" value="${requestScope.oldBill.productCount}"/></td>
                </tr>
                <tr>
                    <td class="field">交易金额：</td>
                    <td><input type="text" name="price" class="text" value="${requestScope.oldBill.totalPrice}"/></td>
                </tr>
                <tr>
                    <td class="field">商品描述：</td>
                    <td><textarea name="pDesc">${requestScope.oldBill.productDesc}</textarea></td>
                </tr>
                <tr>
                    <td class="field">是否付款：</td>
                    <td><select name="isPay">
                        <option value="1" <c:if test="${requestScope.oldBill.isPayment==1}">selected</c:if>>是</option>
                        <option value="2">否</option>
                    </select></td>
                </tr>
                <tr>
                    <td class="field">所属供应商：</td>
                    <td>
                        <select name="pId">
                            <c:forEach items="${sessionScope.pMap.keySet()}" var="pid">
                                <option value="${pid}" <c:if test="${pid==requestScope.oldBill.billId}">selected</c:if>>
                                        ${sessionScope.pMap.get(pid).providerName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
        </div>
        <div class="buttons">
            <input type="hidden" name="bId" value="${requestScope.oldBill.billId}"/>
            <input type="submit" name="submit" value="修改" class="input-button" />
            <input type="button" name="button" value="删除" class="input-button" onclick="window.location='deleteBill?bid=${requestScope.oldBill.billId}';" />
        </div>
    </form>
</div>
</body>
</html>
