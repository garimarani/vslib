<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Item (Add New)</h2>

<form:form id="itemAddForm" method="post" modelAttribute="item">
	<form:hidden path="document"/>
	<table class="vsform">
		<tbody>
			<tr>	
				<td><label><spring:message code="document.uniformTitle"/></label></td>
				<td>
					${item.document.uniformTitle}
				</td>
			</tr>
			<tr>	
				<td><label><spring:message code="document.primaryAuthor"/></label></td>
				<td>
					${item.document.primaryAuthor}
				</td>
			</tr>
			<tr>
				<td><form:label path="barcodeNumber"><spring:message code="item.barcodeNumber"/></form:label></td>
				<td>
					<form:input path="barcodeNumber" class="inputbig required"/>
					<form:errors path="barcodeNumber" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="classNumber"><spring:message code="item.classNumber"/></form:label></td>
				<td>
					<form:input path="classNumber" class="inputbig"/>
					<form:errors path="classNumber" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="alternateId"><spring:message code="item.alternateId"/></form:label></td>
				<td>
					<form:input path="alternateId" class="inputsmall"/>
					<form:errors path="alternateId" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="itemType"><spring:message code="item.itemType"/></form:label></td>
				<td>
					<form:select path="itemType" class="myform inputlarge">
						<form:options itemLabel="label" itemValue="id" items="${listItemType}"/>
					</form:select>
					<form:errors path="itemType" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="libraryBranch"><spring:message code="item.libraryBranch"/></form:label></td>
				<td>
					<form:select path="libraryBranch" class="myform inputlarge">
						<form:options itemLabel="label" itemValue="id" items="${listLibraryBranch}"/>
					</form:select>
					<form:errors path="libraryBranch" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="subject"><spring:message code="item.subject"/></form:label></td>
				<td>
					<form:select path="subject" class="myform inputlarge">
						<form:options itemLabel="label" itemValue="id" items="${listSubject}"/>
					</form:select>
					<form:errors path="subject" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="language"><spring:message code="item.language"/></form:label></td>
				<td>
					<form:select path="language" class="myform inputlarge">
						<form:options itemLabel="label" itemValue="id" items="${listLanguage}"/>
					</form:select>
					<form:errors path="language" class="errorMsg"/>
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