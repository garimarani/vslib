<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />