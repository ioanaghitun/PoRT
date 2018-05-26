<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="application/rss+xml"
    pageEncoding="ISO-8859-1"%>
<rss version="2.0">
<channel>
<title>PoRT Posts</title>
<link></link>
<description>Postari dezastre</description> 
<ttl>30</ttl>
<language>ro-ro</language>

<%@ page import="java.util.ArrayList"%>
		<%@ page import="databaseManagement.EntityController"%>
		<%@ page import="Data.Post"%>
		<%
			EntityController controller = new EntityController();
			ArrayList<Post> posts = controller.getPosts("valid_posts");
			for (Post post : posts) {
				
		%>	
<item>
<title><%=post.getTitle()%></title>
<description> <%=post.getDescription()%> </description>
<link>http://localhost:8081/PoRT/post.jsp&index=<%=post.getId()%></link>
<guid><%=post.getId()%></guid>
</item>
<%
			}
		%>	
</channel>
</rss>