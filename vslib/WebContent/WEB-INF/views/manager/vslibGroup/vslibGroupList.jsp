<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Group - (List All)</h2>

<table class="dataTable" style="width: 500px;">
	<thead>
		<tr>
			<th style="width: 100px;"><spring:message code="vslibGroup.code"/></th>
			<th><spring:message code="vslibGroup.name"/></th>
			<th width="110px">Select</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listVslibGroup}" var="lb">
			<tr>
				<td>
					${lb.code}
				</td>
				<td>
					${lb.name}
				</td>
				<td>
					<ul id="icons" class="ui-widget ui-helper-clearfix">
						<li class="ui-state-default ui-corner-all" title="View Details">
							<a href="<c:url value="/manager/group/view/${lb.id}"/>">
								<span class="ui-icon ui-icon-folder-open"></span>
							</a>
						</li>
						<li class="ui-state-default ui-corner-all" title="Edit">
							<a href="<c:url value="/manager/group/edit/${lb.id}"/>">
								<span class="ui-icon ui-icon-pencil"></span>
							</a>
						</li>
						<li class="ui-state-default ui-corner-all" title="Delete">
							<a href="<c:url value="/manager/group/delete/${lb.id}"/>" onclick="return getConfirmation();">
								<span class="ui-icon ui-icon-trash"></span>
							</a>
						</li>
					</ul>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="3">
				<table>
					<tr>
						<td
							style="text-align: right; border-top: 0px; vetical-align: center;">
							<ul id="icons" class="ui-widget ui-helper-clearfix">
								<c:if test="${!firstPage}">
									<li class="ui-state-default ui-corner-all"
										title="To first page."><a
										href="<c:url value="/manager/group/listAll"/>"><span
											class="ui-icon ui-icon-arrowthickstop-1-w"></span></a></li>

									<li class="ui-state-default ui-corner-all"
										title="To previous page."><a
										href="<c:url value="/manager/group/listAll/previous"/>"><span
											class="ui-icon ui-icon-arrowthick-1-w"></span></a></li>
								</c:if>
							</ul>
						</td>
						<td
							style="text-align: right; border-top: 0px; vetical-align: bottom;">
							<c:out value="${currentPage}" /> ... of ... <c:out
								value="${totalPages}" />
						</td>
						<td
							style="text-align: right; border-top: 0px; vetical-align: center;">
							<ul id="icons" class="ui-widget ui-helper-clearfix">
								<c:if test="${!lastPage}">
									<li class="ui-state-default ui-corner-all"
										title="To next page."><a
										href="<c:url value="/manager/group/listAll/next"/>"><span
											class="ui-icon ui-icon-arrowthick-1-e"></span></a></li>
									<li class="ui-state-default ui-corner-all"
										title="To last page."><a
										href="<c:url value="/manager/group/listAll/last"/>"><span
											class="ui-icon ui-icon-arrowthickstop-1-e"></span></a></li>
								</c:if>
							</ul>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</tfoot>
</table>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />