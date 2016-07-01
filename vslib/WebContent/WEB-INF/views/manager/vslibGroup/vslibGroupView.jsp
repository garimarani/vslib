<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<script type="text/javascript">

	$(function() {
		$( "#inputDate" ).datepicker({ dateFormat: "dd-mm-yy", changeMonth: true, changeYear: true });
		$( "#itemmenu" ).buttonset();
	});

</script>

<h2 class="contentTitle">Group (View Details)</h2>

<div id="itemmenu" style="font-size: 9px; margin-top: 10px; display: inline;">
	<ul class="tmenu">
		<li><a href="<c:url value="/manager/group/addNew"/>">Group (Add New)</a></li>
		<li><a href="<c:url value="/manager/group/edit/${vslibGroup.id}"/>">Group (Edit)</a></li>
		<li><a href="<c:url value="/manager/group/listAll"/>">Group (List All)</a></li>
	</ul>
</div>
	<table class="vsform">
		<tbody>
			<tr>	
				<td><label><spring:message code="vslibGroup.code"/></label></td>
				<td>
					${vslibGroup.code}
				</td>
			</tr>
			<tr>	
				<td><label><spring:message code="vslibGroup.name"/></label></td>
				<td>
					${vslibGroup.name}
				</td>
			</tr>
		</tbody>
	</table>
<br/><br>

<h2 class="contentTitle">Groups Roles</h2>

<form:form id="vslibGroupAddRoleForm" method="post" modelAttribute="groupRole">
	<form:hidden path="group" value="${vslibGroup.id}"/>
	<table class="vsform">
		<tbody>
			<tr>	
				<td><label>Select Role To Add</label></td>
				<td>
					<form:select path="role" class="myform imputlarge">
						<form:options itemLabel="label" itemValue="id" items="${listVslibRole}"/>
					</form:select>
					<form:errors path="role" class="errorMsg"/>
				</td>
				<td>
					<input type="submit" id="buttonSubmit" value=" Submit "/>
				</td>
			</tr>
		</tbody>
	</table>
</form:form>
<table class="dataTable" style="width: 350px;">
	<thead>
		<tr>
			<th style="width: 100px;"><spring:message code="vslibRole.code"/></th>
			<th><spring:message code="vslibRole.name"/></th>
			<th width="35px">Select</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listGroupRole}" var="groupRole">
			<tr>
				<td>
					${groupRole.role.code}
				</td>
				<td>
					${groupRole.role.name}
				</td>
				<td>
					<ul id="icons" class="ui-widget ui-helper-clearfix">
						<li class="ui-state-default ui-corner-all" title="Delete"><a
							href="<c:url value="/manager/groupRole/delete/${groupRole.id}"/>"><span
								class="ui-icon ui-icon-trash"></span></a></li>
					</ul>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />