<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />		

<h2 class="contentTitle">Login</h2>

<form id="loginForm" name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
	<table class="vsform">
    	<tr>
    		<td><label>User:</label></td>
    		<td><input id="focussed" type='text' name='j_username' class="inputbig required"/></td>
    	</tr>
        <tr>
        	<td><label>Password:</label></td>
        	<td><input id="password" type='password' name='j_password' class="inputbig required"></td>
        </tr>
        <tr>
        	<td><input name="reset" type="reset" value=" Reset " id="buttonReset"></td>
        	<td><input name="submit" type="submit" value=" Login " id="buttonSubmit"></td>
        </tr>
   </table>
</form>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" /> 

