<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html><head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户列表</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
function doit(flag,id)
{
	if(flag=="del") {
		if(confirm("确认删除吗？")!=true)
			return;
	}
}
</script>
</head><body>




<div class="menu">

<table>
<tbody><tr><td>
  <form method="post" action="findUserLike">
    <input name="flag" value="search" class="input-text" type="hidden">
用户名称：<input name="userName" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp; <input value="查 询" type="submit">
</form>
</td></tr>
</tbody></table>
</div>
<div class="main">

<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='userAdd.html'" type="button"></em>
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<div class="content">
<table class="list">
  <tbody><tr>
    <td width="60" height="29"><div class="STYLE1" align="center">序号</div></td>
    <td width="100"><div class="STYLE1" align="center">用户名称</div></td>
    <td width="160"><div class="STYLE1" align="center">出生日期</div></td>

    <td width="140"><div class="STYLE1" align="center">电话 </div></td>
    <td width="150"><div class="STYLE1" align="center">地址 </div></td>
    <td width="140"><div class="STYLE1" align="center">权限 </div></td>
    <td width="130"><div class="STYLE1" align="center">操作 </div></td>
  </tr>

  <c:forEach items="${requestScope.userList}" var="u" varStatus="i">
  <tr>
    <td height="23">${i.index+1}<span class="STYLE1"></span></td>
    <td><span class="STYLE1">${u.username}</span></td>

    <td><span class="STYLE1">
      <fmt:formatDate value="${u.uBirthday}" pattern="yyyy年MM月dd日"/>
    </span></td>
    <td><span class="STYLE1">${u.phone}</span></td>
    <td><span class="STYLE1">${u.address}</span></td>
    <td><span class="STYLE1">
      <c:if test="${u.role==0}">普通管理员</c:if>
      <c:if test="${u.role==1}">超级管理员</c:if>
    </span></td>
    <td><span class="STYLE1"><a href="preUpdateUser?uid=${u.userId}">修改</a></span></td>
  </tr>
  </c:forEach>
</tbody></table>
</div>
</div>
</body></html>
