<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='v' uri="http://vdab.be/tags"%>
<%@taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang='nl'>
<head>
  <v:head title="Alle Brouwers"/>
</head>
<body>
  <v:menu/>
  <h1>Alle brouwers</h1>
  <table>
    <thead>
      <tr>
        <th><c:url value='' var='url'><c:param name='sort' value='id'/></c:url>
        <a href='${url}'>Nummer</a></th>
        <th><c:url value='' var='url'><c:param name='sort' value='naam'/></c:url>
        <a href='${url}'>Naam</a></th>
        <th>Straat</th>
        <th>HuisNr</th>
        <th><c:url value='' var='url'><c:param name='sort' value='adres.postcode'/></c:url>
        <a href='${url}'>Postcode</a></th>
        <th><c:url value='' var='url'><c:param name='sort' value='adres.gemeente'/></c:url>
        <a href='${url}'>Gemeente</a></th>
        <th><c:url value='' var='url'><c:param name='sort' value='omzet'/></c:url>
        <a href='${url}'>Omzet</a></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items='${page.content}' var='brouwer'>
      <spring:url value='/weer/{plaats}/temperatuur' var='url'>
        <spring:param name='plaats' value='${brouwer.adres.gemeente}'/>
      </spring:url>
        <tr>
          <td>${brouwer.id}</td>
          <td>${brouwer.naam}</td>
          <td>${brouwer.adres.straat}</td>
          <td>${brouwer.adres.huisNr}</td>
          <td>${brouwer.adres.postcode}</td>
          <td>${brouwer.adres.gemeente} <a href='${url}'>Temperatuur</a></td>
          <td><fmt:formatNumber value='${brouwer.omzet}'/>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <p>
    <c:forEach var='pageNr' begin='1' end='${page.totalPages}'>
      <c:choose>
        <c:when test='${pageNr-1 == page.number}'>
          ${pageNr}
        </c:when>
        <c:otherwise>
          <c:url value='' var='url'>
            <c:param name='page' value='${pageNr-1}'/>
            <c:param name='sort' value='${param.sort}'/>
          </c:url>
          <a href='${url}'>${pageNr}</a>
        </c:otherwise>
      </c:choose>
    </c:forEach>
  </p>
</body>
</html>