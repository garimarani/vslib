<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<!-- 
<c:forEach items="${articleList}" var="al">
	<h3 class="title"><c:out value="${al.title}"/></h3>
	<p>
		<br/><c:out escapeXml="false" value="${al.content}"/>
	</p>
</c:forEach>

<p class="sectionFooter">
	<c:if test="${!firstPage}">
		<a class="pagination" href="<c:url value="/listAll"/>">|&lt;</a>
		<a class="pagination" href="<c:url value="/listAll/previous"/>">&lt;</a>
	</c:if>
	<c:out value="${currentPage}"/> ... of ... <c:out value="${totalPages}"/>
	<c:if test="${!lastPage}">
		<a class="pagination" href="<c:url value="/listAll/next"/>">&gt;</a>
	</c:if>
</p>

-->
<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />  