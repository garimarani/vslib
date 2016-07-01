<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<script type="text/javascript">

	$(function() {
		$( "#itemmenu" ).buttonset();
	});

</script>

<h2 class="contentTitle">Library (View Details)</h2>

<div id="itemmenu" style="font-size: 9px; margin-top: 10px; display: inline;">
	<ul class="tmenu">
		<li><a href="<c:url value="/setup/library/listAll/current"/>">Library (List All)</a></li>
		<li><a href="<c:url value="/setup/library/addNew"/>">Library (Add New)</a></li>
		<li><a href="<c:url value="/setup/library/edit/${library.id}"/>">Library (Edit)</a></li>
	</ul>
</div>

<table class="vsform">
	<tbody>
		<tr>	
			<td><label><spring:message code="library.code"/></label></td>
			<td>
				${library.code}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="library.name"/></label></td>
			<td>
				${library.name}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="libraryType"/></label></td>
			<td>
				${library.libraryType.label}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.locationOne"/></label></td>
			<td>
				${library.address.locationOne}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.locationTwo"/></label></td>
			<td>
				${library.address.locationTwo}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.city"/></label></td>
			<td>
				${library.address.city}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.pin"/></label></td>
			<td>
				${library.address.pin}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.state"/></label></td>
			<td>
				${library.address.state}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.country"/></label></td>
			<td>
				${library.address.country}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.phone"/></label></td>
			<td>
				${library.address.phone}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.facsimile"/></label></td>
			<td>
				${library.address.facsimile}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="library.about"/></label></td>
			<td>
				${library.about}
			</td>
		</tr>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />