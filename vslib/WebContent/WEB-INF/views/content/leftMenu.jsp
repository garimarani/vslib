<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_CON')">
	<li><a href="<c:url value="/content/article/addNew"/>">Article</a> 
		<ul>
			<li style="width: 100px;"><a href="<c:url value="/content/article/listAll"/>">List All</a></li>
		</ul>
	</li>
	<li><a href="<c:url value="/content/articleCategory/addNew"/>">Article Category</a> 
		<ul>
			<li style="width: 100px;"><a href="<c:url value="/content/articleCategory/listAll"/>">List All</a></li>
		</ul>
	</li>
	<li><a href="<c:url value="/content/menuItem/addNew"/>">Menu Item</a> 
		<ul>
			<li style="width: 100px;"><a href="<c:url value="/content/menuItem/listAll"/>">List All</a></li>
		</ul>
	</li>
</sec:authorize>
