<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/parksHeader.jsp" />

<title>Insert title here</title>
<section class="parkList">
	<table>
		<c:forEach items="${parksList}" var="parkslist">
			<tr>
				<td>
				
				<c:url value="/img/parks/${parkslist.parkCode }.jpg" var="image"/> 
				<img src="${image }" />
				</td>
				<td> <h3>${parkslist.parkName }</h3></td>
				<td> <h3>${parkslist.parkDescription }</h3>
			</tr>
		</c:forEach>
	</table>
</section>
<c:import url="/WEB-INF/jsp/common/parksFooter.jsp" />