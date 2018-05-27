package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseManagement.EntityController;

@WebServlet("/VerifyHandler")
public class VerifyHandler extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String raspuns="";
		String description=request.getParameter("description");
		String title=request.getParameter("title");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		String longitude=request.getParameter("longitude");
		String latitude=request.getParameter("latitude");
		String email=request.getParameter("email");
		
		String errorDesc="";
		String errorTitle="";
		String errorDate="";
		String errorTime="";
		String errorLong="";
		String errorLat="";
		String errorEmail="";
		
		if(date.length()==0)
			raspuns+="\nYou did not enter the date";
		if(time.length()==0)
			raspuns+="\nYou did not enter the time";
		if(latitude.length()==0)
			raspuns+="\nYou did not enter the latitude";
		if(longitude.length()==0)
			raspuns+="\nYou did not enter the longitude";
		if(title.length()<10)
			raspuns+="\nThe title is too short";
		if(description.length()<50)
			raspuns+="\nThe description is too short";
	    if(email.length()==0) 
	    	raspuns+="\nYou did not enter the email";
	    else {
	    EntityController controller = new EntityController();
		if (controller.checkBanUser(email))
			  errorEmail="\nYour email is banned";
	    }
	    if(raspuns.equals(""))
	    	raspuns="Success";
	    ServletOutputStream stream=response.getOutputStream();
	    stream.print(raspuns);
	    
	}

}
