<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script>
  $(function() {
    $( "#leftmenu" ).menu();
  });
</script><br/><br/>
			</div><!-- #content-->
		</div><!-- #container-->

		<aside id="sideLeft">
			<div id="welcome">Welcome 
				<sec:authorize access="isAuthenticated()">
					<strong><sec:authentication property="principal.username"/></strong>!
				</sec:authorize>
				<sec:authorize access="!isAuthenticated()">
					<strong>Guest</strong>!
				</sec:authorize>
			</div>
			<br/><br/>
			<div>
				<ul id="leftmenu">
					<jsp:include page="/WEB-INF/views/${viewLeftMenu}.jsp" />
				</ul>
				<br/>
				<c:forEach items="${listLeftAdverts}" var="lb">
					<c:out value="${lb.value}" escapeXml="false"/>
				</c:forEach>
			</div><br/>
		</aside><!-- #sideLeft -->

	</section><!-- #middle-->

	<footer id="footer">
		<hr style="width: 200px; float: right;"/>
		<div class="copyright" style="float: right; margin-right: -150px; margin-top: 10px">
			&copy; <fmt:message key="copyright"/>
			<br/>
			<c:forEach items="${listBottomAdverts}" var="lb">
				<c:out value="${lb.value}" escapeXml="false"/>
			</c:forEach>
		</div>
	</footer><!-- #footer -->

</div><!-- #wrapper -->

</body>
</html>
