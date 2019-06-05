<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
  <HEAD>
    <TITLE>Login</TITLE>
  </HEAD>
<BODY>
<form name="loginForm" method="post" action="${pageContext.servletContext.contextPath}/login">
    Username: <input type="text" name="login"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    <input type="submit" value="Login" />
</form>
</BODY>
</HTML>