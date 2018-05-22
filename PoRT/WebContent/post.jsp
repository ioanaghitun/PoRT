<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Post</title>
    <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/menu.css" />
    <link rel="stylesheet" type="text/css" href="css/smallMap.css" />
    <link rel="stylesheet" type="text/css" href="css/post.css" />
    <script src="leaflet/leaflet.js"></script>
    <link rel="stylesheet" type="text/css" href="leaflet/leaflet.css" />
</head>
<body>
	<nav>
    <ul id="navigationMenu">
        <li>
            <a class="home" href="index.html">
                <span>Home</span>
            </a>
        </li>
        <li>
            <a class="map" href="map.jsp">
                <span>Map</span>
            </a>
        </li>
        <li>
            <a class="data" href="data.jsp">
                <span>Data</span>
            </a>
        </li>
        <li>
            <a class="add" href="form.jsp">
                <span>Add</span>
            </a>
        </li>
        <li>
            <a class="help" href="help.html">
                <span>Help</span>
            </a>
        </li>
    </ul>
	</nav>
    <div class="content"> 
    	<ul class="post">
    		<%@ page import="java.util.ArrayList"%>
			<%@ page import="databaseManagement.EntityController"%>
			<%@ page import="Data.Post"%>
			<%
				EntityController controller = new EntityController();
				Post post = controller.getPost("valid_posts", Integer.parseInt(request.getParameter("index")));
			%>
        	<li class="title">
            	<%=post.getTitle()%>
        	</li>
        	<li>
            	<%=post.getDescription()%></li>
        	<li>
           		<strong> Date and time of incident: </strong>
           		<%=post.getIncidentDate()%>
        	</li>
        	<li class="loc">
            	<strong>Location of incident:</strong>
            	<div class="coordinates">
            		<br>
               		<input id="latitudine" type="number" value=<%=post.getLatitude()%> readonly> <i>(latitude)</i>
                	<br>
                	<input id="longitudine" type="number" value=<%=post.getLongitude()%> readonly> <i>(longitude)</i>    
            	</div>
				<div id="map"></div>
        	</li>
        	<li>
            	<ul class="tag">
                	<li id="tagList">tags:</li>
                	<%
						for (Integer integer : post.getTags()) {
					%>
					<li><%=controller.getTagName(integer)%>,</li>
					<%
						}
					%>
            	</ul> 
        	</li>
         	<li>
            	<a href="http://www.facebook.com/sharer.php?u=link" target="_blank"><img class="shortcut" src="img/facebook.png" alt="Facebook"></a>
            	<a href="https://twitter.com/share?url=link" target="_blank"><img class="shortcut" src="img/twitter.png" alt="Twitter"></a>
            	<a href="DownloadHandler?index=<%= post.getId() %>&dType=HTML"><img class="download" src="img/download-html.jpg" alt="Download HTML"></a>
            	<a href="DownloadHandler?index=<%= post.getId() %>&dType=CSV"><img class="download" src="img/download-csv.jpg" alt="Download CSV"></a>
            	<a href="DownloadHandler?index=<%= post.getId() %>&dType=PDF"><img class="download" src="img/download-pdf.png" alt="Download PDF"></a>
        	</li>
    	</ul>
    </div>
    <script src="scripts/map.js"></script>
	<script> addMarker(); updateMap();</script>
</body>
</html>