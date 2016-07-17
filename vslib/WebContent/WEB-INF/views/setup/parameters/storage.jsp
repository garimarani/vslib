<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Global Parameters (Storage Location)</h2>

<form:form id="parametersStorageForm" method="post" modelAttribute="vslibParams">
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="photosFolder"><spring:message code="vslibParams.photosFolder"/></form:label></td>
				<td>
					<form:input path="photosFolder" class="inputlarge"/>
					<form:errors path="photosFolder" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="edocsFolder"><spring:message code="vslibParams.edocsFolder"/></form:label></td>
				<td>
					<form:input path="edocsFolder" class="inputlarge"/>
					<form:errors path="edocsFolder" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="worksFolder"><spring:message code="vslibParams.worksFolder"/></form:label></td>
				<td>
					<form:input path="worksFolder" class="inputlarge"/>
					<form:errors path="worksFolder" class="errorMsg"/>
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