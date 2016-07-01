<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Subject (Add)</h2>

<form:form id="subjectAddForm" method="post" modelAttribute="subject">
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="code"><spring:message code="subject.code"/></form:label></td>
				<td>
					<form:input path="code" class="inputsmall required"/>
					<form:errors path="code" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="name"><spring:message code="subject.name"/></form:label></td>
				<td>
					<form:input path="name" class="inputbig required"/>
					<form:errors path="name" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="parentSubject"><spring:message code="subject.parentSubject"/></form:label></td>
				<td>
					<form:select path="parentSubject" class="myform inputlarge">
						<form:options itemLabel="label" itemValue="id" items="${listSubject}"/>
					</form:select>
					<form:errors path="parentSubject" class="errorMsg"/>
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