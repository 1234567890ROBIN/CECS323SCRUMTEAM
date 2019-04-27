import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagementMembers {
	
	private static Connection conn = null;
	private static Statement stmnt = null;
	private static String ProjectName;
	private static String EmployeeID;
	
	public ManagementMembers(Connection connection, Statement statement) {
		conn = connection;
		stmnt = statement;
	}
	
	public static void update(String ProjectName , String EmployeeID) {
		String updateSQL = "UPDATE ManagementMembers SET EmployeeID=? WHERE ProjectName=?";
			
			try {
				
				PreparedStatement statement = conn.prepareStatement(updateSQL);
				statement.setString(1, EmployeeID);
				statement.setString(2, ProjectName);
				statement.executeUpdate();
			
			}//end of try
			catch(SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
				}
		}
	
	public static void insert(String ProjectName , String EmployeeID) {

		String updateSQL = "INSERT INTO ManagementMembers (ProjectName , EmployeeID) VALUES(?,?)";
		
		
		try {
			
			PreparedStatement statement = conn.prepareStatement(updateSQL);
			statement.setString(1, ProjectName);
			statement.setString(2, EmployeeID);
			statement.executeUpdate();
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
	public static void delete(String ProjectName) {
	
		String updateSQL = "DELETE FROM ManagementMembers WHERE ProjectName=?";
		
		
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

		String updateSQL = "SELECT * FROM ManagementMembers";
		
		try {

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(updateSQL);
		
			while(result.next()) {
				ProjectName = result.getString(1);
				EmployeeID = result.getString(2);
			
				System.out.println("ProjectName: " + ProjectName + "\tTeamName: " + EmployeeID);
			}
			
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
	
}
