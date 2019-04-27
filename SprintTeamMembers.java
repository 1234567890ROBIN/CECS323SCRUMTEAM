import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SprintTeamMembers {
	private static Connection conn = null;
	private static Statement stmnt = null;
	private static String TeamName;
    private static String EmployeeID;
    private static String SprintID;

	
	 public SprintTeamMembers(Connection connection, Statement statement) {
	    	conn = connection;
			stmnt = statement;
	    }
	    
	    public static void update(String TeamName, String SprintID, String EmployeeID) {
			String updateSQL = "UPDATE SprintTeamMembers  SET TeamName=?,EmployeeID=? WHERE SprintID=?";
				
				try {
					
					PreparedStatement statement = conn.prepareStatement(updateSQL);
					statement.setString(1, TeamName);
					statement.setString(2, EmployeeID);
					statement.setString(3, SprintID);
					statement.executeUpdate();
				
				}//end of try
				catch(SQLException ex){
					System.out.println("SQLException: " + ex.getMessage());
					System.out.println("SQLState: " + ex.getSQLState());
					System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
					}
			}
		
		public static void insert(String TeamName,String SprintID , String EmployeeID) {

			String updateSQL = "INSERT INTO SprintTeamMembers  (TeamName,SprintID,EmployeeID) VALUES(?,?,?)";
			
			
			try {
				
				PreparedStatement statement = conn.prepareStatement(updateSQL);
				statement.setString(1, TeamName);
				statement.setString(2, SprintID);
				statement.setString(3, EmployeeID);
				statement.executeUpdate();
			
			}//end of try
			catch(SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
				}
			
		}
		public static void delete(String SprintID) {
		
			String updateSQL = "DELETE FROM SprintTeamMembers  WHERE SprintID=?";
			
			
			try {

				PreparedStatement statement = conn.prepareStatement(updateSQL);
				statement.setString(1, SprintID);
				statement.execute();
			
			}//end of try
			catch(SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
				}
			
		}
		
		public static void List() {

			String updateSQL = "SELECT * FROM SprintTeamMembers ";
			
			try {

				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(updateSQL);
			
				while(result.next()) {
					TeamName = result.getString(1);
					EmployeeID = result.getString(2);
					SprintID = result.getString(3);
				
					System.out.println("TeamName: " + TeamName + "\tTeamName: " + EmployeeID + "\tSprintID: " + SprintID);
				}
				
			
			}//end of try
			catch(SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
				}
			
		}
}
