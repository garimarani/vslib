<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Patron Profile</h2>

For the patrons, helping them know about their participation in the library.
<br/><br/>
<h3>Sub-Modules</h3>

<ul style="margin: 10px; padding: 10px;">
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Get My Details</b> - patrons can see their profile.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Check Out History</b> - patrons can view the documents that they have borrowed in the past.</li>
</ul>
<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />