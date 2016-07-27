<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Menu Item (Add New)</h2>

<form:form id="menuItemAddForm" method="post" modelAttribute="menuItem">
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="name"><spring:message code="menuItem.name"/></form:label></td>
				<td>
					<form:input path="name" class="inputlarge required"/>
					<form:errors path="name" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="menuType"><spring:message code="menuItem.menuType"/></form:label></td>
				<td>
					<form:select path="menuType" class="myform inputbig">
						<form:option value="externalUrl">External URL</form:option>
						<form:option value="fixedArticle">Fixed Article</form:option>
						<form:option value="categoryBlog">Category Blog</form:option>
					</form:select>
					<form:errors path="menuType" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="externalUrl"><spring:message code="menuItem.externalUrl"/></form:label></td>
				<td>
					<form:input path="externalUrl" class="inputlarge"/>
					<form:errors path="externalUrl" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="targetWindow"><spring:message code="menuItem.targetWindow"/></form:label></td>
				<td>
					<form:input path="targetWindow" class="inputsmall"/>
					<form:errors path="targetWindow" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="article"><spring:message code="article"/></form:label></td>
				<td>
					<form:select path="article" class="myform inputlarge">
						<form:options itemValue="id" itemLabel="title" items="${listArticle}"/>
					</form:select>
					<form:errors path="article" class="errorMsg"/>
				</td>
			</tr>
			<tr>	
				<td><form:label path="articleCategory"><spring:message code="articleCategory"/></form:label></td>
				<td>
					<form:select path="articleCategory" class="myform inputlarge">
						<form:options itemValue="id" itemLabel="name" items="${listArticleCategory}"/>
					</form:select>
					<form:errors path="articleCategory" class="errorMsg"/>
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