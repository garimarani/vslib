<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">New Arrivals List</h2>

<table class="dataTable">
	<thead>
		<tr>
			<th>Documents Retrieved</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listItem}" var="lb">
			<tr>
				<td>
					<b>Title / Series Statement</b>: ${lb.document.uniformTitle} / ${lb.document.seriesStatement} ...<a href="<c:url value="/newArrivals/document/view/${lb.document.id}"/>">View Details</a>
					<br/><b>Authors</b>: ${lb.document.primaryAuthor} / ${lb.document.secondaryAuthors}
					<br/><b>Edition</b>: ${lb.document.edition} <b>Publisher</b>: ${lb.document.publisher}
					<br/><b>Item Details</b>:(${item.barcodeNumber} :-: ${item.classNumber} :-: <c:if test="${empty item.checkOuts}">On-Shelf</c:if>
							<c:if test="${!empty item.checkOuts}">Checked-Out</c:if>)
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="1">
				<table>
					<tr>
						<td
							style="text-align: right; border-top: 0px; vetical-align: center;">
							<ul id="icons" class="ui-widget ui-helper-clearfix">
								<c:if test="${!firstPage}">
									<li class="ui-state-default ui-corner-all"
										title="To first page."><a
										href="<c:url value="/newArrivals/firstPage"/>"><span
											class="ui-icon ui-icon-arrowthickstop-1-w"></span></a></li>

									<li class="ui-state-default ui-corner-all"
										title="To previous page."><a
										href="<c:url value="/newArrivals/previous"/>"><span
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
										href="<c:url value="/newArrivals/next"/>"><span
											class="ui-icon ui-icon-arrowthick-1-e"></span></a></li>
									<li class="ui-state-default ui-corner-all"
										title="To last page."><a
										href="<c:url value="/newArrivals/last"/>"><span
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