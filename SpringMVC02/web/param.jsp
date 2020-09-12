<%--
  Created by IntelliJ IDEA.
  User: a8001
  Date: 2020/8/31
  Time: 下午 09:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="param" method="post">
        username:<input type="text" name="name"/><br/>
        password:<input type="text" name="password"/><br/>
        age:<input type="text" name="age"/><br/>
        province:<input type="text" name="address.province"/><br/>
        city:<input type="text" name="address.city"/><br/>
        country:<input type="text" name="address.country"/><br/>
        <input type="submit" value="添加"/>

</body>
</html>
