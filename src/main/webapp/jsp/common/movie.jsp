<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
  <HEAD>
    <TITLE>FakeCinema</TITLE>
  </HEAD>
<BODY>
</br><c:out value="${movieDto.getTitle()}" default="err"/>
</br>
</br><c:out value="${movieDto.getDescription()}" default="err"/>
</br>
</br><c:out value="${movieDto.getDuration()}" default="err"/>
</BODY>
</HTML>