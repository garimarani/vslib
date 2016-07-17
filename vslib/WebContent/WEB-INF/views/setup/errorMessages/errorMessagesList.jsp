<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Error Messages</h2>

<table class="dataTable" style="width: 750px;">
	<thead>
		<tr>
			<th style="width: 150px;"><spring:message code="Date"/></th>
			<th><spring:message code="Message"/></th>
			<th width="50px">Select</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listErrorMessages}" var="lb">
			<tr>
				<td>
					${lb.messageDate.time}
				</td>
				<td>
					${lb.shortMessage}
				</td>
				<td>
					<ul id="icons" class="ui-widget ui-helper-clearfix">
						<li class="ui-state-default ui-corner-all" title="View Details">
							<a href="<c:url value="/setup/errorMessages/view/${lb.id}"/>">
								<span class="ui-icon ui-icon-folder-open"></span>
							</a>
						</li>
					</ul>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />