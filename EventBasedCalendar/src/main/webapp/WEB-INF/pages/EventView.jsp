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
	
	<div align="center">
	
		<h1> Client's Id is  ${clientId}</h1>
	
	<table width="1000">
		<tr>
			
			<th>Event Id</th>  
			<th>Event Type</th>			
			<th>StartTimeDate</th><!--  should be ordered by from the class from where we r fetching...HQL-->
			<th>EndTimeDate</th>
			
			<th>place</th>
			
		</tr>
		<c:forEach items="${EventsList}" var="events">	
			<tr>
				<td>${events.eventId}</td>
				<td>${events.eventType}</td>
				<td>${events.startTimeDate}</td>
				<td>${events.endTimeDate}</td>
				<td>${events.place}</td>
						
			</tr>
		</c:forEach>
		
	</table>
	</div> 
</div>

</body>
</html>