package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.Post;
import databaseManagement.EntityController;


@WebServlet("/RSSHandler")
public class RSSHandler extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contextPath = getServletContext().getRealPath("/");

		String xmlFilePath=contextPath+"rss.xml";

		System.out.println(xmlFilePath);

		File myfile = new File(xmlFilePath);

		//myfile.createNewFile();
		
		PrintWriter writer = new PrintWriter(myfile, "UTF-8");
		
		
		writer.println("<?xml version='1.0' encoding='utf-8' ?>");
		writer.println("");
		writer.println("<rss version=\"2.0\">");
		writer.println("<channel>");
		writer.println("<title>PoRT posts</title>");
		writer.println("<link>http://localhost:8081/PoRT/index.html</link>");
		writer.println("<description>Disaster posts</description>");
		writer.println("<language>en-us</language>");
		
		EntityController controller = new EntityController();
		ArrayList<Post> posts = controller.getPosts("valid_posts");
		for (Post post : posts) {
			writer.println("<item>");
			writer.println("<title>"+post.getTitle() +"</title>");
			writer.println("<description>"+post.getDescription() +"</description>");
			writer.println("<link>http://localhost:8081/PoRT/post.jsp?index="+post.getId()+"</link>");
			writer.println("<guid>"+post.getId()+"</guid>");
			writer.println("</item>");
			System.out.println("MERE");
			}	
		writer.println("</channel>");
		writer.println("</rss>");
		writer.close();
		
		
		response.sendRedirect("admin_data.jsp");
	}

}
