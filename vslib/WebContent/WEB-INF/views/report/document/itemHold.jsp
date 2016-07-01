<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">List Item Hold</h2>

<table class="dataTable">
	<thead>
		<tr>
			<th style="width: 80px;"><spring:message code="itemHold.holdDate"/></th>
			<th style="width: 80px;"><spring:message code="itemHold.holdReleaseDate"/></th>
			<th style="width: 80px;"><spring:message code="item.barcodeNumber"/></th>
			<th><spring:message code="document"/></th>
			<th style="width: 80px;"><spring:message code="patron.number"/></th>
			<th style="width: 200px;"><spring:message code="patron.name"/></th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${!empty listItemHold}">
			<c:forEach items="${listItemHold}" var="ih">
				<tr>
					<td style="text-align: right">
						<fmt:formatDate value="${ih.holdDate.time}" pattern="dd-MM-yyyy"/>
					</td>
					<td style="text-align: right">
						<fmt:formatDate value="${ih.holdReleaseDate.time}" pattern="dd-MM-yyyy"/>
					</td>
					<td style="text-align: right">
						${ih.item.barcodeNumber}
					</td>
					<td>
						${ih.item.document.uniformTitle} / ${ih.item.document.primaryAuthor}
					</td>
					<td style="text-align: right;">
						${ih.patron.number}
					</td>
					<td>
						${ih.patron.name}
					</td>	
			</c:forEach>
		</c:if>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />