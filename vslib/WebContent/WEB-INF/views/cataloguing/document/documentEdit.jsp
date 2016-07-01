<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Document (Edit Record)</h2>

<form:form id="documentEditForm" method="post" modelAttribute="document">
	<form:hidden path="id"/>
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="uniformTitle"><spring:message code="document.uniformTitle"/></form:label></td>
				<td>
					<form:textarea path="uniformTitle" class="inputlarge required"/>
					<form:errors path="uniformTitle" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="primaryAuthor"><spring:message code="document.primaryAuthor"/></form:label></td>
				<td>
					<form:textarea path="primaryAuthor" class="inputlarge required"/>
					<form:errors path="primaryAuthor" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="secondaryAuthors"><spring:message code="document.secondaryAuthors"/></form:label></td>
				<td>
					<form:textarea path="secondaryAuthors" class="inputlarge"/>
					<form:errors path="secondaryAuthors" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="isbn"><spring:message code="document.isbn"/></form:label></td>
				<td>
					<form:input path="isbn" class="inputbig"/>
					<form:errors path="isbn" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="edition"><spring:message code="document.edition"/></form:label></td>
				<td>
					<form:input path="edition" class="inputbig"/>
					<form:errors path="edition" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="publicationYear"><spring:message code="document.publicationYear"/></form:label></td>
				<td>
					<form:input path="publicationYear" class="inputsmall"/>
					<form:errors path="publicationYear" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="coverPrice"><spring:message code="document.coverPrice"/></form:label></td>
				<td>
					<form:input path="coverPrice" class="inputsmall"/>
					<form:errors path="coverPrice" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="publisher"><spring:message code="document.publisher"/></form:label></td>
				<td>
					<form:textarea path="publisher" class="inputlarge"/>
					<form:errors path="publisher" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="seriesStatement"><spring:message code="document.seriesStatement"/></form:label></td>
				<td>
					<form:textarea path="seriesStatement" class="inputlarge"/>
					<form:errors path="seriesStatement" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="copyright"><spring:message code="document.copyright"/></form:label></td>
				<td>
					<form:textarea path="copyright" class="inputlarge"/>
					<form:errors path="copyright" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="summary"><spring:message code="document.summary"/></form:label></td>
				<td>
					<form:textarea path="summary" class="inputlarge"/>
					<form:errors path="summary" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="keywords"><spring:message code="document.keywords"/></form:label></td>
				<td>
					<form:textarea path="keywords" class="inputlarge"/>
					<form:errors path="keywords" class="errorMsg"/>
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