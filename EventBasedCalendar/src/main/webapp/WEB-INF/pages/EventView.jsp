<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/style1.css" />" rel="stylesheet">
<title>EventView</title>
</head>
<body>
	<div align="center" class="container">
		<h1> Client's Name is  ${clientName}</h1>
	<table width="1000">
		<tr>
			<th>Event</th>			
			<th>StartTimeDate</th><!--  should be ordered by from the class from where we r fetching...HQL-->
			<th>EndTimeDate</th>
 			<th>Edit Event</th>
		</tr>
		<c:forEach items="${EventsList}" var="events">	
			<tr>
				<td>${events.eventType}</td>
				<td>${events.startTimeDate}</td>
				<td>${events.endTimeDate}</td>	
<%-- 				<td><a href="updateEvent/${events.eventId}">Update</a></td> --%>
				<td><a href="${pageContext.request.contextPath}/deleteEvent/${events.eventId}/${clientId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</div> 
</body>
</html>