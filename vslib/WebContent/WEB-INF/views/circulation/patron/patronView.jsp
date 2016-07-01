<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<script>
    $(function() {
        $( "#tabs" ).tabs();
        $( "#itemmenu" ).buttonset();
    });
</script>

<h2 class="contentTitle">Patron (View Details)</h2>

<div id="itemmenu" style="font-size: 9px; margin-top: 10px; display: inline;">
	<ul class="tmenu">
		<li><a href="<c:url value="/circulation/patron/addNew"/>">Patron (Add New)</a></li>
		<li><a href="<c:url value="/circulation/patron/edit/${patron.id}"/>">Patron (Edit)</a></li>
		<li><a href="<c:url value="/circulation/patron/delete/${patron.id}"/>">Patron (Delete)</a></li>
	</ul>
</div>

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
	</tbody>
</table>
<div id="tabs">
    <ul>
        <li><a href="#tabs-1">Check Outs</a></li>
        <li><a href="#tabs-2">Items on Hold</a></li>
        <li><a href="#tabs-3">Items on Reserve</a></li>
        <li><a href="#tabs-4">Other Details</a></li>
    </ul>
    <div id="tabs-1">
    	<form:form id="itemCheckOutForm" method="post" action="./itemCheckOut" modelAttribute="checkOutForm">
    		<form:hidden path="patron"/>
    		<table class="vsform">
    			<tr>
    				<td>
    					<form:input path="barcodeNumber" class="inputbig required"/>
    				</td>
    				<td>
    					<input type="submit" id="buttonSubmit" value="Check-Out"/>
    				</td>
    			</tr>
    		</table>
    	</form:form>
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
    </div>
    <div id="tabs-2">
    	<form:form id="itemHoldForm" method="post" action="./itemHold" modelAttribute="holdForm">
    		<form:hidden path="patron"/>
    		<table class="vsform">
    			<tr>
    				<td>
    					<form:input path="barcodeNumber" class="inputbig required"/>
    				</td>
    				<td>
    					<input type="submit" id="buttonReset" value="Put-on-Hold"/>
    				</td>
    			</tr>
    		</table>
    	</form:form>
        <table class="dataTable">
        	<thead>
        		<tr>
        			<th style="width: 100px;"><spring:message code="item.barcodeNumber"/></th>
        			<th><spring:message code="document.uniformTitle"/></th>
        			<th style="width: 100px;"><spring:message code="itemHold.holdDate"/></th>
        			<th style="width: 100px;"><spring:message code="itemHold.holdReleaseDate"/></th>
        			<th style="width: 80px;">Select</th>
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
     						<td>
     							<ul id="icons" class="ui-widget ui-helper-clearfix">
									<li class="ui-state-default ui-corner-all" title="Remove Hold"><a
										onclick="return getConfirmation()"
										href="<c:url value="/circulation/itemHold/delete/${itemHold.id}"/>" onclick="return getConfirmation();"><span
											class="ui-icon ui-icon-arrowthick-1-s"></span></a></li>
								</ul>
     						</td>
        				</tr>
        			</c:forEach>
        		</c:if>
        	</tbody>
        </table>
    </div>
    <div id="tabs-3">
    	<form:form id="itemReserveForm" method="post" action="./itemReserve" modelAttribute="reserveForm">
    		<form:hidden path="patron"/>
    		<table class="vsform">
    			<tr>
    				<td>
    					<form:input path="barcodeNumber" class="inputbig required"/>
    				</td>
    				<td>
    					<input type="submit" id="buttonGo" value="Reserve"/>
    				</td>
    			</tr>
    		</table>
    	</form:form>
        <table class="dataTable">
        	<thead>
        		<tr>
        			<th style="width: 100px;"><spring:message code="item.barcodeNumber"/></th>
        			<th><spring:message code="document.uniformTitle"/></th>
        			<th style="width: 100px;"><spring:message code="itemReserve.reserveDate"/></th>
        			<th style="width: 100px;"><spring:message code="itemReserve.reserveReleaseDate"/></th>
        			<th style="width: 80px;">Select</th>
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
     						<td>
     							<ul id="icons" class="ui-widget ui-helper-clearfix">
									<li class="ui-state-default ui-corner-all" title="Remove Reservation"><a
										onclick="return getConfirmation()"
										href="<c:url value="/circulation/itemHold/delete/${itemReserve.id}"/>" onclick="return getConfirmation();"><span
											class="ui-icon ui-icon-arrowthick-1-s"></span></a></li>
								</ul>
     						</td>
        				</tr>
        			</c:forEach>
        		</c:if>
        	</tbody>
        </table>
    </div>
    <div id="tabs-4">
		<table class="vsform">
			<tbody>
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
    </div>
</div>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />