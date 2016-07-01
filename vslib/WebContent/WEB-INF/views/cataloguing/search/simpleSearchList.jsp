<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Document Search List</h2>

<table class="dataTable">
	<thead>
		<tr>
			<th>
				<spring:message code="document.uniformTitle"/>/ 
				<spring:message code="document.primaryAuthor"/>/ 
				<spring:message code="document.secondaryAuthors"/>
			</th>
			<th width="110px">Select</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listDocument}" var="lb">
			<tr>
				<td>
					${lb.uniformTitle} / 
					${lb.primaryAuthor} / 
					${lb.secondaryAuthors}
				</td>
				<td style="vertical-align: top;">
					<ul id="icons" class="ui-widget ui-helper-clearfix">
						<li class="ui-state-default ui-corner-all" title="View Details">
							<a href="<c:url value="/cataloguing/document/view/${lb.id}"/>">
								<span class="ui-icon ui-icon-folder-open"></span>
							</a>
						</li>
						<li class="ui-state-default ui-corner-all" title="Edit">
							<a href="<c:url value="/cataloguing/document/edit/${lb.id}"/>">
								<span class="ui-icon ui-icon-pencil"></span>
							</a>
						</li>
						<li class="ui-state-default ui-corner-all" title="Delete">
							<a href="<c:url value="/cataloguing/document/delete/${lb.id}"/>" onclick="return getConfirmation();">
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
			<td colspan="2">
				<table>
					<tr>
						<td
							style="text-align: right; border-top: 0px; vetical-align: center;">
							<ul id="icons" class="ui-widget ui-helper-clearfix">
								<c:if test="${!firstPage}">
									<li class="ui-state-default ui-corner-all"
										title="To first page."><a
										href="<c:url value="/cataloguing/search/firstPage"/>"><span
											class="ui-icon ui-icon-arrowthickstop-1-w"></span></a></li>

									<li class="ui-state-default ui-corner-all"
										title="To previous page."><a
										href="<c:url value="/cataloguing/search/previous"/>"><span
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
										href="<c:url value="/cataloguing/search/next"/>"><span
											class="ui-icon ui-icon-arrowthick-1-e"></span></a></li>
									<li class="ui-state-default ui-corner-all"
										title="To last page."><a
										href="<c:url value="/cataloguing/search/last"/>"><span
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