<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Manager (Edit)</h2>

<form:form id="managerEditForm" method="post" modelAttribute="manager">
	<form:hidden path="id"/>
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="uid"><spring:message code="manager.uid"/></form:label></td>
				<td>
					<form:input path="uid" class="inputsmall required"/>
					<form:errors path="uid" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="password"><spring:message code="manager.password"/></form:label></td>
				<td>
					<form:password path="password" class="inputsmall"/>
					<form:errors path="password" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="retypePassword"><spring:message code="manager.retypePassword"/></form:label></td>
				<td>
					<form:password path="retypePassword" class="inputsmall"/>
					<form:errors path="retypePassword" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="salutation"><spring:message code="salutation"/></form:label></td>
				<td>
					<form:select path="salutation" class="myform inputsmall">
						<form:options itemValue="id" itemLabel="code" items="${listSalutation}"/>
					</form:select>
					<form:errors path="salutation" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="firstName"><spring:message code="manager.firstName"/></form:label></td>
				<td>
					<form:input path="firstName" class="inputbig required"/>
					<form:errors path="firstName" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="middleName"><spring:message code="manager.middleName"/></form:label></td>
				<td>
					<form:input path="middleName" class="inputbig"/>
					<form:errors path="middleName" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="lastName"><spring:message code="manager.lastName"/></form:label></td>
				<td>
					<form:input path="lastName" class="inputbig required"/>
					<form:errors path="lastName" class="errorMsg"/>
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
				<td><form:label path="email"><spring:message code="manager.email"/></form:label></td>
				<td>
					<form:input path="email" class="inputbig"/>
					<form:errors path="email" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="accountNonLocked"><spring:message code="manager.accountNonLocked"/></form:label></td>
				<td>
					<form:select path="accountNonLocked" class="myform inputsmall">
						<form:option value="1" label="true"/>
						<form:option value="0" label="false"/>
					</form:select>
					<form:errors path="accountNonLocked" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="accountNonExpired"><spring:message code="manager.accountNonExpired"/></form:label></td>
				<td>
					<form:select path="accountNonExpired" class="myform inputsmall">
						<form:option value="1" label="true"/>
						<form:option value="0" label="false"/>
					</form:select>
					<form:errors path="accountNonExpired" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="enabled"><spring:message code="manager.enabled"/></form:label></td>
				<td>
					<form:select path="enabled" class="myform inputsmall">
						<form:option value="1" label="true"/>
						<form:option value="0" label="false"/>
					</form:select>
					<form:errors path="enabled" class="errorMsg"/>
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