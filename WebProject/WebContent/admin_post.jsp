<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Admin post checker</title>
<link href="https://fonts.googleapis.com/css?family=Arvo"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/admin_post.css">
<link rel="stylesheet" type="text/css" href="css/smallMap.css">
<script src="leaflet/leaflet.js"></script>
<link rel="stylesheet" type="text/css" href="leaflet/leaflet.css">
</head>
<body>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="databaseManagement.EntityController"%>
	<%@ page import="Data.Post"%>
	<%
		EntityController controller = new EntityController();
		Post post = controller.getPost("unchecked_posts", Integer.parseInt(request.getParameter("index")));
	%>

	<ul class="raport">
		<li>
			<h3 class="title"><%=post.getTitle()%></h3>
		</li>
		<li><strong>Submitted by: </strong> <%=post.getEmail()%></li>
		<li>
			<p>
				<%=post.getDescription()%>
			</p>
		</li>
		<li><strong> Date and time of incident: </strong> <%=post.getIncidentDate()%>
		</li>
		<li class="loc"><strong>Location of incident:</strong>
			<div class="coordinates">
				<br> <input id="latitudine" type="number"
					value=<%=post.getLatitude()%> readonly> <i>(latitude)</i>
				<br> <input id="longitudine" type="number"
					value=<%=post.getLongitude()%> readonly> <i>(longitude)</i>
			</div>
			<div id="map"></div></li>
		<li>
			<ul class="tag">
				<li><b><i>tags:</i></b></li>
				<%
					for (Integer integer : post.getTags()) {
				%>

				<li><%=controller.getTagName(integer)%>,</li>

				<%
					}
				%>
			</ul>
		</li>
		<li class="buttons">
		<a href="BanHandler?email=<%= post.getEmail() %>&index=<%= post.getId() %>"><img class="shortcut" src="img/mark-ban.png" alt="ban"></a>
                <a href="RejectHandler?index=<%= post.getId() %>&table=unchecked"><img class="shortcut" src="img/mark-bad.jpg" alt="decline"></a>
                <a href="AcceptHandler?index=<%= post.getId() %>"><img class="shortcut" src="img/mark-good.jpg" alt="accept"></a>
		  </li>
	</ul>
	<script src="scripts/map.js"></script>
	<script> addMarker(); updateMap();</script>
</body>
</html>