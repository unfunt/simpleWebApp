<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
  <HEAD>
    <TITLE>FakeCinema</TITLE>
  </HEAD>
<BODY>
<form name="addUserForm" method="post" action="${pageContext.servletContext.contextPath}/admin/addUser">
    First Name:  <input type="text" name="firstName"/> <br/>
    Second Name: <input type="text" name="secondName"/> <br/>
    Username:    <input type="text" name="username"/> <br/>
    Password:    <input type="password" name="password"/> <br/>
    Birthday:    <input type="date" name="birthDay"/> <br/>
    E-mail:      <input type="text" name="eMail"/> <br/>
    Sex:         <select name="sex">
        <option value="MALE">MALE</option>
        <option value="FEMALE">FEMALE</option>
    </select> <br/>
    Role:        <select name="role">
        <option value="USER">USER</option>
        <option value="ADMIN">ADMIN</option>
    </select> <br/>
    <input type="submit" value="Add User" />
</form>
</BODY>
</HTML>