<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Global Parameters (Contact Details)</h2>

<form:form id="parametersContactsForm" method="post" modelAttribute="vslibParams">
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="organizationName"><spring:message code="vslibParams.organizationName"/></form:label></td>
				<td>
					<form:input path="organizationName" class="inputlarge required"/>
					<form:errors path="organizationName" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="organizationAddress"><spring:message code="vslibParams.organizationAddress"/></form:label></td>
				<td>
					<form:input path="organizationAddress" class="inputlarge required"/>
					<form:errors path="organizationAddress" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="contactName"><spring:message code="vslibParams.contactName"/></form:label></td>
				<td>
					<form:input path="contactName" class="inputlarge required"/>
					<form:errors path="contactName" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="contactAddress"><spring:message code="vslibParams.contactAddress"/></form:label></td>
				<td>
					<form:input path="contactAddress" class="inputlarge required"/>
					<form:errors path="contactAddress" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="contactEmail"><spring:message code="vslibParams.contactEmail"/></form:label></td>
				<td>
					<form:input path="contactEmail" class="inputlarge required"/>
					<form:errors path="contactEmail" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="siteUrl"><spring:message code="vslibParams.siteUrl"/></form:label></td>
				<td>
					<form:input path="siteUrl" class="inputlarge required"/>
					<form:errors path="siteUrl" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="reset" id="buttonReset" value=" Reset "/>
					&nbsp;&nbsp;&nbsp;<input type="submit" id="buttonSubmit" value=" Submit "/>
				</td>
			</tr>
		</tbody>
	</table>
</form:form>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />