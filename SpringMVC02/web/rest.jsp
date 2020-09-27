<%--
  Created by IntelliJ IDEA.
  User: a8001
  Date: 2020/8/27
  Time: 下午 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        function test() {
            $.ajax({
                url:"testAjax_DELETE",
                type:"delete",
                data:{id:1001},
                dataType:"json",
                success:function (object){
                    alert(object);
                }
            })
        }
    </script>
</head>
<body>
    <a href="testREST/1001">測試GET請求</a>
    <br/>
    <form action="testREST" method="post">
        <input type="submit" value="測試post"/>
    </form>
    <br/>
    <form action="testREST" method="post">
        <input type="hidden" name="_method" value="PUT"/>
        <input type="submit" value="測試PUT"/>
    </form>
    <br/>
    <form action="testREST/1001" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
        <input type="submit" value="測試DELETE"/>
    </form>

    <input type="button" value="測試AJAX" onclick="test()"/>
▎</body>
</html>
