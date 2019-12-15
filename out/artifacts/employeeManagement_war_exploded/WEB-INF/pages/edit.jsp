<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/11/24
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "Male");
    map.put("0", "Female");
    request.setAttribute("genders", map);
%></
>
<head>
    <title>edit.jsp</title>
</head>
<body>
<form:form action="${ctp}/emp" modelAttribute="employee" method="post">
    LastName: <form:input path="lastName"/><form:errors path="lastName"/> <br/>
    Email: <form:input path="email"/><form:errors path="email"/> <br/>
    Gender: &nbsp;&nbsp;&nbsp;<form:radiobuttons path="gender" items="${genders}"/><br/>
    DepartmentName: <form:select path="department.id"
                                 items="${departments}" itemLabel="departmentName" itemValue="id"/><br/>
    Birth: <form:input path="birthday"/><form:errors path="birthday"/><br/>
    <input type="submit" value="添加雇员">

</form:form>
</body>
</html>
