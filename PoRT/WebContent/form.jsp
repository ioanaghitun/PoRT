<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>Submit raport</title>
    <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="css/smallMap.css"/>
	<link rel="stylesheet" type="text/css" href="css/form.css"/>
	<script src="leaflet/leaflet.js"></script>
	<script src="scripts/form.js"></script>
    <link rel="stylesheet" type="text/css" href="leaflet/leaflet.css"/>
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
		<div class="wholeForm">
		<form action="InsertValidPost">
    		<ul>
        		<li class="c1">
            		<strong> Short description: </strong>
            		<br>
            		<input id="title" class="title" type="text" placeholder="Short description" required name="title">
        		</li>
        		<li class="c1">
            		<strong> Description: </strong>
            		<br>
            		<textarea id="description" placeholder="Add your description here..." required name="description"></textarea>
        		</li>
        		<li class="c1">
            		<strong> Check all the forms of pollution that apply to your case: </strong>
            		<br>
            		<input type="checkbox"  name="1"> Air pollution
            		<br>
            		<input type="checkbox" name="2"> Light pollution
            		<br>
            		<input type="checkbox" name="3"> Littering
            		<br>
            		<input type="checkbox" name="4"> Noise pollution
            		<br>
            		<input type="checkbox" name="5"> Soil contamination
            		<br>
            		<input type="checkbox" name="6"> Radioactive contamination
            		<br>
            		<input type="checkbox" name="7"> Thermal pollution
            		<br>
            		<input type="checkbox" name="8"> Visual pollution
            		<br>
            		<input type="checkbox" name="9"> Water pollution
            		<br>
            		<input type="checkbox" name="10"> Other
        		</li>
        		<li class="c1">
            		<strong> Date and time of incident: </strong>
            		<br>
            		<input id="date" type="date" required name="date">
            		<input id="time" type="time" required name="time">
        		</li>
        		<li class="c1">
            		<strong> Latitude and longitude of the address: </strong><br>
               	 	<div class="coordinates">
                  		<input id="latitudine" type="number" step=any placeholder="Latitude" required name="latitude">
                    	<span class="updateButton">
                        	<input id="updateB" type="button" value="Update" onclick="updateMap();">
                    	</span><br>
                    	<input id="longitudine" type="number" step=any placeholder="Longitude" required name="longitude">
                    	<div id="map"></div>
                	</div>
        		</li>
        		<li class="c1">
            		<strong> E-mail address to confirm the validity of the data sent: </strong>
            		<br>
            		<input id="email" type="email" name="email" placeholder="name@gmail.com" required name="email">
        		</li>
        		<li class="c1">
            		<input type="submit" value="Submit">
        		</li>
    		</ul>
		</form>
		<button class="c2" onclick="verifica()">Verify</button>
		</div>
	</div>
	<script src="scripts/map.js"></script>
</body>
</html>