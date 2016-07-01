<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Library (Add New)</h2>

<form:form id="libraryAddForm" method="post" modelAttribute="library">
	<form:hidden path="id"/>
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="code"><spring:message code="library.code"/></form:label></td>
				<td>
					<form:input path="code" class="inputsmall required"/>
					<form:errors path="code" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="name"><spring:message code="library.name"/></form:label></td>
				<td>
					<form:input path="name" class="inputbig required"/>
					<form:errors path="name" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="libraryType"><spring:message code="libraryType"/></form:label></td>
				<td>
					<form:select path="libraryType" class="myform inputlarge">
						<form:options itemValue="id" itemLabel="label" items="${listLibraryType}"/>
					</form:select>
					<form:errors path="libraryType" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="address.locationOne"><spring:message code="address.locationOne"/></form:label></td>
				<td>
					<form:input path="address.locationOne" class="inputlarge required"/>
					<form:errors path="address.locationOne" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="address.locationTwo"><spring:message code="address.locationTwo"/></form:label></td>
				<td>
					<form:input path="address.locationTwo" class="inputlarge"/>
					<form:errors path="address.locationTwo" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="address.city"><spring:message code="address.city"/></form:label></td>
				<td>
					<form:input path="address.city" class="inputbig required"/>
					<form:errors path="address.city" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="address.pin"><spring:message code="address.pin"/></form:label></td>
				<td>
					<form:input path="address.pin" class="inputsmall"/>
					<form:errors path="address.pin" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="address.state"><spring:message code="address.state"/></form:label></td>
				<td>
					<form:input path="address.state" class="inputbig"/>
					<form:errors path="address.state" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="address.country"><spring:message code="address.country"/></form:label></td>
				<td>
					<form:input path="address.country" class="inputbig"/>
					<form:errors path="address.country" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="address.phone"><spring:message code="address.phone"/></form:label></td>
				<td>
					<form:input path="address.phone" class="inputbig"/>
					<form:errors path="address.phone" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="address.facsimile"><spring:message code="address.facsimile"/></form:label></td>
				<td>
					<form:input path="address.facsimile" class="inputbig"/>
					<form:errors path="address.facsimile" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="about"><spring:message code="library.about"/></form:label></td>
				<td>
					<form:textarea path="about" class="inputlarge"/>
					<form:errors path="about" class="errorMsg"/>
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