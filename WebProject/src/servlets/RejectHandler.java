package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseManagement.EntityController;

/**
 * Servlet implementation class RejectHandler
 */
@WebServlet("/RejectHandler")
public class RejectHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityController controller = new EntityController();
		int id=Integer.parseInt(request.getParameter("index"));
		if(request.getParameter("table").equals("valid")) {
		controller.deletePost("valid_posts", id);
		response.sendRedirect("admin_data_posted.jsp");
		}
		else{
			controller.deletePost("unchecked_posts", id);
			response.sendRedirect("admin_data.jsp");
		}
			
		
	}

	

}
