<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
  <HEAD>
    <TITLE>FakeCinema</TITLE>
  </HEAD>
<BODY>
<c:forEach var="user" items="${listUsers}">
    <CENTER>
      <BR><a href="${pageContext.servletContext.contextPath}/admin/updateUser?id=${user.getId()}">${user.getUsername()}</a>
    </CENTER>
</c:forEach>
</BODY>
</HTML>