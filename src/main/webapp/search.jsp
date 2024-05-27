<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 27/5/2024
  Time: 下午3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>搜索引擎选择</title></head>
<body>
<!DOCTYPE html>
<form action="SearchEngineServlet" method="get">
  <label for="query">搜索关键词:</label><br>
  <input type="text" id="query" name="query"><br>
  <label for="engine">选择搜索引擎:</label><br>
  <select id="engine" name="engine">
    <option value="baidu">百度</option>
    <option value="google">谷歌</option>
    <option value="newbing">NewBing</option>
  </select><br>
  <input type="submit" value="搜索">
</form>
</body>
</html>
