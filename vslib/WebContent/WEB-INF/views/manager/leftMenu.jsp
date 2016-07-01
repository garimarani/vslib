<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
<li><a href="<c:url value="/manager/group/addNew"/>">Group</a> 
	<ul>
		<li style="width: 100px;"><a href="<c:url value="/manager/group/listAll"/>">List All</a></li>
	</ul>
</li>
<li><a href="<c:url value="/manager/manager/addNew"/>">Manager</a> 
	<ul>
		<li style="width: 100px;"><a href="<c:url value="/manager/manager/listAll"/>">List All</a></li>
	</ul>
</li>
<li><a href="<c:url value="/manager/role/addNew"/>">Role</a> 
	<ul>
		<li style="width: 100px;"><a href="<c:url value="/manager/role/listAll"/>">List All</a></li>
	</ul>
</li>
</sec:authorize>