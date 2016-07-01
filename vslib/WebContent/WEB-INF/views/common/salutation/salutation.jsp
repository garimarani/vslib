<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Salutation (Add New)</h2>

<form:form id="salutationAddForm" method="post" modelAttribute="salutation">
	<table class="vsform">
		<tbody>
			<tr>	
				<td><form:label path="code"><spring:message code="salutation.code"/></form:label></td>
				<td>
					<form:input path="code" class="inputsmall required"/>
					<form:errors path="code" class="errorMsg"/>
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
<h2 class="contentTitle">Salutation (List All)</h2>
<table class="dataTable" style="width: 350px;">
	<thead>
		<tr>
			<th><spring:message code="salutation.code"/></th>
			<th width="80px">Select</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listSalutation}" var="lb">
			<tr>
				<td>
					${lb.code}
				</td>
				<td>
					<ul id="icons" class="ui-widget ui-helper-clearfix">
						<li class="ui-state-default ui-corner-all" title="Edit"><a
							href="<c:url value="/setup/salutation/edit/${lb.id}"/>"><span
								class="ui-icon ui-icon-pencil"></span></a></li>
						<li class="ui-state-default ui-corner-all" title="Delete"><a
							href="<c:url value="/setup/salutation/delete/${lb.id}"/>" onclick="return getConfirmation();"><span
								class="ui-icon ui-icon-trash"></span></a></li>
					</ul>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />