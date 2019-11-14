<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/parksHeader.jsp" />

<title>Insert title here</title>

<section class="parkDetails">

	<c:url value="/img/parks/${parkslist.parkCode }.jpg" var="image" />
	<img src="${image }" />
	<h2>${parkslist.parkName }- ${parkslist.state }</h2>
	<p>${parkslist.parkDescription }</p>
	<h3>Acreage: ${parkslist.acreage }</h3>
	<h3>Elevation: ${parkslist.elevationInFeet } feet</h3>
	<h3>Miles of trail: ${parkslist.milesOfTrail }</h3>
	<h3>Number of Campsites: ${parkslist.numberOfCampsites }</h3>
	<h3>Climate: ${parkslist.climate }</h3>
	<h3>Year founded: ${parkslist.yearFounded }</h3>
	<h3>Annual Visitors: ${parkslist.annualVisitorCount }</h3>
	<h3>Park Motto: ${parkslist.inspirationalQuote } -
		${parkslist.inspirationalQuoteSource }</h3>
	<h3>Entry Fee: $${parkslist.entryFee }</h3>
	<h3>Number Of Animal Species: ${parkslist.numberOfAnimalSpecies }</h3>

</section>

<!-- today, which will be monday , needs an image and high/low and also the advisory info-->
<section class="weatherForecast">

Your parks five day forecast starting with today and your weather advisory:
<br>
	<c:forEach items="${weatherList}" var="weatherlist">
	<c:set var="string1" value="${ weatherlist.foreCast }"/>
	<c:set var="string2" value="${ fn:replace(string1, ' ', '') }"/>
	<c:url value="/img/weather/${string2}.png" var="image" />
	<img src="${image }" />
	<br>
	<h2>High:  ${(weatherlist.high - 32) * (5 / 9)} C</h2>
	<h2>Low:  ${(weatherlist.low - 32) * (5 / 9)}  C</h2>
	
	</c:forEach>
		<a class="celsius-button"
		href="<c:url value="/parkDetails?parkCode=${parkslist.parkCode}"/>">
	<input type="button" value="farhenheit" />
						
				</a>
</section>






<c:import url="/WEB-INF/jsp/common/parksFooter.jsp" />