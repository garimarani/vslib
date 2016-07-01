<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Subject - (List All)</h2>

<table class="dataTable" style="width: 750px;">
	<thead>
		<tr>
			<th style="width: 200px;"><spring:message code="subject.code"/></th>
			<th><spring:message code="subject.name"/></th>
			<th style="width: 250;"><spring:message code="subject.parentSubject"/></th>
			<th width="80px">Select</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listSubject}" var="lb">
			<tr>
				<td>
					${lb.code}
				</td>
				<td>
					${lb.name}
				</td>
				<td>
					${lb.parentSubject.label}
				</td>
				<td>
					<ul id="icons" class="ui-widget ui-helper-clearfix">
						<li class="ui-state-default ui-corner-all" title="Edit"><a
							href="<c:url value="/setup/subject/edit/${lb.id}"/>"><span
								class="ui-icon ui-icon-pencil"></span></a></li>
						<li class="ui-state-default ui-corner-all" title="Delete"><a
							href="<c:url value="/setup/subject/delete/${lb.id}"/>" onclick="return getConfirmation();"><span
								class="ui-icon ui-icon-trash"></span></a></li>
					</ul>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="4">
				<table>
					<tr>
						<td
							style="text-align: right; border-top: 0px; vetical-align: center;">
							<ul id="icons" class="ui-widget ui-helper-clearfix">
								<c:if test="${!firstPage}">
									<li class="ui-state-default ui-corner-all"
										title="To first page."><a
										href="<c:url value="/setup/subject/listAll"/>"><span
											class="ui-icon ui-icon-arrowthickstop-1-w"></span></a></li>

									<li class="ui-state-default ui-corner-all"
										title="To previous page."><a
										href="<c:url value="/setup/subject/listAll/previous"/>"><span
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
										href="<c:url value="/setup/subject/listAll/next"/>"><span
											class="ui-icon ui-icon-arrowthick-1-e"></span></a></li>
									<li class="ui-state-default ui-corner-all"
										title="To last page."><a
										href="<c:url value="/setup/subject/listAll/last"/>"><span
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