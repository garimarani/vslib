<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Reporting Module (Documents)</h2>

<table class="dataTable">
	<thead>
		<tr>
			<th style="width: 500px;">Report</th>
			<th style="width: 100px;">HTML</th>
			<th style="width: 100px;">MSExcel</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>List of Items</td>
			<td></td>
			<td><a href="<c:url value="/report/document/listItem/excel"/>">Excel Report</a></td>
		</tr>
		<tr>
			<td>List of Checked Out Items</td>
			<td><a href="<c:url value="/report/document/listItemCheckOut"/>">HTML Report</a></td>
			<td><a href="<c:url value="/report/document/listItemCheckOut/excel"/>">Excel Report</a></td>
		</tr>
		<tr>
			<td>Items on Hold</td>
			<td><a href="<c:url value="/report/document/listItemHold"/>">HTML Report</a></td>
			<td><a href="<c:url value="/report/document/listItemHold/excel"/>">Excel Report</a></td>
		</tr>
		<tr>
			<td>Items on Reservation</td>
			<td><a href="<c:url value="/report/document/listItemReserve"/>">HTML Report</a></td>
			<td><a href="<c:url value="/report/document/listItemReserve/excel"/>">Excel Report</a></td>
		</tr>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />