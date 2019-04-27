import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Projects {
	

	private static String ProjectName;
	private static String StartDate;
	private static String EndDate;
	private static Connection conn = null;
	private static Statement stmnt = null;
	
	public Projects(Connection connection, Statement statement) {
		conn = connection;
		stmnt = statement;
	}
	
	public static void insert(String ProjectName, String StartDate, String EndDate) {
		Scanner in = new Scanner(System.in);
		String updateSQL = "INSERT INTO example (ProjectName, StartDate, EndDate) VALUES(?,?,?)";
		
		
		try {
			
			PreparedStatement statement = conn.prepareStatement(updateSQL);
			statement.setString(1, ProjectName);
			statement.setString(2, StartDate);
			statement.setString(3, EndDate);
			statement.executeUpdate();
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
	public static void delete(String ProjectName) {
		Scanner in = new Scanner(System.in);
		String updateSQL = "DELETE FROM Projects WHERE ProjectName=?";
		
		
		try {

			PreparedStatement statement = conn.prepareStatement(updateSQL);
			statement.setString(1, ProjectName);
			statement.execute();
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
	
	public static void List() {
		Scanner in = new Scanner(System.in);
		String updateSQL = "SELECT * FROM Projects";
		
		
		try {

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(updateSQL);
			
			while(result.next()) {
				ProjectName = result.getString(1);
				StartDate = result.getString(2);
				EndDate = result.getString(3);
				System.out.println("name: " + ProjectName + "\tid: " + StartDate + "\tage: " + EndDate);
			}
			
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
	
}
