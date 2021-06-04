<%--
  Created by IntelliJ IDEA.
  User: 神舟
  Date: 2020/6/4
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="main">
    <div class="optitle clearfix">
        <div class="title">供应商管理&gt;&gt;</div>
    </div>
    <form id="form1" name="form1" method="post" action="postUpdateProvider" onsubmit="return checkit();">
        <div class="content">
            <font color="red"></font>
            <input name="flag" value="doAdd" type="hidden">
            <table class="box">

                <tbody>
                <tr style="display: none">
                    <td class="field">供应商编号：</td>
                    <td><input name="proId" id="textfield" value="${requestScope.oldProvider.providerId}" class="text" type="text"></td>
                </tr>
                <tr>
                    <td class="field">供应商名称：</td>
                    <td><input name="proName" id="textfield2" value="${requestScope.oldProvider.providerName}" class="text" type="text"></td>
                </tr>
                <tr>
                    <td class="field">供应商描述：</td>
                    <td><textarea name="proDesc" id="textarea" cols="45" rows="5">${requestScope.oldProvider.providerDesc}</textarea></td>
                </tr>
                <tr>
                    <td class="field">供应商电话：</td>
                    <td><input name="phone" id="textfield2" value="${requestScope.oldProvider.providerTel}" class="text" type="text"></td>
                </tr>
                <tr>
                    <td class="field">供应商地址：</td>
                    <td><input name="address" id="textfield2" value="${requestScope.oldProvider.providerAddress}" class="text" type="text"></td>
                </tr>
                </tbody></table>
        </div>

        <div class="buttons">
            <input name="button" id="button" value="提交" class="input-button" type="submit">
            <input name="button" id="button" onclick="window.location='deleteProvider?pid=${requestScope.oldProvider.providerId}';" value="删除" class="input-button" type="button">
        </div>
    </form>
</div>
</body>
</html>

