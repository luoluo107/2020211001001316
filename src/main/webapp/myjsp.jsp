<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 27/4/2024
  Time: 下午8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="header.jsp"%>

    <title>Title</title>
</head>
<body>
    <div>
        <a href="index.jsp"> go to helloworld</a>
    </div>
<form>
    <label>
        Name:
        <input type="text" name="name">
    </label><br/>
    <label>
        id:
        <input type="text" name="id">
    </label><br/>
    <button>submit</button>
</form>

    <div>don't have account?
        <a href="register.jsp">click here！</a>
    </div>
<%@include file="footer.jsp"%>
</body>
</html>
