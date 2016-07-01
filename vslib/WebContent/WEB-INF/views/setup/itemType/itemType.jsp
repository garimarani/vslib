<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Item Type (Add New)</h2>

<form:form id="itemTypeAddForm" method="post" modelAttribute="itemType">
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="code"><spring:message code="itemType.code"/></form:label></td>
				<td>
					<form:input path="code" class="inputsmall required"/>
					<form:errors path="code" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="name"><spring:message code="itemType.name"/></form:label></td>
				<td>
					<form:input path="name" class="inputbig required"/>
					<form:errors path="name" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="maximumCheckOutPeriod"><spring:message code="itemType.maximumCheckOutPeriod"/></form:label></td>
				<td>
					<form:input path="maximumCheckOutPeriod" class="inputsmall required" style="text-align: right"/>
					<form:errors path="maximumCheckOutPeriod" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="maximumHoldPeriod"><spring:message code="itemType.maximumHoldPeriod"/></form:label></td>
				<td>
					<form:input path="maximumHoldPeriod" class="inputsmall required" style="text-align: right"/>
					<form:errors path="maximumHoldPeriod" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="maximumReservePeriod"><spring:message code="itemType.maximumReservePeriod"/></form:label></td>
				<td>
					<form:input path="maximumReservePeriod" class="inputsmall required" style="text-align: right"/>
					<form:errors path="maximumReservePeriod" class="errorMsg"/>
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