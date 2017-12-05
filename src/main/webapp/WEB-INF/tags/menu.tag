<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='security' uri="http://www.springframework.org/security/tags"%>
<nav>
	<ul>
		<li><a href="<c:url value='/'/>">&#8962;</a></li>
		<li><a href="#">Brouwers</a>
			<ul>
				<security:authorize url='/brouwers'>
				  <li><a href="<c:url value='/brouwers'/>">Lijst</a></li>
				</security:authorize>
				<security:authorize url='/brouwers/toevoegen'>
				  <li><a href="<c:url value='/brouwers/toevoegen'/>">Toevoegen</a></li>
				</security:authorize>
				<security:authorize url='/brouwers/beginnaam'>
				  <li><a href="<c:url value='/brouwers/beginnaam'/>">Per
						beginnaam</a></li>
				</security:authorize>
				<security:authorize url='/brouwers/opalfabet'>
				  <li><a href="<c:url value='/brouwers/opalfabet'/>">Op alfabet</a></li>
			    </security:authorize>
			</ul>
		</li>
		<security:authorize access='isAnonymous()'>
		  <li><a href="<c:url value='/login'/>">Aanmelden</a></li>
		</security:authorize>
		<security:authorize access='isAuthenticated()'>
		  <li>
		    <form method='post' action='<c:url value="/logout"/>' id='logoutform'>
		    <input type='submit' value='<security:authentication property="name"/> afmelden' 
		    	id='logoutbutton'>
		    <security:csrfInput/>
		    </form>
		  </li>
		</security:authorize>
	</ul>
</nav>
