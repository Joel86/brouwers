<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<nav>
	<ul>
		<li><a href="<c:url value='/'/>">&#8962;</a></li>
		<li><a href="#">Brouwers</a>
			<ul>
				<li><a href="<c:url value='/brouwers'/>">Lijst</a></li>
				<li><a href="<c:url value='/brouwers/toevoegen'/>">Toevoegen</a></li>
				<li><a href="<c:url value='/brouwers/beginnaam'/>">Per
						beginnaam</a></li>
			</ul>
	</ul>
</nav>
