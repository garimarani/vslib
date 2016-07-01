<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Item Check-In (View Details)</h2>

<table class="vsform">
	<tbody>
		<tr>	
			<td><label><spring:message code="document.uniformTitle"/></label></td>
			<td>
				${itemCheckIn.item.document.uniformTitle}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="document.primaryAuthor"/></label></td>
			<td>
				${itemCheckIn.item.document.primaryAuthor}
			</td>
		</tr>
		<tr>
			<td><label><spring:message code="document.secondaryAuthors"/></label></td>
			<td>
				${itemCheckIn.item.document.secondaryAuthors}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="item.barcodeNumber"/></label></td>
			<td>
				${itemCheckIn.item.barcodeNumber}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="item.classNumber"/></label></td>
			<td>
				${itemCheckIn.item.classNumber}
			</td>
		</tr>
	</tbody>
</table>
	
<table class="dataTable">
	<thead>
		<tr>
			<th style="width: 100px;"><spring:message code="patron.number"/></th>
			<th><spring:message code="patron.name"/></th>
			<th style="width: 80px;"><spring:message code="itemCheckOut.checkOutDate"/></th>
			<th style="width: 80px;"><spring:message code="itemCheckOut.dueDate"/></th>
			<th style="width: 80px;"><spring:message code="itemCheckIn.checkInDate"/></th>
			<th style="width: 80px;"><spring:message code="itemCheckIn.fineAmount"/></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
				${itemCheckIn.patron.number}
			</td>
			<td>
				${itemCheckIn.patron.name}
			</td>
			<td>
				<fmt:formatDate value="${itemCheckIn.checkOutDate.time}" pattern="dd-MM-yyyy"/>
			</td>
			<td>
				<fmt:formatDate value="${itemCheckIn.dueDate.time}" pattern="dd-MM-yyyy"/>
			</td>
			<td>
				<fmt:formatDate value="${itemCheckIn.checkInDate.time}" pattern="dd-MM-yyyy"/>
			</td>
			<td>
				${itemCheckIn.fineAmount} 
			</td>
		</tr>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />