<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Item (View Details)</h2>

<table class="vsform">
	<tbody>
		<tr>	
			<td><label><spring:message code="document.uniformTitle"/></label></td>
			<td>
				${item.document.uniformTitle}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="document.primaryAuthor"/></label></td>
			<td>
				${item.document.primaryAuthor}
			</td>
		</tr>
		<tr>
			<td><label><spring:message code="document.secondaryAuthors"/></label></td>
			<td>
				${item.document.secondaryAuthors}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="item.barcodeNumber"/></label></td>
			<td>
				${item.barcodeNumber}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="item.classNumber"/></label></td>
			<td>
				${item.classNumber}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="itemType"/></label></td>
			<td>
				${item.itemType.label}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="language"/></label></td>
			<td>
				${item.language.label}
			</td>
		</tr>
		<tr>
			<td><label><spring:message code="subject"/></label></td>
			<td>
				${item.subject.label}
			</td>
		</tr>
		<tr>
			<td><label><spring:message code="libraryBranch"/></label></td>
			<td>
				${item.libraryBranch.label}
			</td>
		</tr>
	</tbody>
</table>

<c:if test="${!empty item.checkOuts}">
	<h2 class="contentTitle">Item Check Out</h2>
	
	<table class="dataTable">
		<thead>
			<tr>
				<th style="width: 100px;"><spring:message code="patron.number"/></th>
				<th><spring:message code="patron.name"/></th>
				<th style="width: 100px;"><spring:message code="itemCheckOut.checkOutDate"/></th>
				<th style="width: 100px;"><spring:message code="itemCheckOut.dueDate"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${item.checkOuts}" var="checkOut">
				<tr>
					<td>
						${checkOut.patron.number}
					</td>
					<td>
						${checkOut.name}
					</td>
					<td>
						<fmt:formatDate value="${checkOut.checkOutDate.time}" pattern="dd-MM-yyyy"/>
					</td>
					<td>
						<fmt:formatDate value="${checkOut.dueDate.time}" pattern="dd-MM-yyyy"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>

<c:if test="${!empty item.holds}">
	<h2 class="contentTitle">Item Holds</h2>
	
	<table class="dataTable">
		<thead>
			<tr>
				<th style="width: 100px;"><spring:message code="patron.number"/></th>
				<th><spring:message code="patron.name"/></th>
				<th style="width: 100px;"><spring:message code="itemHold.holdDate"/></th>
				<th style="width: 100px;"><spring:message code="itemHold.holdReleaseDate"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${item.holds}" var="hold">
				<tr>
					<td>
						${hold.patron.number}
					</td>
					<td>
						${hold.name}
					</td>
					<td>
						<fmt:formatDate value="${hold.holdDate.time}" pattern="dd-MM-yyyy"/>
					</td>
					<td>
						<fmt:formatDate value="${hold.holdReleaseDate.time}" pattern="dd-MM-yyyy"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>

<c:if test="${!empty item.reserves}">
	<h2 class="contentTitle">Item Reserves</h2>
	
	<table class="dataTable">
		<thead>
			<tr>
				<th style="width: 100px;"><spring:message code="patron.number"/></th>
				<th><spring:message code="patron.name"/></th>
				<th style="width: 100px;"><spring:message code="itemReserve.reserveDate"/></th>
				<th style="width: 100px;"><spring:message code="itemReserve.reserveReleaseDate"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${item.reserves}" var="reserve">
				<tr>
					<td>
						${reserve.patron.number}
					</td>
					<td>
						${reserve.name}
					</td>
					<td>
						<fmt:formatDate value="${reserve.reserveDate.time}" pattern="dd-MM-yyyy"/>
					</td>
					<td>
						<fmt:formatDate value="${reserve.reserveReleaseDate.time}" pattern="dd-MM-yyyy"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />