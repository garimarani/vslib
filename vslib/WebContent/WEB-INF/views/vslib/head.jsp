<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8" />
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<title><fmt:message key="title"/></title>
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/default/css/style.css"/>" />
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/templates/default/css/start/jquery-ui-1.10.4.custom.css"/>" />
	
	<script src="<c:url value="/templates/default/js/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value="/templates/default/js/jquery-ui-1.9.2.custom.js"/>"></script>
	<script src="<c:url value="/templates/js/jquery-ui-timepicker-addon.js"/>"></script>
	
	<script>
		$(document).ready(function(){
			$("input[type='text']:first").focus();
			
			$( "#topmenu" ).buttonset();
			$( "#topmenu1" ).buttonset();
			
			$( "#buttonGo" ).button();
			$( "#go" ).button();
			$( "#buttonSubmit" ).button();
			$( "#buttonReset" ).button();
		});
		
		function getConfirmation(){
			return confirm("Are you sure!");
		}
		
	</script>
</head>

<body>

<div id="wrapper">

	<header id="header">
		<table style="padding: 0px; margin: 0px">
			<tr>
				<td>
					<img src="<c:url value="/images/vslib-logo.png"/>" width="75px;"/>
				</td>
				<td>
					<h1 style="font-size: 16px;"><fmt:message key="header"/></h1>
					<span style="font-size:12px;"><fmt:message key="sub-header"/></span>
				</td>
			</tr>
		</table>	
		<div id="topmenu">
			<ul>
				<li><a href="<c:url value="/"/>">Home</a></li>
				<jsp:include page="/WEB-INF/views/topMenu.jsp" />
		      	<sec:authorize access="!isAuthenticated()">
		      		<li><a href="<c:url value="/login"/>">Sign-In</a></li>
		      	</sec:authorize>
			  	<sec:authorize access="isAuthenticated()">
		    		<li><a href="<c:url value="/j_spring_security_logout"/>">Sign-Out</a></li>
		      	</sec:authorize>
			</ul>
		</div>
	</header><!-- #header-->

	<section id="middle">

		<div id="container">
			<div id="content">
				<c:if test='${not empty message}'>
					<div class="ui-widget">
						<div class="ui-state-highlight ui-corner-all" style="margin: 20px; padding: 0 .7em;">
							<p style="line-height: 200%; vertical-align: center;">
								<span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em; margin-top: .4em;"></span>
								${message}
							</p>
						</div>
					</div>
				</c:if>
				<br/>