<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Advertisement (Edit Details)</h2>

<form:form id="advertsAddForm" method="post" modelAttribute="adverts">
	<form:hidden path="id"/>
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="name"><spring:message code="adverts.name"/></form:label></td>
				<td>
					<form:input path="name" class="inputlarge required"/>
					<form:errors path="name" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="location"><spring:message code="adverts.location"/></form:label></td>
				<td>
					<form:input path="location" class="inputsmall required"/>
					<form:errors path="location" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="value"><spring:message code="adverts.value"/></form:label></td>
				<td>
					<form:textarea path="value" class="inputlarge required"/>
					<form:errors path="value" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="published"><spring:message code="adverts.published"/></form:label></td>
				<td>
					<form:select path="published" class="myform inputsmall">
						<form:option value="0">False</form:option>
						<form:option value="1">True</form:option>
					</form:select>
					<form:errors path="published" class="errorMsg"/>
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