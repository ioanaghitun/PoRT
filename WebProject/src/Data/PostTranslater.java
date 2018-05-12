package Data;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.http.HttpServletRequest;

import databaseManagement.EntityController;

public class PostTranslater {
	
	public Post createFromForm(HttpServletRequest form) {
		
		String title=form.getParameter("title");
		String description=form.getParameter("description");
		String date=form.getParameter("date")+" "+form.getParameter("time");
		Float latitude=Float.parseFloat(form.getParameter("latitude"));
		Float longitude=Float.parseFloat(form.getParameter("longitude"));
		String email=form.getParameter("email");
		
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String publishDate = now.format(formatter);

        EntityController controller=new EntityController();
        int id=0;
        try {
			id=controller.getNextAvailableId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Post post=new Post(id,title,description,date,publishDate,latitude,longitude,email);
        
        for(int i=1;i<=10;i++) {
        	if(form.getParameter(String.valueOf(i))!=null) {
        		post.addTag(i);
        	}
        }
 
		return post;
	}
	
	public int validatePost(Post post) {
		if(post.getTitle().length()<10)
			return 1;
		if( post.getDescription().length()<50 ) 
			return 2;
		
		if(post.getTags().size()==0)
			return 3;
		EntityController controller=new EntityController();
		if(controller.checkBanUser(post.getEmail()))
				return 4;
		
		return 0;
	}

}
