<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Data list</title>
    <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/menu.css" />
    <link rel="stylesheet" type="text/css" href="css/data.css" />
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
        <ul id="dataList">
        
       <li>
       <ul class="raport">
       <li>
       <%
		int error=Integer.parseInt(request.getParameter("error"));
if(error==1){
	%>
	Titlu
<% 	
}else if (error==2){
	%>
	Descirere
	<% 
}else if(error==3){
	%>
	Tags
	<% 
}else {
	%>
	Ban
<% 
}
	%>
	</li>
	</ul>
       </li>
                </ul>


    </div>
</body>
</html>   
