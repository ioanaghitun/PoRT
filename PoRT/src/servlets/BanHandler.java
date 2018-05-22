package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseManagement.EntityController;

/**
 * Servlet implementation class BanHandler
 */
@WebServlet("/BanHandler")
public class BanHandler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityController controller = new EntityController();
		int id = Integer.parseInt(request.getParameter("index"));
		String email = request.getParameter("email");
		controller.banUser(email);
		controller.deletePost("unchecked_posts", id);
		response.sendRedirect("admin_data.jsp");
	}
}
