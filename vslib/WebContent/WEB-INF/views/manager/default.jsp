<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Manager Module</h2>

For the maintenance of Manager accounts.
<br/><br/>
<h3>Sub-Modules</h3>

<ul style="margin: 10px; padding: 10px;">
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Group</b> - for maintenance of Groups for Managers.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Manager</b> - for maintenance of Manager accounts.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Role</b> - for maintenance of Roles. Role is used by the system for
	 granting appropriate access rights to the managers.</li>
</ul>
<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />