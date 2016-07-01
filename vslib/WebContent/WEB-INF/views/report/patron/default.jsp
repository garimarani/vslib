<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Reporting Module (Patron)</h2>

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
			<td>List of Patron</td>
			<td></td>
			<td><a href="<c:url value="/report/patron/listPatron/excel"/>">Excel Report</a></td>
		</tr>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />