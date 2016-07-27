<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<sec:authorize access="hasAnyRole('ROLE_PATRON')">
	<li><a href="<c:url value="/profile"/>">My Profile</a></li>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_CAT')">
	<li><a href="<c:url value="/cataloguing"/>">Cataloguing</a></li>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_CIR')">
	<li><a href="<c:url value="/circulation"/>">Circulation</a></li>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_REP')">
	<li><a href="<c:url value="/report"/>">Report</a></li>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SETUP')">
	<li><a href="<c:url value="/setup"/>">Setup</a></li>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_CON')">
	<li><a href="<c:url value="/content"/>">Content</a></li>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
	<li><a href="<c:url value="/manager"/>">Manager</a></li>
</sec:authorize>