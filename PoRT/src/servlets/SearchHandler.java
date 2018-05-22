package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchHandler
 */
@WebServlet("/SearchHandler")
public class SearchHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String getUrl(String url) {
		String rasp = "";

		for (int i = 0; i < url.length(); i++) {
			if (url.charAt(i) == '?')
				break;
			rasp = rasp + url.charAt(i);
		}
		return rasp;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		String tag = request.getParameter("search");
		String next = getUrl(request.getHeader("referer")) + "?tag=" + tag;
		response.sendRedirect(next);
	}
}
