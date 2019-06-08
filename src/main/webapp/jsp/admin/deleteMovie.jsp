<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
  <HEAD>
    <TITLE>FakeCinema</TITLE>
  </HEAD>
<BODY>
<form name="deleteMovieForm" method="post" action="${pageContext.servletContext.contextPath}/admin/deleteMovie">
    Please, select movie to be deleted: <br/>
    <select name="id">
      <c:forEach var="movie" items="${listMovies}">
        <option value="${movie.getId()}">${movie.getTitle()}</option>
      </c:forEach>
    </select> <br/>
    <input type="submit" value="Delete Movie" />
</form>
</BODY>
</HTML>