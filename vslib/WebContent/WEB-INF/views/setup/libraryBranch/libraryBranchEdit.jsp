<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Library Branch (Edit)</h2>

<form:form id="libraryBranchEditForm" method="post" modelAttribute="libraryBranch">
	<form:hidden path="id"/>
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="code"><spring:message code="libraryBranch.code"/></form:label></td>
				<td>
					<form:input path="code" class="inputsmall required"/>
					<form:errors path="code" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="name"><spring:message code="libraryBranch.name"/></form:label></td>
				<td>
					<form:input path="name" class="inputbig required"/>
					<form:errors path="name" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="library"><spring:message code="library"/></form:label></td>
				<td>
					<form:select path="library" class="myform inputlarge">
						<form:options itemValue="id" itemLabel="label" items="${listLibrary}"/>
					</form:select>
					<form:errors path="library" class="errorMsg"/>
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
				<td><form:label path="contactPersonName"><spring:message code="libraryBranch.contactPersonName"/></form:label></td>
				<td>
					<form:input path="contactPersonName" class="inputlarge"/>
					<form:errors path="contactPersonName" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="email"><spring:message code="libraryBranch.email"/></form:label></td>
				<td>
					<form:input path="email" class="inputlarge"/>
					<form:errors path="email" class="errorMsg"/>
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