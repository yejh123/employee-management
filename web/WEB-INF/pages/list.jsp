<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/11/24
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<head>
    <title>雇员管理列表界面</title>
    <script type="text/javascript" src="${ctp}/scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#ajaxTest").click(function () {
                var emp = {
                    lastName :"sbchang",
                    email:"qqq.ww@q.com",
                    gender:0
                }
                var empStr = JSON.stringify(emp);
                $.ajax({
                    url:"${ctp}/ajaxTest",
                    type: "POST",
                    data:empStr,
                    contentType:"application/json",
                    success: function (res) {
                        $.each(res, function () {
                            alert(this.lastName);
                        })
                    }
                });
                return false;
            })
        });
    </script>
</head>
<body>
<h1>雇员管理列表</h1>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>departmentName</th>
        <th>birth</th>
        <th>Edit</th>
        <th>DELETE</th>

    </tr>
    <c:forEach items="${emps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender==0?"女":"男"}</td>
            <td>${emp.department}</td>
            <td>${emp.birthday}</td>
            <td>EDIT</td>
            <td>DELETE</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="${ctp}/toAdd">添加雇员</a><br/>

<form action="${ctp}/quickAdd" method="post">
    Employee: <input type="text" name="employee" value="GG-gg@atguigu.com-0-105">
    <input type="submit" value="快速添加"/>
</form>
<br/>

<a href="" id="ajaxTest">测试ajax请求</a>
<br/>

<form action="${ctp}/testHttpMessageConverter" method="post" enctype="multipart/form-data">
    文件: <input type="file" name="file"/>
    描述: <input type="text" name="desc"/>
    <input type="submit" value="提交"/>
</form>

<br/>
<a href="${ctp}/testResponseEntity">jquery-1.9.1.min.js下载</a>

<hr/>
国际化  <a href="toLoginPage">登陆</a><br/>
<hr/>
异常处理 <br/>
<a href="exceptionTest?i=0">除0异常测试</a>  <br/>
<a href="testResponseStatusExceptionResolver?userName=admin">测试ResponseStatusExceptionResolver</a><br/>
<a href="testSimpleMappingExceptionResolver?i=1">测试SimpleMappingExceptionResolver</a>

</body>
</html>
