<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
  <HEAD>
    <TITLE>FakeCinema</TITLE>
  </HEAD>
<BODY>
<form name="addMovieForm" method="post" action="${pageContext.servletContext.contextPath}/admin/addMovie">
    Title:  <input type="text" name="title"/> <br/>
    Duration: <input type="text" name="duration"/> <br/>
    Description:     <textarea name="description" rows="10" cols="30"> </textarea> <br/>
    <input type="submit" value="Add Movie" />
</form>
</BODY>
</HTML>