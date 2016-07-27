<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Article Category (Add New)</h2>

<form:form id="articleCategoryAddForm" method="post" modelAttribute="articleCategory">
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="name"><spring:message code="articleCategory.name"/></form:label></td>
				<td>
					<form:input path="name" class="inputlarge required"/>
					<form:errors path="name" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="description"><spring:message code="articleCategory.description"/></form:label></td>
				<td>
					<form:textarea path="description" class="inputlarge"/>
					<form:errors path="description" class="errorMsg"/>
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