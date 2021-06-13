<%--
  Created by IntelliJ IDEA.
  User: domin
  Date: 13.06.2021
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

${empty param.a ? (empty param.b ? "BRAK" : param.b) : param.a.concat(param.b)}
</br>

${cookie.get("foo").value}

</body>
</html>
