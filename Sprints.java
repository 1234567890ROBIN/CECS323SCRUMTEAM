import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sprints {
	private static Connection conn = null;
	private static Statement stmnt = null;
	private static String ProjectName;
    private static String SprintID;
    private static String StartDate;
    private static String EndDate;
    private static String Status;

    public Sprints(Connection connection, Statement statement) {
    	conn = connection;
		stmnt = statement;
    }
    
    public static void update(String ProjectName, String SprintID, String StartDate, String EndDate, String Status) {
		String updateSQL = "UPDATE Sprints SET ProjectName=?, StartDate=?, EndDate=?, Status=? WHERE SprintID=?";
			
			try {
				
				PreparedStatement statement = conn.prepareStatement(updateSQL);
				statement.setString(1, ProjectName);
				statement.setString(2, StartDate);
				statement.setString(3, EndDate);
				statement.setString(4, Status);
				statement.setString(5, SprintID);
				statement.executeUpdate();
			
			}//end of try
			catch(SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
				}
		}
	
	public static void insert(String ProjectName, String SprintID, String StartDate, String EndDate, String Status) {

		String updateSQL = "INSERT INTO Sprints(ProjectName,SprintID,StartDate,EndDate,Status) VALUES(?,?,?,?,?)";
		
		
		try {
			
			PreparedStatement statement = conn.prepareStatement(updateSQL);
			statement.setString(1, ProjectName);
			statement.setString(2, SprintID);
			statement.setString(3, StartDate);
			statement.setString(4, EndDate);
			statement.setString(5, Status);
			statement.executeUpdate();
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
	public static void delete(String SprintID) {
	
		String updateSQL = "DELETE FROM Sprints WHERE ProjectName=?";
		
		
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

		String updateSQL = "SELECT * FROM Sprints";
		
		try {

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(updateSQL);
		
			while(result.next()) {
			
				ProjectName = result.getString(1);
				SprintID = result.getString(2);
				StartDate = result.getString(3);
				EndDate = result.getString(4);
				Status = result.getString(5);
			
				System.out.println("ProjectName: " + ProjectName + "\tSprintID: " + SprintID + "\tStartDate: " 
				+ StartDate + "\nEndDate: " + EndDate + "\nStatus: " + Status);
			}
			
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
    
    
}
