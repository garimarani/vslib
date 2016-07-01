<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Circulation Module</h2>

For the maintenance of patron accounts and circulation of items among patrons.
<br/><br/>
<h3>Sub-Modules</h3>

<ul style="margin: 10px; padding: 10px;">
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Search Patron</b> - searching in the patron records.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Patron</b> - for maintenance of patron records.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Check-in Item</b> - for check-in of items.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Item View</b> - for searching and viewing item details.</li>
</ul>
<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />