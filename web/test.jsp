<%--
  Created by IntelliJ IDEA.
  User: zhaoshuai
  Date: 2016/7/11
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file.html</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

    <script type="text/javascript">
        function showPath(){
               alert(document.getElementById("f").value);
        }
    </script>

</head>

<body>
<form action="FileServlet" method="post">
    <input type="file" id="f" name="file">
    <input type="button" value="show" onclick="showPath();">
    <input type="submit">
</form>
</body>
</html>
