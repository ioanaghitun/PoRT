<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Admin data checker</title>
<link href="https://fonts.googleapis.com/css?family=Arvo"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/admin_data.css">
<link rel="stylesheet" type="text/css" href="css/admin_menu.css">
</head>
<body>
	<nav>
		<ul id="navigationMenu">
			<li>
				<a class="unverifiedPost" href="admin_data.jsp"><span>Unverified posts</span></a>
			</li>
			<li>
				<a class="verifiedPost" href="admin_data_posted.jsp"><span>Verified posts</span></a>
			</li>
		</ul>
	</nav>
	<div class="content">
		<form action="SearchHandler?page=admin_data">
			<ul id="choseTag">
				<li>
					<select name="search" id="search">
						<option value="0">All</option>
						<option value="1">Air pollution</option>
						<option value="2">Light pollution</option>
						<option value="3">Littering</option>
						<option value="4">Noise pollution</option>
						<option value="5">Soil contamination</option>
						<option value="6">Radioactive contamination</option>
						<option value="7">Thermal pollution</option>
						<option value="8">Visual pollution</option>
						<option value="9">Water pollution</option>
						<option value="10">Other</option>
					</select>
				</li>
				<li>
					<span class="searchButton"> <input type="submit" value="Search" id="SearchB"></span>
				</li>
			</ul>
		</form>
		<ul id="dataList">
			<%@ page import="java.util.ArrayList"%>
			<%@ page import="databaseManagement.EntityController"%>
			<%@ page import="Data.Post"%>
			<%
				EntityController controller = new EntityController();
				ArrayList<Post> posts = controller.getPosts("unchecked_posts");
				int tag=0;
				if(request.getParameter("tag")!=null){
					tag=Integer.parseInt(request.getParameter("tag"));
				}
				for (Post post : posts) {
					if(post.getTags().contains(tag) || tag==0){
			%>
			<li class="raport">
				<ul>
					<li>
						<a href="admin_post.jsp?index=<%=post.getId()%>"><h3 class="title"><%=post.getTitle()%></h3></a>
					</li>
					<li>
						<p>
							<%=post.getDescription()%>
						</p>
					</li>
					<li>
						<ul class="tag">
							<li>
								<b><i>tags:</i></b>
							</li>
						<%
							for (Integer integer : post.getTags()) {
						%>
							<li>
								<%=controller.getTagName(integer)%>,
							</li>
						<%
							}
						%>
						</ul>
					</li>
					<li class="buttons"><a
						href="BanHandler?email=<%=post.getEmail()%>&index=<%=post.getId()%>"><img
							class="shortcut" src="img/mark-ban.png" alt="ban"></a> <a
						href="RejectHandler?index=<%=post.getId()%>&table=unchecked"><img
							class="shortcut" src="img/mark-bad.jpg" alt="decline"></a> <a
						href="AcceptHandler?index=<%=post.getId()%>"><img
							class="shortcut" src="img/mark-good.jpg" alt="accept"></a></li>
				</ul>
			</li>
			<%
				}
			}
		%>
		</ul>
	</div>
</body>
</html>