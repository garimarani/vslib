<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<script type="text/javascript">

	$(function() {
		$( "#dateOfBirth" ).datepicker({ dateFormat: "dd-mm-yy", changeMonth: true, changeYear: true });
		$( "#subscriptionDate" ).datepicker({ dateFormat: "dd-mm-yy", changeMonth: true, changeYear: true });
		$( "#subscriptionExpiryDate" ).datepicker({ dateFormat: "dd-mm-yy", changeMonth: true, changeYear: true });
	});

</script>

<h2 class="contentTitle">Patron (Add New)</h2>

<form:form id="patronAddForm" method="post" modelAttribute="patron">
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="number"><spring:message code="patron.number"/></form:label></td>
				<td colspan="3">
					<form:input path="number" class="inputsmall required"/>
					<form:errors path="number" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="salutation"><spring:message code="patron.salutation"/></form:label></td>
				<td>
					<form:select path="salutation" class="myform inputbig">
						<form:options itemValue="id" itemLabel="label" items="${listSalutation}"/>
					</form:select>
					<form:errors path="salutation" class="errorMsg"/>
				</td>
				<td><form:label path="firstName"><spring:message code="patron.firstName"/></form:label></td>
				<td>
					<form:input path="firstName" class="inputbig required"/>
					<form:errors path="firstName" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="middleName"><spring:message code="patron.middleName"/></form:label></td>
				<td>
					<form:input path="middleName" class="inputbig"/>
					<form:errors path="middleName" class="errorMsg"/>
				</td>	
				<td><form:label path="lastName"><spring:message code="patron.lastName"/></form:label></td>
				<td>
					<form:input path="lastName" class="inputbig required"/>
					<form:errors path="lastName" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="fatherName"><spring:message code="patron.fatherName"/></form:label></td>
				<td>
					<form:input path="fatherName" class="inputbig"/>
					<form:errors path="fatherName" class="errorMsg"/>
				</td>	
				<td><form:label path="dateOfBirth"><spring:message code="patron.dateOfBirth"/></form:label></td>
				<td>
					<form:input path="dateOfBirth" class="inputsmall"/>
					<form:errors path="dateOfBirth" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="gender"><spring:message code="patron.gender"/></form:label></td>
				<td>
					<form:select path="gender" class="myform inputbig">
						<form:options itemLabel="label" itemValue="id" items="${listGender}"/>
					</form:select>
					<form:errors path="gender" class="errorMsg"/>
				</td>	
				<td><form:label path="education"><spring:message code="patron.education"/></form:label></td>
				<td>
					<form:input path="education" class="inputbig"/>
					<form:errors path="education" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align: center; padding-top: 5px; padding-botton: 5px; background-color: #EEEEEE;"><b><spring:message code="address"/></b></td>
			</tr>
			<tr>	
				<td><form:label path="address.locationOne"><spring:message code="address.locationOne"/></form:label></td>
				<td>
					<form:input path="address.locationOne" class="inputbig required"/>
					<form:errors path="address.locationOne" class="errorMsg"/>
				</td>
				<td><form:label path="address.locationTwo"><spring:message code="address.locationTwo"/></form:label></td>
				<td>
					<form:input path="address.locationTwo" class="inputbig"/>
					<form:errors path="address.locationTwo" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="address.city"><spring:message code="address.city"/></form:label></td>
				<td>
					<form:input path="address.city" class="inputbig required"/>
					<form:errors path="address.city" class="errorMsg"/>
				</td>
				<td><form:label path="address.pin"><spring:message code="address.pin"/></form:label></td>
				<td>
					<form:input path="address.pin" class="inputsmall"/>
					<form:errors path="address.pin" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="address.state"><spring:message code="address.state"/></form:label></td>
				<td>
					<form:input path="address.state" class="inputbig"/>
					<form:errors path="address.state" class="errorMsg"/>
				</td>
				<td><form:label path="address.country"><spring:message code="address.country"/></form:label></td>
				<td>
					<form:input path="address.country" class="inputbig"/>
					<form:errors path="address.country" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="address.phone"><spring:message code="address.phone"/></form:label></td>
				<td>
					<form:input path="address.phone" class="inputbig"/>
					<form:errors path="address.phone" class="errorMsg"/>
				</td>
				<td><form:label path="address.facsimile"><spring:message code="address.facsimile"/></form:label></td>
				<td>
					<form:input path="address.facsimile" class="inputbig"/>
					<form:errors path="address.facsimile" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align: center; padding-top: 5px; padding-botton: 5px; background-color: #EEEEEE;"><b><spring:message code="patron.alternateAddress"/></b></td>
			</tr>
			<tr>	
				<td><form:label path="alternateAddress.locationOne"><spring:message code="address.locationOne"/></form:label></td>
				<td>
					<form:input path="alternateAddress.locationOne" class="inputbig required"/>
					<form:errors path="alternateAddress.locationOne" class="errorMsg"/>
				</td>
				<td><form:label path="alternateAddress.locationTwo"><spring:message code="address.locationTwo"/></form:label></td>
				<td>
					<form:input path="alternateAddress.locationTwo" class="inputbig"/>
					<form:errors path="alternateAddress.locationTwo" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="alternateAddress.city"><spring:message code="address.city"/></form:label></td>
				<td>
					<form:input path="alternateAddress.city" class="inputbig required"/>
					<form:errors path="alternateAddress.city" class="errorMsg"/>
				</td>
				<td><form:label path="alternateAddress.pin"><spring:message code="address.pin"/></form:label></td>
				<td>
					<form:input path="alternateAddress.pin" class="inputsmall"/>
					<form:errors path="alternateAddress.pin" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="alternateAddress.state"><spring:message code="address.state"/></form:label></td>
				<td>
					<form:input path="alternateAddress.state" class="inputbig"/>
					<form:errors path="alternateAddress.state" class="errorMsg"/>
				</td>
				<td><form:label path="alternateAddress.country"><spring:message code="address.country"/></form:label></td>
				<td>
					<form:input path="alternateAddress.country" class="inputbig"/>
					<form:errors path="alternateAddress.country" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="alternateAddress.phone"><spring:message code="address.phone"/></form:label></td>
				<td>
					<form:input path="alternateAddress.phone" class="inputbig"/>
					<form:errors path="alternateAddress.phone" class="errorMsg"/>
				</td>
				<td><form:label path="alternateAddress.facsimile"><spring:message code="address.facsimile"/></form:label></td>
				<td>
					<form:input path="alternateAddress.facsimile" class="inputbig"/>
					<form:errors path="alternateAddress.facsimile" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="email"><spring:message code="patron.email"/></form:label></td>
				<td>
					<form:input path="email" class="inputbig"/>
					<form:errors path="email" class="errorMsg"/>
				</td>
				<td><form:label path="alternateEmail"><spring:message code="patron.alternateEmail"/></form:label></td>
				<td>
					<form:input path="alternateEmail" class="inputbig"/>
					<form:errors path="alternateEmail" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="category"><spring:message code="patron.category"/></form:label></td>
				<td>
					<form:select path="category" class="myform inputbig">
						<form:options itemLabel="label" itemValue="id" items="${listPatronCategory}"/>
					</form:select>
					<form:errors path="category" class="errorMsg"/>
				</td>	
				<td><form:label path="group"><spring:message code="patron.group"/></form:label></td>
				<td>
					<form:select path="group" class="myform inputbig">
						<form:options itemLabel="label" itemValue="id" items="${listPatronGroup}"/>
					</form:select>
					<form:errors path="group" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="loginId"><spring:message code="patron.loginId"/></form:label></td>
				<td>
					<form:input path="loginId" class="inputbig required"/>
					<form:errors path="loginId" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="password"><spring:message code="patron.password"/></form:label></td>
				<td>
					<form:password path="password" class="inputbig required"/>
					<form:errors path="password" class="errorMsg"/>
				</td>
				<td><form:label path="retypePassword"><spring:message code="patron.retypePassword"/></form:label></td>
				<td>
					<form:password path="retypePassword" class="inputbig required"/>
					<form:errors path="retypePassword" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="subscriptionDate"><spring:message code="patron.subscriptionDate"/></form:label></td>
				<td>
					<form:input path="subscriptionDate" class="inputsmall required"/>
					<form:errors path="subscriptionDate" class="errorMsg"/>
				</td>
				<td><form:label path="subscriptionExpiryDate"><spring:message code="patron.subscriptionExpiryDate"/></form:label></td>
				<td>
					<form:input path="subscriptionExpiryDate" class="inputsmall required"/>
					<form:errors path="subscriptionExpiryDate" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="subscriptionAmount"><spring:message code="patron.subscriptionAmount"/></form:label></td>
				<td>
					<form:input path="subscriptionAmount" class="inputsmall" style="text-align: right;"/>
					<form:errors path="subscriptionAmount" class="errorMsg"/>
				</td>
				<td><form:label path="paymentDetails"><spring:message code="patron.paymentDetails"/></form:label></td>
				<td>
					<form:input path="paymentDetails" class="inputbig"/>
					<form:errors path="paymentDetails" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="reset" id="buttonReset" value=" Reset "/>
					&nbsp;&nbsp;&nbsp;<input type="submit" id="buttonSubmit" value=" Submit "/>
				</td>
			</tr>
		</tbody>
	</table>
</form:form>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />