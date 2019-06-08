<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
  <HEAD>
    <TITLE>FakeCinema</TITLE>
  </HEAD>
<BODY>
<form name="updateUserForm" method="post" action="${pageContext.servletContext.contextPath}/admin/updateUser">
    <input type="hidden" name="id" value="${userDto.getId()}">
    First Name:  <input type="text" value="${userDto.getFirstName()}" name="firstName"/> <br/>
    Second Name: <input type="text" value="${userDto.getSecondName()}" name="secondName"/> <br/>
    Username:    <input type="text" value="${userDto.getUsername()}" name="username"/> <br/>
    Birthday:    <input type="date" value="${userDto.getBirthDay()}" name="birthDay"/> <br/>
    Sex:         <select name="sex">
    <c:choose>
      <c:when test="${userDto.getSex().name().equals('MALE')}">
         <option value="MALE" selected>MALE</option>
         <option value="FEMALE">FEMALE</option>
      </c:when>
      <c:when test="${userDto.getSex().name().equals('FEMALE')}">
         <option value="MALE">MALE</option>
         <option value="FEMALE" selected>FEMALE</option>
      </c:when>
    </c:choose>
    </select> <br/>
    Role:        <select name="role">
        <c:choose>
          <c:when test="${userDto.getRole().name().equals('USER')}">
             <option value="USER" selected>USER</option>
             <option value="ADMIN">ADMIN</option>
          </c:when>
          <c:when test="${userDto.getRole().name().equals('ADMIN')}">
             <option value="USER">USER</option>
             <option value="ADMIN" selected>ADMIN</option>
          </c:when>
        </c:choose>
    </select> <br/>
    <input type="submit" value="Update User" />
</form>
</BODY>
</HTML>