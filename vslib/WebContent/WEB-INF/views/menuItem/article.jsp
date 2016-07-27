<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">${article.title}</h2>
<div>Date: <fmt:formatDate value="${article.addDate.time}" pattern="dd-MM-yyyy"/></div>
<div style="text-align: justify;">
	${article.articleContent}
</div>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />