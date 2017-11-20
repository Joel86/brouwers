<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix='v' uri="http://vdab.be/tags"%>
<!DOCTYPE html>
<html lang='nl'>
<head>
  <v:head title="Home"/>
</head>
<body>
  <v:menu/>
  <h2><fmt:message key='${groet}'/></h2>
</body>
</html>