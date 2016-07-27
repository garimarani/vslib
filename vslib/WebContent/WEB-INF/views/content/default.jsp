<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Contents Module</h2>

For the maintenance of the following:
<br/><br/>
<h3>Sub-Modules</h3>

<ul style="margin: 10px; padding: 10px;">
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Article</b> - for maintenance of article records.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Article Category</b> - for maintenance of article category records.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Menu Item</b> - for maintenance of menu item records.</li>
</ul>
<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />