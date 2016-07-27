<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="articleContentTitle">Article (Edit)</h2>

<form:form id="articleEditForm" method="post" modelAttribute="article">
	<form:hidden path="id"/>
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="title"><spring:message code="article.title"/></form:label></td>
				<td>
					<form:input path="title" class="inputlarge required"/>
					<form:errors path="title" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="category"><spring:message code="articleCategory"/></form:label></td>
				<td>
					<form:select path="category" class="myform inputlarge">
						<form:options itemValue="id" itemLabel="name" items="${listArticleCategory}"/>
					</form:select>
					<form:errors path="category" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="articleContent"><spring:message code="article.articleContent"/></form:label></td>
				<td>
					<form:textarea path="articleContent" rows="10" cols="50"/>
					<form:errors path="articleContent" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="published"><spring:message code="article.published"/></form:label></td>
				<td>
					<form:select path="published" class="inputsmall required">
						<form:option value="true">Yes</form:option>
						<form:option value="false">No</form:option>
					</form:select>
					<form:errors path="published" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="homePage"><spring:message code="article.homePage"/></form:label></td>
				<td>
					<form:select path="homePage" class="inputsmall required">
						<form:option value="false">No</form:option>
						<form:option value="true">Yes</form:option>
					</form:select>
					<form:errors path="homePage" class="errorMsg"/>
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