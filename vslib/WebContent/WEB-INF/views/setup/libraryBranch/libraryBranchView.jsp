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

<h2 class="contentTitle">Library Branch (View Details)</h2>

<div id="itemmenu" style="font-size: 9px; margin-top: 10px; display: inline;">
	<ul class="tmenu">
		<li><a href="<c:url value="/setup/libraryBranch/listAll/current"/>">&lt;&lt; Back (List All)</a></li>
		<li><a href="<c:url value="/setup/libraryBranch/addNew"/>">Library Branch (Add New)</a></li>
		<li><a href="<c:url value="/setup/libraryBranch/edit/${libraryBranch.id}"/>">Library Branch (Edit)</a></li>
	</ul>
</div>

<table class="vsform">
	<tbody>
		<tr>	
			<td><label><spring:message code="libraryBranch.code"/></label></td>
			<td>
				${libraryBranch.code}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="libraryBranch.name"/></label></td>
			<td>
				${libraryBranch.name}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="library"/></label></td>
			<td>
				${libraryBranch.library.label}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.locationOne"/></label></td>
			<td>
				${libraryBranch.address.locationOne}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.locationTwo"/></label></td>
			<td>
				${libraryBranch.address.locationTwo}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.city"/></label></td>
			<td>
				${libraryBranch.address.city}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.pin"/></label></td>
			<td>
				${libraryBranch.address.pin}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.state"/></label></td>
			<td>
				${libraryBranch.address.state}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.country"/></label></td>
			<td>
				${libraryBranch.address.country}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.phone"/></label></td>
			<td>
				${libraryBranch.address.phone}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.facsimile"/></label></td>
			<td>
				${libraryBranch.address.facsimile}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="libraryBranch.contactPersonName"/></label></td>
			<td>
				${libraryBranch.contactPersonName}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="libraryBranch.email"/></label></td>
			<td>
				${libraryBranch.email}
			</td>
		</tr>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />