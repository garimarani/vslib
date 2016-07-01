<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
<li><a href="<c:url value="/setup/fineCategory/addNew"/>">Fine Category</a> 
	<ul>
		<li style="width: 100px;"><a href="<c:url value="/setup/fineCategory/listAll"/>">List All</a></li>
	</ul>
</li>
<li><a href="<c:url value="/setup/gender/addNew"/>">Gender</a></li>
<li><a href="<c:url value="/setup/itemType/addNew"/>">Item Type</a> 
	<ul>
		<li style="width: 100px;"><a href="<c:url value="/setup/itemType/listAll"/>">List All</a></li>
	</ul>
</li>
<li><a href="<c:url value="/setup/language/addNew"/>">Language</a> 
	<ul>
		<li style="width: 100px;"><a href="<c:url value="/setup/language/listAll"/>">List All</a></li>
	</ul>
</li>
<li><a href="<c:url value="/setup/library/addNew"/>">Library</a> 
	<ul>
		<li style="width: 100px;"><a href="<c:url value="/setup/library/listAll"/>">List All</a></li>
	</ul>
</li>
<li><a href="<c:url value="/setup/libraryBranch/addNew"/>">Library Branch</a> 
	<ul>
		<li style="width: 100px;"><a href="<c:url value="/setup/libraryBranch/listAll"/>">List All</a></li>
	</ul>
</li>
<li><a href="<c:url value="/setup/libraryType/addNew"/>">Library Type</a> 
	<ul>
		<li style="width: 100px;"><a href="<c:url value="/setup/libraryType/listAll"/>">List All</a></li>
	</ul>
</li>
<li><a href="<c:url value="/setup/parameters"/>">Parameters</a></li>
<li><a href="<c:url value="/setup/patronCategory/addNew"/>">Patron Category</a> 
	<ul>
		<li style="width: 100px;"><a href="<c:url value="/setup/patronCategory/listAll"/>">List All</a></li>
	</ul>
</li>
<li><a href="<c:url value="/setup/patronGroup/addNew"/>">Patron Group</a> 
	<ul>
		<li style="width: 100px;"><a href="<c:url value="/setup/patronGroup/listAll"/>">List All</a></li>
	</ul>
</li>
<li><a href="<c:url value="/setup/salutation/addNew"/>">Salutation</a></li>
<li><a href="<c:url value="/setup/subject/addNew"/>">Subject</a> 
	<ul>
		<li style="width: 100px;"><a href="<c:url value="/setup/subject/listAll"/>">List All</a></li>
	</ul>
</li>
</sec:authorize>