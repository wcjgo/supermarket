<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改用户</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
    function checkit()
    {
        //判断是否是数字的正则表达式
        return true;
    }
</script>
</head>
<body>
<div class="main">
    <div class="optitle clearfix">
        <div class="title">用户管理&gt;&gt;</div>

    </div>
    <form id="form1" name="form1" method="post" action="postUpdateUser" onsubmit="return checkit();">
        <input type="hidden" name="flag" value="doAdd">
        <div class="content">
            <table class="box"><font color="red"></font>
                <tr>
                    <td class="field">用户名称：</td>
                    <td><input type="text" name="username" class="text" id="textfield2" value="${requestScope.oldUser.username}"/></td>
                </tr>
                <tr>
                    <td class="field">出生日期：</td>
                    <td><input type="date" name="birthday" class="text" id="textfield2" value="${requestScope.oldUser.uBirthday}"> </td>
                </tr>
                <tr>
                    <td class="field">用户电话：</td>
                    <td><input type="text" name="phone" class="text" id="textfield2" value="${requestScope.oldUser.phone}"/>  </td>
                </tr>
                <tr>
                    <td class="field">用户地址：</td>
                    <td><textarea name="address" id="textarea" class="text" cols="45" rows="5">${requestScope.oldUser.address}</textarea></td>
                </tr>
                <tr>
                    <td class="field">用户权限：</td>
                    <td><input type="radio" name="auth" id="auth" value="0" <c:if test="${requestScope.oldUser.role==0}">checked="checked"</c:if>/>普通管理员
                        <input type="radio" name="auth" id="auth" value="1" <c:if test="${requestScope.oldUser.role==1}">checked="checked"</c:if> />超级管理员</td>
                </tr>
            </table>
        </div>
        <div class="buttons">
            <input type="hidden" name="uid" value="${requestScope.oldUser.userId}"/>
            <input type="submit" name="button" id="button" value="修改用户" class="input-button"/>
            <input type="button" name="button" id="button" onclick="window.location='deleteUser?uid=${requestScope.oldUser.userId}';" value="删除" class="input-button"/>
        </div>

    </form>
</div>
</body>
</html>
