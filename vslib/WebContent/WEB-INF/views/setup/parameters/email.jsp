<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Global Parameters (Email)</h2>

<form:form id="parametersEmailForm" method="post" modelAttribute="vslibParams">
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="enableEmail"><spring:message code="vslibParams.enableEmail"/></form:label></td>
				<td>
					<form:select path="enableEmail" class="myform inputsmall">
						<form:option label="False" value="0"/>
						<form:option label="True" value="1"/>
					</form:select>
					<form:errors path="enableEmail" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="host"><spring:message code="vslibParams.host"/></form:label></td>
				<td>
					<form:input path="host" class="inputbig"/>
					<form:errors path="host" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="port"><spring:message code="vslibParams.port"/></form:label></td>
				<td>
					<form:input path="port" class="inputsmall"/>
					<form:errors path="port" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="username"><spring:message code="vslibParams.username"/></form:label></td>
				<td>
					<form:input path="username" class="inputbig"/>
					<form:errors path="username" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="password"><spring:message code="vslibParams.password"/></form:label></td>
				<td>
					<form:password path="password" class="inputbig"/>
					<form:errors path="password" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="smtpAuthEnable"><spring:message code="vslibParams.smtpAuthEnable"/></form:label></td>
				<td>
					<form:select path="smtpAuthEnable" class="myform inputsmall">
						<form:option label="False" value="0"/>
						<form:option label="True" value="1"/>
					</form:select>
					<form:errors path="smtpAuthEnable" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="sslOrTls"><spring:message code="vslibParams.sslOrTls"/></form:label></td>
				<td>
					<form:select path="sslOrTls" class="myform inputsmall">
						<form:option label="SSL" value="SSL"/>
						<form:option label="TLS" value="TLS"/>
					</form:select>
					<form:errors path="sslOrTls" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="fromEmail"><spring:message code="vslibParams.fromEmail"/></form:label></td>
				<td>
					<form:input path="fromEmail" class="inputbig"/>
					<form:errors path="fromEmail" class="errorMsg"/>
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