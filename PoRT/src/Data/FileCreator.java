package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import databaseManagement.EntityController;

public class FileCreator {

	public String createCSV(Post post) {

		PrintWriter writer;
		EntityController controller= new EntityController();
		String filePath = "post" + post.getId() + ".csv";
		try {
			writer = new PrintWriter(filePath, "UTF-8");
			writer.println("Id,Title,Description,Incident Date,Publish Date,Latitude,Longitude,Email,Tags");
			
			String info = post.getId() + ",\"" + post.getTitle() + "\",\"" + post.getDescription() + "\","
					+ post.getIncidentDate() + "," + post.getPublishDate() + "," + post.getLatitude() + ","
					+ post.getLongitude() + "," + post.getEmail() + ",\"" ;
			for(Integer integer : post.getTags()) {
				info+=controller.getTagName(integer)+", ";
			}
			info+="\"";
			
			writer.println(info);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	public String createHTML(Post post) {
		PrintWriter writer;
		String filePath = "post" + post.getId() + ".html";
		try {
			writer = new PrintWriter(filePath, "UTF-8");
			writer.println("<!DOCTYPE html>");
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<title>Html report</title>");
			writer.println("</head>");
			writer.println("<body>");
			writer.println("<p>Titlu: " + post.getTitle() + "</p>");
			writer.println("<p>Descriere: " + post.getDescription() + "</p>");
			writer.println("<p>Data incident: " + post.getIncidentDate() + "</p>");
			writer.println("<p>Data publicarii: " + post.getPublishDate() + "</p>");
			writer.println(
					"<p>Latitudine: " + post.getLatitude() + "     Longitudine: " + post.getLongitude() + "</p>");
			writer.println("<p>Email: " + post.getEmail() + "</p>");
			writer.println("</body>");
			writer.println("</html>");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	public String createPDF(Post post) {
		String filePath = "post" + post.getId() + ".pdf";
		com.lowagie.text.Document document = new com.lowagie.text.Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		document.open();
		try {
			document.add(new Paragraph("Titlu: " + post.getTitle()));
			document.add(new Paragraph("Descriere: " + post.getDescription()));
			document.add(new Paragraph("Data incident: " + post.getIncidentDate()));
			document.add(new Paragraph("Data publicarii: " + post.getPublishDate()));
			document.add(new Paragraph("Latitudine: " + post.getLatitude()));
			document.add(new Paragraph("Longitudine " + post.getLongitude()));
			document.add(new Paragraph("Email: " + post.getEmail()));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
		return filePath;
	}

	public void deleteFile(String filePath) {
		File file = new File(filePath);
		file.delete();
	}
}
