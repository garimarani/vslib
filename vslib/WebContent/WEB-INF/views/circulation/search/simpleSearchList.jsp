<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Patron Search List</h2>

<table class="dataTable">
	<thead>
		<tr>
			<th style="width: 100px;"><spring:message code="patron.number"/></th>
			<th><spring:message code="patron.name"/></th>
			<th style="width: 100px;"><spring:message code="patron.dateOfBirth"/></th>
			<th style="width: 200px;"><spring:message code="patron.email"/></th>
			<th width="110px">Select</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listPatron}" var="lb">
			<tr>
				<td>
					${lb.number}
				</td>
				<td>
					${lb.name}
				</td>
				<td>
					<fmt:formatDate value="${lb.dateOfBirth.time}" pattern="dd-MM-yyyy"/>
				</td>
				<td>
					${lb.email}
				</td>
				<td style="vertical-align: top;">
					<ul id="icons" class="ui-widget ui-helper-clearfix">
						<li class="ui-state-default ui-corner-all" title="View Details">
							<a href="<c:url value="/circulation/patron/view/${lb.id}"/>">
								<span class="ui-icon ui-icon-folder-open"></span>
							</a>
						</li>
						<li class="ui-state-default ui-corner-all" title="Edit">
							<a href="<c:url value="/circulation/patron/edit/${lb.id}"/>">
								<span class="ui-icon ui-icon-pencil"></span>
							</a>
						</li>
						<li class="ui-state-default ui-corner-all" title="Delete">
							<a href="<c:url value="/circulation/patron/delete/${lb.id}"/>" onclick="return getConfirmation();">
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
			<td colspan="5">
				<table>
					<tr>
						<td
							style="text-align: right; border-top: 0px; vetical-align: center;">
							<ul id="icons" class="ui-widget ui-helper-clearfix">
								<c:if test="${!firstPage}">
									<li class="ui-state-default ui-corner-all"
										title="To first page."><a
										href="<c:url value="/circulation/search/firstPage"/>"><span
											class="ui-icon ui-icon-arrowthickstop-1-w"></span></a></li>

									<li class="ui-state-default ui-corner-all"
										title="To previous page."><a
										href="<c:url value="/circulation/search/previous"/>"><span
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
										href="<c:url value="/circulation/search/next"/>"><span
											class="ui-icon ui-icon-arrowthick-1-e"></span></a></li>
									<li class="ui-state-default ui-corner-all"
										title="To last page."><a
										href="<c:url value="/circulation/search/last"/>"><span
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