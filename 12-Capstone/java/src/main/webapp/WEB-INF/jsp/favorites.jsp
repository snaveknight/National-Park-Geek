<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/parksHeader.jsp" />

<title>Insert title here</title>

<table>
	<c:forEach items="${parks}" var="parks">
		<tr>
			<td>
				<h3>${parks.parkName }</h3>
			</td>
			<td> 
	</td>
	</tr>
	</c:forEach>

			<c:import url="/WEB-INF/jsp/common/parksFooter.jsp" />