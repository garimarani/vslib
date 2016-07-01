<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_CIR')">
	<li><a href="<c:url value="/circulation/search"/>">Search Patron</a></li>
	<li><a href="<c:url value="/circulation/patron/addNew"/>">Patron</a></li>
	<li><a href="<c:url value="/circulation/checkIn"/>">Check-in Item</a></li>
	<li><a href="<c:url value="/circulation/item/view"/>">Item View</a></li>
</sec:authorize>