<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='v' uri="http://vdab.be/tags"%>
<%@taglib prefix='form' uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang='nl'>
<head>
  <v:head title="Brouwer toevoegen"/>
</head>
<body>
  <v:menu/>
  <h1>Brouwer toevoegen</h1>
  <c:url value='/brouwers' var='url'/>
  <v:brouwerform url='${url}' knopTekst='Toevoegen'/>
</body>
</html>