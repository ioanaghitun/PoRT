<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Admin post from website</title>
    <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/admin_post.css">
    <link rel="stylesheet" type="text/css" href="css/admin_menu.css">
    <link rel="stylesheet" type="text/css" href="css/smallMap.css">
    <script src="leaflet/leaflet.js"></script>
    <link rel="stylesheet" type="text/css" href="leaflet/leaflet.css">
</head>
<body>
<nav>
    <ul id="navigationMenu">
        <li>
            <a class="unverifiedPost" href="admin_data.jsp">
                <span>Unverified posts</span>
            </a>
        </li>
        <li>
            <a class="verifiedPost" href="admin_data_posted.jsp">
                <span>Verified posts</span>
            </a>
        </li>
    </ul>
</nav>
<div class="content">
    <%@ page import="java.util.ArrayList"%>
	<%@ page import="databaseManagement.EntityController"%>
	<%@ page import="Data.Post"%>
	<%
		EntityController controller = new EntityController();
		Post post = controller.getPost("valid_posts", Integer.parseInt(request.getParameter("index")));
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
                <a href="RejectHandler?index=<%= post.getId() %>&table=valid"><img class="shortcut" src="img/mark-bad.jpg" alt="decline"></a>
		  </li>
	</ul>
	</div>>
	<script src="scripts/map.js"></script>
	<script> addMarker(); updateMap();</script>
</body>
</html>
