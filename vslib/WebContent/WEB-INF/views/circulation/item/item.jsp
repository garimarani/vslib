<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Item View</h2>

<form:form id="itemViewForm" method="post" modelAttribute="item">
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="barcodeNumber"><spring:message code="item.barcodeNumber"/></form:label></td>
				<td colspan="3">
					<form:input path="barcodeNumber" class="inputsmall required"/>
					<form:errors path="barcodeNumber" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					&nbsp;&nbsp;&nbsp;<input type="submit" id="buttonSubmit" value=" Submit "/>
				</td>
			</tr>
		</tbody>
	</table>
</form:form>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />