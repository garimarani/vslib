<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">List Item Reserve</h2>

<table class="dataTable">
	<thead>
		<tr>
			<th style="width: 80px;"><spring:message code="itemReserve.reserveDate"/></th>
			<th style="width: 80px;"><spring:message code="itemRelease.reserveReleaseDate"/></th>
			<th style="width: 80px;"><spring:message code="item.barcodeNumber"/></th>
			<th><spring:message code="document"/></th>
			<th style="width: 80px;"><spring:message code="patron.number"/></th>
			<th style="width: 200px;"><spring:message code="patron.name"/></th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${!empty listItemReserve}">
			<c:forEach items="${listItemReserve}" var="ir">
				<tr>
					<td style="text-align: right">
						<fmt:formatDate value="${ir.reserveDate.time}" pattern="dd-MM-yyyy"/>
					</td>
					<td style="text-align: right">
						<fmt:formatDate value="${ir.reserveReleaseDate.time}" pattern="dd-MM-yyyy"/>
					</td>
					<td style="text-align: right">
						${ir.item.barcodeNumber}
					</td>
					<td>
						${ir.item.document.uniformTitle} / ${ir.item.document.primaryAuthor}
					</td>
					<td style="text-align: right;">
						${ir.patron.number}
					</td>
					<td>
						${ir.patron.name}
					</td>	
			</c:forEach>
		</c:if>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />