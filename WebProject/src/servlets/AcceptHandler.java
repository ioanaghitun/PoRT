package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.Post;
import databaseManagement.EntityController;

/**
 * Servlet implementation class AcceptHandler
 */
@WebServlet("/AcceptHandler")
public class AcceptHandler extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityController controller = new EntityController();
		int id=Integer.parseInt(request.getParameter("index"));
		Post post=controller.getPost("unchecked_posts", id);
		controller.deletePost("unchecked_posts", id);
		try {
			controller.insertPost("valid_posts", post);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("admin_data.jsp");
	}

	

}
