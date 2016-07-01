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
		<tr>	
			<td><label><spring:message code="patron.fatherName"/></label></td>
			<td>
				${patron.fatherName}
			</td>	
			<td><label><spring:message code="patron.dateOfBirth"/></label></td>
			<td>
				<fmt:formatDate value="${patron.dateOfBirth.time}" pattern="dd-MM-yyyy"/>
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="gender"/></label></td>
			<td>
				${patron.gender.label}
			</td>	
			<td><label><spring:message code="patron.education"/></label></td>
			<td>
				${patron.education}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="patron.email"/></label></td>
			<td>
				${patron.email}
			</td>
			<td><label><spring:message code="patron.alternateEmail"/></label></td>
			<td>
				${patron.alternateEmail}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="patron.category"/></label></td>
			<td>
				${patron.category.label}
			</td>	
			<td><label><spring:message code="patron.group"/></label></td>
			<td>
				${patron.group.label}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="patron.subscriptionDate"/></label></td>
			<td>
				<fmt:formatDate value="${patron.subscriptionDate.time}" pattern="dd-MM-yyyy"/>
			</td>
			<td><label><spring:message code="patron.subscriptionExpiryDate"/></label></td>
			<td>
				<fmt:formatDate value="${patron.subscriptionExpiryDate.time}" pattern="dd-MM-yyyy"/>
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="patron.subscriptionAmount"/></label></td>
			<td>
				${patron.subscriptionAmount}
			</td>
			<td><label><spring:message code="patron.paymentDetails"/></label></td>
			<td>
				${patron.paymentDetails}
			</td>
		</tr>	
		<tr>
			<td colspan="4" style="text-align: center; padding-top: 5px; padding-botton: 5px; background-color: #EEEEEE;"><b><spring:message code="address"/></b></td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.locationOne"/></label></td>
			<td>
				${patron.address.locationOne}
			</td>
			<td><label><spring:message code="address.locationTwo"/></label></td>
			<td>
				${patron.address.locationTwo}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.city"/></label></td>
			<td>
				${patron.address.city}
			</td>
			<td><label><spring:message code="address.pin"/></label></td>
			<td>
				${patron.address.pin}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.state"/></label></td>
			<td>
				${patron.address.state}
			</td>
			<td><label><spring:message code="address.country"/></label></td>
			<td>
				${patron.address.country}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.phone"/></label></td>
			<td>
				${patron.address.phone}
			</td>
			<td><label><spring:message code="address.facsimile"/></label></td>
			<td>
				${patron.address.facsimile}
			</td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: center; padding-top: 5px; padding-botton: 5px; background-color: #EEEEEE;"><b><spring:message code="patron.alternateAddress"/></b></td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.locationOne"/></label></td>
			<td>
				${patron.alternateAddress.locationOne}
			</td>
			<td><label><spring:message code="address.locationTwo"/></label></td>
			<td>
				${patron.alternateAddress.locationTwo}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.city"/></label></td>
			<td>
				${patron.alternateAddress.city}
			</td>
			<td><label><spring:message code="address.pin"/></label></td>
			<td>
				${patron.alternateAddress.pin}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.state"/></label></td>
			<td>
				${patron.alternateAddress.state}
			</td>
			<td><label><spring:message code="address.country"/></label></td>
			<td>
				${patron.alternateAddress.country}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="address.phone"/></label></td>
			<td>
				${patron.alternateAddress.phone}
			</td>
			<td><label><spring:message code="address.facsimile"/></label></td>
			<td>
				${patron.alternateAddress.facsimile}
			</td>
		</tr>
	</tbody>
</table>

<h2 class="contenTitle">Check Outs</h2>
   <table class="dataTable">
   	<thead>
   		<tr>
   			<th style="width: 100px;"><spring:message code="item.barcodeNumber"/></th>
   			<th><spring:message code="document.uniformTitle"/></th>
   			<th style="width: 100px;"><spring:message code="itemCheckOut.checkOutDate"/></th>
   			<th style="width: 100px;"><spring:message code="itemCheckOut.dueDate"/></th>
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
							<fmt:formatDate value="${itemCheckOut.dueDate.time}" pattern="dd-MM-yyyy"/>
						</td>
   				</tr>
   			</c:forEach>
   		</c:if>
   	</tbody>
   </table>
<h2 class="contenTitle">Holds</h2>
   <table class="dataTable">
   	<thead>
   		<tr>
   			<th style="width: 100px;"><spring:message code="item.barcodeNumber"/></th>
   			<th><spring:message code="document.uniformTitle"/></th>
   			<th style="width: 100px;"><spring:message code="itemHold.holdDate"/></th>
   			<th style="width: 100px;"><spring:message code="itemHold.holdReleaseDate"/></th>
   		</tr>
   	</thead>
   	<tbody>
   		<c:if test="${!empty patron.holds}">
   			<c:forEach items="${patron.holds}" var="itemHold">
   				<tr>
   					<td>
							${itemHold.item.barcodeNumber}
						</td>
						<td>
							${itemHold.item.document.uniformTitle}
						</td>
						<td>
							<fmt:formatDate value="${itemHold.holdDate.time}" pattern="dd-MM-yyyy"/>
						</td>
						<td>
							<fmt:formatDate value="${itemHold.holdReleaseDate.time}" pattern="dd-MM-yyyy"/>
						</td>
   				</tr>
   			</c:forEach>
   		</c:if>
   	</tbody>
   </table>
<h2 class="contenTitle">Reserves</h2>
   <table class="dataTable">
   	<thead>
   		<tr>
   			<th style="width: 100px;"><spring:message code="item.barcodeNumber"/></th>
   			<th><spring:message code="document.uniformTitle"/></th>
   			<th style="width: 100px;"><spring:message code="itemReserve.reserveDate"/></th>
   			<th style="width: 100px;"><spring:message code="itemReserve.reserveReleaseDate"/></th>
   		</tr>
   	</thead>
   	<tbody>
   		<c:if test="${!empty patron.reserves}">
   			<c:forEach items="${patron.reserves}" var="itemReserve">
   				<tr>
   					<td>
							${itemReserve.item.barcodeNumber}
						</td>
						<td>
							${itemReserve.item.document.uniformTitle}
						</td>
						<td>
							<fmt:formatDate value="${itemReserve.reserveDate.time}" pattern="dd-MM-yyyy"/>
						</td>
						<td>
							<fmt:formatDate value="${itemReserve.reserveReleaseDate.time}" pattern="dd-MM-yyyy"/>
						</td>
   				</tr>
   			</c:forEach>
   		</c:if>
   	</tbody>
   </table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />