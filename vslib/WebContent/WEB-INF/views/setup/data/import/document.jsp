<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Data Import (Item)</h2>

<form:form id="dataImportItemForm" method="post" enctype="multipart/form-data" modelAttribute="itemDataUploadForm">
	<table class="vsform">
		<tbody>
			<tr>
				<td><form:label path="file"><spring:message code="iduf.file"/></form:label></td>
				<td colspan="3">
					<form:input path="file" type="file" class="inputlarge required"/>
					<form:errors path="file" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="fieldDelimiter"><spring:message code="iduf.fieldDelimiter"/></form:label></td>
				<td>
					<form:input path="fieldDelimiter" class="inputsmall required"/>
					<form:errors path="fieldDelimiter" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="textQualifier"><spring:message code="iduf.textQualifier"/></form:label></td>
				<td>
					<form:input path="textQualifier" class="inputsmall required"/>
					<form:errors path="textQualifier" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align: center; padding-top: 5px; padding-botton: 5px; background-color: #EEEEEE;"><b><spring:message code="Please specify the position of fields."/></b></td>
			</tr>
			<tr>	
				<td><form:label path="uniformTitle"><spring:message code="document.uniformTitle"/></form:label></td>
				<td>
					<form:input path="uniformTitle" class="inputsmall required"/>
					<form:errors path="uniformTitle" class="errorMsg"/>
				</td>
				<td><form:label path="primaryAuthor"><spring:message code="document.primaryAuthor"/></form:label></td>
				<td>
					<form:input path="primaryAuthor" class="inputsmall required"/>
					<form:errors path="primaryAuthor" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="secondaryAuthors"><spring:message code="document.secondaryAuthors"/></form:label></td>
				<td>
					<form:input path="secondaryAuthors" class="inputsmall"/>
					<form:errors path="secondaryAuthors" class="errorMsg"/>
				</td>
				<td><form:label path="isbn"><spring:message code="document.isbn"/></form:label></td>
				<td>
					<form:input path="isbn" class="inputsmall"/>
					<form:errors path="isbn" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="edition"><spring:message code="document.edition"/></form:label></td>
				<td>
					<form:input path="edition" class="inputsmall"/>
					<form:errors path="edition" class="errorMsg"/>
				</td>
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
				<td><form:label path="publisher"><spring:message code="document.publisher"/></form:label></td>
				<td>
					<form:input path="publisher" class="inputsmall"/>
					<form:errors path="publisher" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="seriesStatement"><spring:message code="document.seriesStatement"/></form:label></td>
				<td>
					<form:input path="seriesStatement" class="inputsmall"/>
					<form:errors path="seriesStatement" class="errorMsg"/>
				</td>
				<td><form:label path="copyright"><spring:message code="document.copyright"/></form:label></td>
				<td>
					<form:input path="copyright" class="inputsmall"/>
					<form:errors path="copyright" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="summary"><spring:message code="document.summary"/></form:label></td>
				<td>
					<form:input path="summary" class="inputsmall"/>
					<form:errors path="summary" class="errorMsg"/>
				</td>
				<td><form:label path="keywords"><spring:message code="document.keywords"/></form:label></td>
				<td>
					<form:input path="keywords" class="inputsmall"/>
					<form:errors path="keywords" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="barcodeNumber"><spring:message code="item.barcodeNumber"/></form:label></td>
				<td>
					<form:input path="barcodeNumber" class="inputsmall required"/>
					<form:errors path="barcodeNumber" class="errorMsg"/>
				</td>
				<td><form:label path="classNumber"><spring:message code="item.classNumber"/></form:label></td>
				<td>
					<form:input path="classNumber" class="inputsmall"/>
					<form:errors path="classNumber" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="itemType"><spring:message code="item.itemType"/></form:label></td>
				<td>
					<form:input path="itemType" class="inputsmall"/>
					<form:errors path="itemType" class="errorMsg"/>
				</td>
				<td><form:label path="libraryBranch"><spring:message code="item.libraryBranch"/></form:label></td>
				<td>
					<form:input path="libraryBranch" class="inputsmall"/>
					<form:errors path="libraryBranch" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="subject"><spring:message code="item.subject"/></form:label></td>
				<td>
					<form:input path="subject" class="inputsmall"/>
					<form:errors path="subject" class="errorMsg"/>
				</td>
				<td><form:label path="language"><spring:message code="item.language"/></form:label></td>
				<td>
					<form:input path="language" class="inputsmall"/>
					<form:errors path="language" class="errorMsg"/>
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
				<td colspan="4" style="text-align: center; padding-top: 5px; padding-botton: 5px; background-color: #EEEEEE;"><b><spring:message code="Setting Defaults"/></b></td>
			</tr>
			<tr>	
				<td><form:label path="defaultItemType"><spring:message code="itemType"/></form:label></td>
				<td colspan="3">
					<form:select path="defaultItemType" class="myform inputlarge">
						<form:options itemLabel="label" itemValue="id" items="${listItemType}"/>
					</form:select>
					<form:errors path="defaultItemType" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="defaultLibraryBranch"><spring:message code="libraryBranch"/></form:label></td>
				<td colspan="3">
					<form:select path="defaultLibraryBranch" class="myform inputlarge">
						<form:options itemLabel="label" itemValue="id" items="${listLibraryBranch}"/>
					</form:select>
					<form:errors path="defaultLibraryBranch" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="defaultSubject"><spring:message code="subject"/></form:label></td>
				<td colspan="3">
					<form:select path="defaultSubject" class="myform inputlarge">
						<form:options itemLabel="label" itemValue="id" items="${listSubject}"/>
					</form:select>
					<form:errors path="defaultSubject" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="defaultLanguage"><spring:message code="language"/></form:label></td>
				<td colspan="3">
					<form:select path="defaultLanguage" class="myform inputlarge">
						<form:options itemLabel="label" itemValue="id" items="${listLanguage}"/>
					</form:select>
					<form:errors path="defaultLanguage" class="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="reset" id="buttonReset" value=" Reset "/>
					&nbsp;&nbsp;&nbsp;<input type="submit" id="buttonSubmit" value=" Submit "/>
				</td>
			</tr>
		</tbody>
	</table>
</form:form>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />