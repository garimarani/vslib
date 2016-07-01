<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Change Password</h2>

<form:form id="frmChangePasswordForm" method="post" modelAttribute="changePasswordForm">
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="password"><spring:message code="cpf.password"/></form:label></td>
				<td>
					<form:password path="password" class="inputsmall required"/>
					<form:errors path="password" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="retypePassword"><spring:message code="cpf.retypePassword"/></form:label></td>
				<td>
					<form:password path="retypePassword" class="inputsmall required"/>
					<form:errors path="retypePassword" class="errorMsg"/>
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