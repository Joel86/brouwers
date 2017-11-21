<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='form' uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix='v' uri="http://vdab.be/tags"%>
<!DOCTYPE html>
<html lang='nl'>
<head>
  <v:head title="Brouwers op naam"/>
</head>
<body>
  <v:menu/>
  <h1>Brouwers op naam</h1>
  <c:url value='/brouwers' var='url'/>
  <form:form action='${url}' method='get' commandName='brouwerBeginnaam'>
    <form:label path='beginnaam'>Begin van de naam:
    <form:errors path='beginnaam'/></form:label>
    <form:input path='beginnaam' autofocus='autofocus' required='required'
    type='search'/>
    <input type='submit' value='Zoeken'>
  </form:form>
  <c:if test='${not empty brouwers}'>
    <ul>
      <c:forEach items='${brouwers}' var='brouwer'>
        <li>${brouwer.naam}</li>
      </c:forEach>
    </ul>
  </c:if>
</body>
</html>