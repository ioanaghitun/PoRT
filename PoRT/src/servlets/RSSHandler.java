package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.Post;
import databaseManagement.EntityController;


@WebServlet("/RSSHandler")
public class RSSHandler extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String whereTo = request.getParameter("where");
		
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
		writer.println("<link>http://localhost:8085/PoRT/index.html</link>");
		writer.println("<description>Disaster posts</description>");
		writer.println("<language>en-us</language>");
		
		EntityController controller = new EntityController();
		ArrayList<Post> posts = controller.getPosts("valid_posts");
		for (Post post : posts) {
			writer.println("<item>");
			writer.println("<title>"+post.getTitle() +"</title>");
			writer.println("<description>"+post.getDescription() +"</description>");
			writer.println("<link>http://localhost:8085/PoRT/post.jsp?index="+post.getId()+"</link>");
			writer.println("<guid>"+post.getId()+"</guid>");
			writer.println("</item>");
			}	
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		writer.println("<pubdate>"+dateFormat.format(date)+"</pubdate>");
		writer.println("</channel>");
		writer.println("</rss>");
		writer.close();
		
		if(whereTo.equals("posted"))
		    response.sendRedirect("admin_data_posted.jsp");
		else
			response.sendRedirect("admin_data.jsp");
	}

}
