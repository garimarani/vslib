<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Patron (View Details)</h2>

<table class="vsform">
	<tbody>
		<tr>	
			<td><label><spring:message code="patron.number"/></label></td>
			<td>
				${patron.number}
			</td>
			<td><label><spring:message code="patron.loginId"/></label></td>
			<td>
				${patron.loginId}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="patron.name"/></label></td>
			<td colspan="3">
				${patron.salutation.code} ${patron.firstName} ${patron.middleName} ${patron.lastName} 
			</td>
		</tr>
		
	</tbody>
</table>

<h2 class="contenTitle">Check Out History</h2>
   <table class="dataTable">
   	<thead>
   		<tr>
   			<th style="width: 100px;"><spring:message code="item.barcodeNumber"/></th>
   			<th><spring:message code="document.uniformTitle"/></th>
   			<th style="width: 80px;"><spring:message code="itemCheckOut.checkOutDate"/></th>
   			<th style="width: 80px;"><spring:message code="itemCheckIn.checkInDate"/></th>
   			<th style="width: 80px;"><spring:message code="itemCheckIn.fineAmount"/></th>
   		</tr>
   	</thead>
   	<tbody>
   		<c:if test="${!empty patron.checkOuts}">
   			<c:forEach items="${patron.checkOuts}" var="itemCheckOut">
   				<tr>
   					<td>
							${itemCheckOut.item.barcodeNumber}
						</td>
						<td>
							${itemCheckOut.item.document.uniformTitle}
						</td>
						<td>
							<fmt:formatDate value="${itemCheckOut.checkOutDate.time}" pattern="dd-MM-yyyy"/>
						</td>
						<td>
						</td>
						<td>
						</td>
   				</tr>
   			</c:forEach>
   		</c:if>
   		<c:if test="${!empty listItemCheckIn}">
   			<c:forEach items="${listItemCheckIn}" var="itemCheckIn">
   				<tr>
   					<td>
						${itemCheckIn.item.barcodeNumber}
					</td>
					<td>
						${itemCheckIn.item.document.uniformTitle}
					</td>
					<td>
						<fmt:formatDate value="${itemCheckIn.checkOutDate.time}" pattern="dd-MM-yyyy"/>
					</td>
					<td>
						<fmt:formatDate value="${itemCheckIn.checkInDate.time}" pattern="dd-MM-yyyy"/>
					</td>
					<td>	
						${itemCheckIn.fineAmount}
					</td>
   				</tr>
   			</c:forEach>
   		</c:if>
   	</tbody>
   </table>


<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />