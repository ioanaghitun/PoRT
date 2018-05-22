package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.FileCreator;
import Data.Post;
import Data.PostTranslater;
import databaseManagement.EntityController;

/**
 * Servlet implementation class InsertValidPost
 */
@WebServlet("/InsertValidPost")
public class FormHandler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PostTranslater translater = new PostTranslater();
		EntityController controller = new EntityController();
		Post post = translater.createFromForm(request);
		int error;
		if ((error = translater.validatePost(post)) == 0) {
			try {
				controller.insertPost("unchecked_posts", post);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("index.html");
		} else {
			response.sendRedirect("error_submit.jsp?error=" + error);
		}
	}
}
