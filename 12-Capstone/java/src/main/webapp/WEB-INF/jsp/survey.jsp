<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/parksHeader.jsp" />


<title>Insert title here</title>
<section id="survey-form">
<form action="favorites" method="post">
Park Code:<br> <select name="parkCode">
	<c:forEach var="park" items="${parks }">
		<option value=<c:out value="${park.parkCode }"/>><c:out 
		value="${park.parkName }"></c:out>
	</c:forEach>
</select><br>
<input type="email" name="emailAddress">
<br>
<select>



</select>




</form>





</section>

<c:import url="/WEB-INF/jsp/common/parksFooter.jsp" />