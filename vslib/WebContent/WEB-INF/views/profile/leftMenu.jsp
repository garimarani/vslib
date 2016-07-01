<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<sec:authorize access="hasAnyRole('ROLE_PATRON')">
	<li><a href="<c:url value="/profile/myprofile"/>">Get My Details</a></li>
	<li><a href="<c:url value="/profile/checkOutHistory"/>">Check Out History</a></li>
</sec:authorize>