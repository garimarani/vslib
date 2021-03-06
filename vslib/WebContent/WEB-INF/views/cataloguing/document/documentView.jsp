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

<h2 class="contentTitle">Document (View Details)</h2>

<div id="itemmenu" style="font-size: 9px; margin-top: 10px; display: inline;">
	<ul class="tmenu">
		<li><a href="<c:url value="/cataloguing/document/addNew"/>">Document (Add New)</a></li>
		<li><a href="<c:url value="/cataloguing/document/edit/${document.id}"/>">Document (Edit)</a></li>
		<li><a href="<c:url value="/cataloguing/item/addNew/${document.id}"/>">Add Item</a></li>
	</ul>
</div>

<table class="vsform">
	<tbody>
		<tr>	
			<td><label><spring:message code="document.uniformTitle"/></label></td>
			<td>
				${document.uniformTitle}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="document.primaryAuthor"/></label></td>
			<td>
				${document.primaryAuthor}
			</td>
		</tr>
		<tr>
			<td><label><spring:message code="document.secondaryAuthors"/></label></td>
			<td>
				${document.secondaryAuthors}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="document.isbn"/></label></td>
			<td>
				${document.isbn}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="document.edition"/></label></td>
			<td>
				${document.edition}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="document.publicationYear"/></label></td>
			<td>
				${document.publicationYear}
			</td>
		</tr>
		<tr>	
			<td><label><spring:message code="document.coverPrice"/></label></td>
			<td>
				${document.coverPrice}
			</td>
		</tr>
		<tr>
			<td><label><spring:message code="document.publisher"/></label></td>
			<td>
				${document.publisher}
			</td>
		</tr>
		<tr>
			<td><label><spring:message code="document.seriesStatement"/></label></td>
			<td>
				${document.seriesStatement}
			</td>
		</tr>
		<tr>
			<td><label><spring:message code="document.copyright"/></label></td>
			<td>
				${document.copyright}
			</td>
		</tr>
		<tr>
			<td><label><spring:message code="document.summary"/></label></td>
			<td>
				${document.summary}
			</td>
		</tr>
		<tr>
			<td><label><spring:message code="document.keywords"/></label></td>
			<td>
				${document.keywords}
			</td>
		</tr>
	</tbody>
</table>

<h2 class="contentTitle">Item List</h2>

<table class="dataTable">
	<thead>
		<tr>
			<th style="width: 100px;"><spring:message code="item.barcodeNumber"/></th>
			<th><spring:message code="item.classNumber"/></th>
			<th style="width: 100px;"><spring:message code="itemType"/></th>
			<th style="width: 100px;"><spring:message code="libraryBranch"/></th>
			<th style="width: 100px;"><spring:message code="subject"/></th>
			<th style="width: 100px;"><spring:message code="language"/></th>
			<th style="width: 80px;">Select</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${!empty document.items}">
			<c:forEach items="${document.items}" var="item">
				<tr>
					<td>
						${item.barcodeNumber}
					</td>
					<td>
						${item.classNumber}
					</td>
					<td>
						${item.itemType.code}
					</td>
					<td>
						${item.libraryBranch.code}
					</td>
					<td>
						${item.subject.code}
					</td>
					<td>
						${item.language.code}
					</td>
					<td>
						<ul id="icons" class="ui-widget ui-helper-clearfix">
							<li class="ui-state-default ui-corner-all" title="Edit">
								<a href="<c:url value="/cataloguing/item/edit/${item.id}"/>">
									<span class="ui-icon ui-icon-pencil"></span>
								</a>
							</li>
							<li class="ui-state-default ui-corner-all" title="Delete">
								<a href="<c:url value="/cataloguing/item/delete/${item.id}"/>" onclick="return getConfirmation();">
									<span class="ui-icon ui-icon-trash"></span>
								</a>
							</li>
						</ul>
					</td>
				</tr>
			</c:forEach>			
		</c:if>
	</tbody>
</table>
<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />