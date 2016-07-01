<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="/WEB-INF/views/vslib/head.jsp" />

<script type="text/javascript" charset="utf-8">
		$().ready(function() {
			var opts = {
				cssClass : 'el-rte',
				// lang     : 'ru',
				height   : 300,
				width	 : 500,
				toolbar  : 'complete',
				cssfiles : ['css/elrte-inner.css']
			}
			$('#editor').elrte(opts);
			

			jQuery('input').keypress(function(event){
		        var enterOkClass =  jQuery(this).attr('class');
		        if (event.which == 13 && enterOkClass != 'enterSubmit') {
		            event.preventDefault();
		            return false;   
		        }
		    });
			
		});
</script>

<div id="editor">
Sanjay Singh
</div>

<jsp:include page="/WEB-INF/views/vslib/foot.jsp" />    						
