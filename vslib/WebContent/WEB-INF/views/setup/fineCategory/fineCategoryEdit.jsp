<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Fine Category (Edit)</h2>

<form:form id="fineCategoryEditForm" method="post" modelAttribute="fineCategory">
	<form:hidden path="id"/>
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="code"><spring:message code="fineCategory.code"/></form:label></td>
				<td>
					<form:input path="code" class="inputsmall required"/>
					<form:errors path="code" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="name"><spring:message code="fineCategory.name"/></form:label></td>
				<td>
					<form:input path="name" class="inputbig required"/>
					<form:errors path="name" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="rate"><spring:message code="fineCategory.rate"/></form:label></td>
				<td>
					<form:input path="rate" class="inputsmall required" style="text-align: right"/>
					<form:errors path="rate" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="days"><spring:message code="fineCategory.days"/></form:label></td>
				<td>
					<form:input path="days" class="inputsmall required" style="text-align: right"/>
					<form:errors path="days" class="errorMsg"/>
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