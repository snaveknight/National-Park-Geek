<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>National Park Geek</title>
<c:url value="/css/npGeek.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref }">
</head>

<body>
	<header>
		<c:url value="/" var="parksHomePageHref" />
		<c:url value="/img/logo.png" var="logoSrc" />
		<a href="${parksHomePageHref }">
			<img src="${logoSrc }" alt="National Park Geek Logo" />
		</a>
	</header>
	<nav>
	<ul>
		<c:url value="/" var="parksHomePageURL" />
		<li><a href="${parksHomePageURL }">Home</a></li>
		<!-- make survey url later  -->
		<c:url value="/survey" var="surveyURL" />
		<li><a href="${surveyURL }">Survey</a></li>
	</ul>
	</nav>

