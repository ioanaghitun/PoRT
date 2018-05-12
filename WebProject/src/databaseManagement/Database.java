package databaseManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String USER = "PoRT";
    private static final String PASSWORD = "parolagrea";
    private static Connection connection = null;
    private Database() { }
    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        System.out.println(connection);
        return connection;
    }
    private static void createConnection() {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		 try {
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void closeConnection(){
	   try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
    public static void commit() {
    	try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void rollback() {
    	try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}