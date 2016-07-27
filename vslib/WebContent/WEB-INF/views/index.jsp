<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<c:if test="${!empty listArticle}">
	<c:forEach items="${listArticle}" var="lb">
		<h2 class="contentTitle">${lb.title}</h2>
		<div>Date: <fmt:formatDate value="${lb.addDate.time}" pattern="dd-MM-yyyy"/></div>
		<div style="text-align: justify;">
			${lb.articleContent}
		</div>
	</c:forEach>
</c:if>

<c:if test="${empty listArticle}">
	<h2 class="contentTitle">Welcome</h2>
	
	Library Management System
	
	<br/><br/>
	<h3>Sub-Modules</h3>
	
	<ul style="margin: 10px; padding: 10px;">
		<li style="padding-top: 3px; padding-bottom: 3px;"><b>Cataloguing Module</b> - for managing catalogs.</li>
		<li style="padding-top: 3px; padding-bottom: 3px;"><b>Circulation Module</b> - for managing Patrons and circulation of items.</li>
		<li style="padding-top: 3px; padding-bottom: 3px;"><b>Report Module</b> - for preparing various reports.</li>
		<li style="padding-top: 3px; padding-bottom: 3px;"><b>Setup Module</b> - for setting various parameters required for proper functioning of the documents.</li>
		<li style="padding-top: 3px; padding-bottom: 3px;"><b>Manager Module</b> - for the maintenance of Manager accounts.</li>
	</ul>
</c:if>
<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />  