<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Error Messages (View Details)</h2>

<table class="vsform">
	<tbody>
		<tr>	
			<td><label><spring:message code="errorMessages.messageDate"/></label></td>
			<td>
				${errorMessages.messageDate.time}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="errorMessages.messageText"/></label></td>
			<td>
				<c:out value="${errorMessages.messageText}" escapeXml="false"/>
			</td>
		</tr>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />