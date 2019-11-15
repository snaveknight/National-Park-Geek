<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/parksHeader.jsp" />

<title>Insert title here</title>

<table>
	<c:forEach items="${favoriteparks}" var="favoriteparks">
		<tr>
			<td>
				<p class="fav-park">${favoriteparks.parkName }</p>
			</td>
			<td>
				<p class="fav-tally">${favoriteparks.favorites }</p>
			</td>
			<td><c:url value="/img/parks/${favoriteparks.parkCode }.jpg"
					var="image" /> <img class="fav-pic" src="${image }" /></td>
		</tr>
	</c:forEach>
</table>
<c:import url="/WEB-INF/jsp/common/parksFooter.jsp" />