<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
  <HEAD>
    <TITLE>FakeCinema</TITLE>
  </HEAD>
<BODY>
<c:forEach var="movie" items="${listMovies}">
    <CENTER>
      <BR><a href="${pageContext.servletContext.contextPath}/admin/updateMovie?id=${movie.getId()}">${movie.getTitle()}</a>
    </CENTER>
</c:forEach>
</BODY>
</HTML>