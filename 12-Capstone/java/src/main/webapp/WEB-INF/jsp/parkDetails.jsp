<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/parksHeader.jsp" />

<title>Insert title here</title>

<section class="parkDetails">
	<c:url value="/img/parks/${details.parkCode }.jpg" var="image" />
	<img src="${image }" />
	<h3>${details.parkName }</h3>
	<p>${details.parkDescription }</p>
	<h3>${details.state }</h3>
	<h3>${details.acreage }</h3>
	<h3>${details.elevationInFeet }</h3>
	<h3>${details.milesOfTrail }</h3>
	<h3>${details.numberOfCampsites }</h3>
	<h3>${details.climate }</h3>
	<h3>${details.yearFounded }</h3>
	<h3>${details.annualVisitorCount }</h3>
	<h3>${details.inspirationalQuote }</h3>
	<h3>${details.inspirationalQuoteSource }</h3>
	<h3>${details.parkDescription }</h3>
	<h3>${details.entryFee }</h3>
	<h3>${details.numberOfAnimalSpecies }</h3>
</section>

<c:import url="/WEB-INF/jsp/common/parksFooter.jsp" />