import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SCRUMTeamMembers {
	private static Connection conn = null;
	private static Statement stmnt = null;
    private static String TeamName;
    private static String EmployeeID;

    public SCRUMTeamMembers(Connection connection, Statement statement) {
    	conn = connection;
		stmnt = statement;
    }
    
    public static void update(String TeamName, String EmployeeID) {
		String updateSQL = "UPDATE SCRUMTeamMembers SET EmployeeID=? WHERE TeamName=?";
			
			try {
				
				PreparedStatement statement = conn.prepareStatement(updateSQL);
				statement.setString(1, EmployeeID);
				statement.setString(2, TeamName);
				statement.executeUpdate();
			
			}//end of try
			catch(SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
				}
		}
	
	public static void insert(String TeamName , String EmployeeID) {

		String updateSQL = "INSERT INTO SCRUMTeamMembers (TeamName , EmployeeID) VALUES(?,?)";
		
		
		try {
			
			PreparedStatement statement = conn.prepareStatement(updateSQL);
			statement.setString(1, TeamName);
			statement.setString(2, EmployeeID);
			statement.executeUpdate();
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
	public static void delete(String TeamName) {
	
		String updateSQL = "DELETE FROM SCRUMTeamMembers WHERE TeamName=?";
		
		
		try {

			PreparedStatement statement = conn.prepareStatement(updateSQL);
			statement.setString(1, TeamName);
			statement.execute();
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
	
	public static void List() {

		String updateSQL = "SELECT * FROM SCRUMTeamMembers";
		
		try {

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(updateSQL);
		
			while(result.next()) {
				TeamName = result.getString(1);
				EmployeeID = result.getString(2);
			
				System.out.println("TeamName: " + TeamName + "\tTeamName: " + EmployeeID);
			}
			
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
    
}
