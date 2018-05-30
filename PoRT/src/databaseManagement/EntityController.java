package databaseManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Post;
public class EntityController {
	
	public void insertPost(String table,Post post) throws SQLException {
     Connection connection=Database.getConnection();
		
		PreparedStatement pstmt = connection.prepareStatement("insert into "+table+" values ( ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, post.getId());
        	pstmt.setString(2, post.getTitle());
            pstmt.setString(3, post.getDescription());
            pstmt.setString(4, post.getIncidentDate());
            pstmt.setString(5, post.getPublishDate());
            pstmt.setFloat(6, post.getLatitude());
            pstmt.setFloat(7, post.getLongitude());
            pstmt.setString(8, post.getEmail());
            
            pstmt.executeUpdate();
        pstmt.close();
            
            	PreparedStatement tagPstmt = connection.prepareStatement("insert into pollution_tags values ( ?, ?)");
            	for(Integer tag : post.getTags()) {
            		tagPstmt.setInt(2,post.getId());
            		tagPstmt.setInt(1,tag);
            		tagPstmt.executeUpdate();
            	}
            	tagPstmt.close();
         
	}
	
	public Post getPost(String table, int index) {
		Connection connection=Database.getConnection();
		Statement statement;
		Post post=null;
		
			try {
				statement = connection.createStatement();
			
		ResultSet rs = statement.executeQuery("select * from "+table+" where id="+index);
		if(rs==null)
			return null;
		rs.next(); 
			post=new Post(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getFloat(7), rs.getString(8));
			Statement tagStatement=connection.createStatement();
			ResultSet tagRs = tagStatement.executeQuery("select id from pollution_tags where post_id="+post.getId());
		while(tagRs.next()) {
			post.addTag(tagRs.getInt(1));
		}
		tagStatement.close();
		statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		return post;
	}
	
	public String getTagName(int id) {
		Connection connection=Database.getConnection();
		ResultSet rs=null;
		Statement statement;
			try {
				statement = connection.createStatement();
			
		 rs = statement.executeQuery("select name from pollution_types where id="+id);
			String raspuns=null;
			if(rs.next()) {
				raspuns=rs.getString(1);
			}
			statement.close();
		return raspuns;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
	public ArrayList<Post> getPosts(String table) {
		ArrayList<Post> result=new ArrayList<Post>();
		Connection connection=Database.getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery("select * from "+table+" order by id desc");
		
		while(rs.next()) {
			Post post=new Post(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getFloat(7), rs.getString(8));
			Statement tagStatement=connection.createStatement();
			ResultSet tagRs = tagStatement.executeQuery("select id from pollution_tags where post_id="+post.getId());
		while(tagRs.next()) {
			post.addTag(tagRs.getInt(1));
		}
		tagStatement.close();
		result.add(post);
		}
		statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public int getNextAvailableId() throws SQLException {
		Connection connection=Database.getConnection();
		Statement statement=connection.createStatement();
		ResultSet rs = statement.executeQuery("select id_sequence.nextval from dual");
		int result=0;
		if(rs.next())
			result=rs.getInt(1);
		
		statement.close();
		return result;
		
	}
	
	public void deletePost(String table,int id) {
		Connection connection = Database.getConnection();
        PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement("delete from "+table+" where id="+id);
            pstmt.executeUpdate();
         pstmt = connection.prepareStatement("delete from pollution_tags where post_id="+id);
            pstmt.executeUpdate();
            pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void banUser(String email) {
		Connection connection = Database.getConnection();
        PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement("insert into banned_users values (\'"+email+"\')");
            pstmt.executeUpdate();
            pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
            
	   }
	public boolean checkBanUser(String email) {
		
		Connection connection = Database.getConnection();
		Statement statement;
		ResultSet rs=null;
		try {
			statement = connection.createStatement();
		
		rs=statement.executeQuery("select count(*) from banned_users where email=\'"+email+"\'");
	    rs.next();
	    int result=rs.getInt(1);
	    statement.close();
		return result>0 ? true  : false;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return true;
	}
	
}
