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

		String description=request.getParameter("description");
		String title=request.getParameter("title");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		String longitude=request.getParameter("longitude");
		String latitude=request.getParameter("latitude");
		String email=request.getParameter("email");
		System.out.println(title+date+description+time+longitude+latitude+email);
		
		String errorDesc="";
		String errorTitle="";
		String errorDate="";
		String errorTime="";
		String errorLong="";
		String errorLat="";
		String errorEmail="";
		
		if(date.length()==0)
			errorDate="Introdu Data";
		if(time.length()==0)
			errorLong="Introdu timp";
		if(latitude.length()==0)
			errorLat="Introdu Latitude";
		if(longitude.length()==0)
			errorLong="Introdu Longitude";
		if(title.length()<10)
			errorTitle="Titlu prea scurt";
		if(description.length()<50)
			errorDesc="Descriere prea scurta";
	    if(email.length()==0) 
	    	errorEmail="Email lipsa";
	    else {
	    EntityController controller = new EntityController();
		if (controller.checkBanUser(email))
			  errorEmail="Email banat";
	    }
	    String raspuns="";
	    if(errorDesc !="")
	    	raspuns=raspuns+"<p>"+errorDesc+"</p>";
	    if(errorTitle !="")
	    	raspuns=raspuns+"<p>"+errorTitle+"</p>";
	    if(errorDate !="")
	    	raspuns=raspuns+"<p>"+errorDate+"</p>";
	    if(errorTime !="")
	    	raspuns=raspuns+"<p>"+errorTime+"</p>";
	    if(errorLat !="")
	    	raspuns=raspuns+"<p>"+errorLat+"</p>";
	    if(errorLong !="")
	    	raspuns=raspuns+"<p>"+errorLong+"</p>";
	    if(errorEmail !="")
	    	raspuns=raspuns+"<p>"+errorEmail+"</p>";
	    
	    System.out.println(raspuns);
	    ServletOutputStream stream=response.getOutputStream();
	    stream.print(raspuns);
	    
	}

}
