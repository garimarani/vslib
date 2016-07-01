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

<h2 class="contentTitle">Patron Category (View Details)</h2>

<div id="itemmenu" style="font-size: 9px; margin-top: 10px; display: inline;">
	<ul class="tmenu">
		<li><a href="<c:url value="/setup/patronCategory/listAll/current"/>">&lt;&lt; Go Back</a></li>
		<li><a href="<c:url value="/setup/patronCategory/addNew"/>">Patron Category (Add New)</a></li>
		<li><a href="<c:url value="/setup/patronCategory/edit/${patronCategory.id}"/>">Patron Category (Edit)</a></li>
		<li><a href="<c:url value="/setup/patronCategory/listAll"/>">Patron Category (List All)</a></li>
	</ul>
</div>

<table class="vsform">
	<tbody>
		<tr>	
			<td><label><spring:message code="patronCategory.code"/></label></td>
			<td>
				${patronCategory.code}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="patronCategory.name"/></label></td>
			<td>
				${patronCategory.name}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="patronCategory.maximumCheckOuts"/></label></td>
			<td>
				${patronCategory.maximumCheckOuts}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="patronCategory.maximumCheckOutPeriod"/></label></td>
			<td>
				${patronCategory.maximumCheckOutPeriod}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="patronCategory.maximumHolds"/></label></td>
			<td>
				${patronCategory.maximumHolds}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="patronCategory.maximumHoldPeriod"/></label></td>
			<td>
				${patronCategory.maximumHoldPeriod}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="patronCategory.maximumReserves"/></label></td>
			<td>
				${patronCategory.maximumReserves}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="patronCategory.maximumReservePeriod"/></label></td>
			<td>
				${patronCategory.maximumReservePeriod}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="fineCategory"/></label></td>
			<td>
				${patronCategory.fineCategory.label}
			</td>
		</tr>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />