<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
  <HEAD>
    <TITLE>FakeCinema</TITLE>
  </HEAD>
<BODY>
<form name="updateMovieForm" method="post" action="${pageContext.servletContext.contextPath}/admin/updateMovie">
    <input type="hidden" name="id" value="${movieDto.getId()}">
    Title:  <input type="text" value="${movieDto.getTitle()}" name="title"/> <br/>
    Duration: <input type="text" value="${movieDto.getDuration()}" name="duration"/> <br/>
    Description:     <textarea name="description" rows="10" cols="30">${movieDto.getDescription()}</textarea> <br/>
    <input type="submit" value="Update Movie" />
</form>
</BODY>
</HTML>