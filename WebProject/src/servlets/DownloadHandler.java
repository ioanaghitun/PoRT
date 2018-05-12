package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.FileCreator;
import Data.Post;
import databaseManagement.EntityController;

@WebServlet("/DownloadHandler")
public class DownloadHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String downloadType = request.getParameter("dType");
		EntityController controller = new EntityController();
		Post post = controller.getPost("valid_posts", Integer.parseInt(request.getParameter("index")));
		FileCreator creator = new FileCreator();
		String filePath;
		if (downloadType.equals("PDF")) {
			filePath = creator.createPDF(post);
		} else if (downloadType.equals("CSV")) {
			filePath = creator.createCSV(post);
		} else if (downloadType.equals("HTML")) {
			filePath = creator.createHTML(post);
		} else {
			response.sendRedirect("index.html");
			return;
		}
		File downloadFile = new File(filePath);
		FileInputStream inStream = new FileInputStream(downloadFile);

		ServletContext context = getServletContext();
		String mimeType = context.getMimeType(filePath);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		response.setHeader(headerKey, headerValue);
		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inStream.close();
		outStream.close();
		creator.deleteFile(filePath);

	}
}
