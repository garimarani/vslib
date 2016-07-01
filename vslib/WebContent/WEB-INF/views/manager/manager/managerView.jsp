<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<script type="text/javascript">

	$(function() {
		$( "#itemmenu" ).buttonset();
	});

</script>

<h2 class="contentTitle">Manager (View Details)</h2>

<div id="itemmenu" style="font-size: 9px; margin-top: 10px; display: inline;">
	<ul class="tmenu">
		<li><a href="<c:url value="/manager/manager/addNew"/>">Manager (Add New)</a></li>
		<li><a href="<c:url value="/manager/manager/edit/${manager.id}"/>">Group (Edit)</a></li>
		<li><a href="<c:url value="/manager/manager/listAll"/>">Manager (List All)</a></li>
	</ul>
</div>

	<table class="vsform">
		<tbody>
			<tr>	
				<td><label><spring:message code="manager.uid"/></label></td>
				<td>
					${manager.uid}
				</td>
			</tr>
			<tr>	
				<td><label><spring:message code="salutation"/></label></td>
				<td>
					${manager.salutation.code}
				</td>	
				<td><label><spring:message code="manager.firstName"/></label></td>
				<td>
					${manager.firstName}
				</td>
			</tr>
			<tr>	
				<td><label><spring:message code="manager.middleName"/></label></td>
				<td>
					${manager.middleName}
				</td>	
				<td><label><spring:message code="manager.lastName"/></label></td>
				<td>
					${manager.lastName}
				</td>
			</tr>
			<tr>	
				<td><label><spring:message code="address.locationOne"/></label></td>
				<td>
					${manager.address.locationOne}
				</td>
				<td><label><spring:message code="address.locationTwo"/></label></td>
				<td>
					${manager.address.locationTwo}
				</td>
			</tr>
			<tr>	
				<td><label><spring:message code="address.city"/></label></td>
				<td>
					${manager.address.city}
				</td>
				<td><label><spring:message code="address.pin"/></label></td>
				<td>
					${manager.address.pin}
				</td>
			</tr>
			<tr>	
				<td><label><spring:message code="address.state"/></label></td>
				<td>
					${manager.address.state}
				</td>
				<td><label><spring:message code="address.country"/></label></td>
				<td>
					${manager.address.country}
				</td>
			</tr>
			<tr>	
				<td><label><spring:message code="address.phone"/></label></td>
				<td>
					${manager.address.phone}
				</td>
				<td><label><spring:message code="address.facsimile"/></label></td>
				<td>
					${manager.address.facsimile}
				</td>
			</tr>
			<tr>	
				<td><label><spring:message code="manager.email"/></label></td>
				<td colspan="3">
					${manager.email}
				</td>
			</tr>
		</tbody>
	</table>
<br/><br>
<h2 class="contentTitle">Manager Groups</h2>
<form:form id="managerGroupAddForm" method="post" action="./managerGroup" modelAttribute="managerGroup">
	<form:hidden path="manager"/>
	<table class="vsform">
		<tr>
			<td>
				<form:label path="group">Select Group</form:label>
			</td>
			<td>
				<form:select path="group" class="myform inputbig">
					<form:options itemLabel="label" itemValue="id" items="${listVslibGroup}"/>
				</form:select>
			</td>
			<td>
				<input type="submit" id="buttonSubmit" value=" Submit "/>
			</td>
		</tr>
	</table>
</form:form>

<table class="dataTable" style="width: 700px;">
	<thead>
		<tr>
			<th style="width: 100px;"><spring:message code="vslibGroup.code"/></th>
			<th><spring:message code="vslibGroup.name"/></th>
			<th width="35px">Select</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listManagerGroup}" var="mg">
			<tr>
				<td>
					${mg.group.code}
				</td>
				<td>
					${mg.group.name}
				</td>
				<td>
					<ul id="icons" class="ui-widget ui-helper-clearfix">
						<li class="ui-state-default ui-corner-all" title="Delete"><a
							href="<c:url value="/manager/managerGroup/delete/${mg.id}"/>"><span
								class="ui-icon ui-icon-trash"></span></a></li>
					</ul>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br/>
<h2 class="contentTitle">Manager Roles</h2>
<form:form id="managerRoleAddForm" method="post" action="./managerRole" modelAttribute="managerRole">
	<form:hidden path="manager"/>
	<table class="vsform">
		<tr>
			<td>
				<form:label path="role">Select Group</form:label>
			</td>
			<td>
				<form:select path="role" class="myform inputbig">
					<form:options itemLabel="label" itemValue="id" items="${listVslibRole}"/>
				</form:select>
			</td>
			<td>
				<input type="submit" id="buttonReset" value=" Submit "/>
			</td>
		</tr>
	</table>
</form:form>

<table class="dataTable" style="width: 700px;">
	<thead>
		<tr>
			<th style="width: 100px;"><spring:message code="vslibRole.code"/></th>
			<th><spring:message code="vslibRole.name"/></th>
			<th width="35px">Select</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listManagerRole}" var="mr">
			<tr>
				<td>
					${mr.role.code}
				</td>
				<td>
					${mr.role.name}
				</td>
				<td>
					<ul id="icons" class="ui-widget ui-helper-clearfix">
						<li class="ui-state-default ui-corner-all" title="Delete"><a
							href="<c:url value="/manager/managerRole/delete/${mr.id}"/>"><span
								class="ui-icon ui-icon-trash"></span></a></li>
					</ul>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />