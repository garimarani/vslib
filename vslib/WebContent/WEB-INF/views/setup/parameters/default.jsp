<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Global Parameters</h2>

<table class="dataTable">
	<thead>
		<tr>
			<th>Description</th>
			<th style="width: 200px;">Link</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Parameters w.r.t. contact details &amp; organization details.</td>
			<td><a href="<c:url value="/setup/parameters/contacts"/>">Enter Values</a></td>
		</tr>
	</tbody>
		<tr>
			<td>Parameters w.r.t. email based services.</td>
			<td><a href="<c:url value="/setup/parameters/email"/>">Enable/Disable Email</a></td>
		</tr>
	</tbody>
	<tbody>
		<tr>
			<td>Parameters w.r.t. storage locations.</td>
			<td><a href="<c:url value="/setup/parameters/storage"/>">Enter Values</a></td>
		</tr>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />