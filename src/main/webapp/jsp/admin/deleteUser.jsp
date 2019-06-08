<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
  <HEAD>
    <TITLE>FakeCinema</TITLE>
  </HEAD>
<BODY>
<form name="deleteUserForm" method="post" action="${pageContext.servletContext.contextPath}/admin/deleteUser">
    Please, select user to be deleted: <br/>
    <select name="id">
      <c:forEach var="user" items="${listUsers}">
        <option value="${user.getId()}">${user.getUsername()}</option>
      </c:forEach>
    </select> <br/>
    <input type="submit" value="Delete User" />
</form>
</BODY>
</HTML>