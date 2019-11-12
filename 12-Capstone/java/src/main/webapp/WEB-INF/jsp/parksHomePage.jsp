<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/parksHeader.jsp" />

<title>Insert title here</title>
<section class="parkList">
	<table>
		<c:forEach items="${parksList}" var="parkslist">
			<tr>
				<td> <img src="img/${parkslist.parkcode }.jpg" />
				</td>
				
			</tr>
		</c:forEach>
	</table>
</section>
<c:import url="/WEB-INF/jsp/common/parksFooter.jsp" />