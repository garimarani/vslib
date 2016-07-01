<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<h2 class="contentTitle">Setup Module</h2>

For the maintenance of various parameters required by the system.
<br/><br/>
<h3>Sub-Modules</h3>

<ul style="margin: 10px; padding: 10px;">
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Fine Category</b> - for maintenance of fine categories.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Gender</b> - for maintenance of gender records.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Item Type</b> - for maintenance of item types viz. book, report, journal issue, etc.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Language</b> - for maintenance of language codes.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Library</b> - for maintenance of library records.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Library Branch</b> - for maintenance of library branches.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Library Type</b> - for maintenance of library type records viz. research library, public library, student library, etc.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Parameters</b> - for setting up of global parameters.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Patron Category</b> - for maintenance of patron categories.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Patron Group</b> - for maintenance of patron group records for the purpose of arranging patrons in various groups.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Salutation</b> - for maintenance of salutation records.</li>
	<li style="padding-top: 3px; padding-bottom: 3px;"><b>Subject</b> - for maintenance of subject headings.</li>
</ul>
<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />