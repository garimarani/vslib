<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<li><a href="<c:url value="/newArrivals"/>">New Arrivals</a></li>
<sec:authorize access="!isAuthenticated()">
	<li><a href="<c:url value="/search"/>">Document Search</a></li>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_PATRON')">
	<li><a href="<c:url value="/search"/>">Document Search</a></li>
</sec:authorize>
<br/>
<c:if test="${!empty listMenuItemDisplay}">
	<hr/>
	<c:forEach items="${listMenuItemDisplay}" var="lb">
		<c:if test="${lb.menuType eq 'externalUrl'}">
			<li><a target="${lb.targetWindow}" href="${lb.externalUrl}">${lb.name}</a></li>
		</c:if>
		<c:if test="${lb.menuType eq 'fixedArticle'}">
			<li><a href="<c:url value="/menuItem/displayArticle/${lb.article.id}"/>">${lb.name}</a></li>
		</c:if>
		<c:if test="${lb.menuType eq 'categoryBlog'}">
			<li><a href="<c:url value="/menuItem/displayCategoryBlog/${lb.articleCategory.id}"/>">${lb.name}</a></li>
		</c:if>
	</c:forEach>
	<hr/>
</c:if>
<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_CAT','ROLE_ACQ','ROLE_CIR','ROLE_REP','ROLE_CON')">
	<li><a href="<c:url value="/managerChangePassword"/>">Change Password</a> </li>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_PATRON')">
	<li><a href="<c:url value="/patronChangePassword"/>">Change Password</a> </li>
</sec:authorize>