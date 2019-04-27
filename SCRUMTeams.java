import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SCRUMTeams {

    private static String ProjectName;
    private static String TeamName;
    private static String TeamLeader;
    private static String FormDate;
	private static Connection conn = null;
	private static Statement stmnt = null;
	
	public SCRUMTeams(Connection connection, Statement statement) {
		conn = connection;
		stmnt = statement;
	}
	
	public static void update(String ProjectName , String TeamName, String TeamLeader, String FormDate) {
		String updateSQL = "UPDATE SCRUMTeams SET ProjectName=?, TeamLeader=?, FormDate=? WHERE TeamName=?";
			
			try {
				
				PreparedStatement statement = conn.prepareStatement(updateSQL);
				statement.setString(1, ProjectName);
				statement.setString(2, TeamLeader);
				statement.setString(3, FormDate);
				statement.setString(4, TeamName);
				statement.executeUpdate();
			
			}//end of try
			catch(SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
				}
		}
	
	public static void insert(String ProjectName , String TeamName, String TeamLeader, String FormDate) {

		String updateSQL = "INSERT INTO SCRUMTeams (ProjectName , TeamName, TeamLeader, FormDate) VALUES(?,?,?,?)";
		
		
		try {
			
			PreparedStatement statement = conn.prepareStatement(updateSQL);
			statement.setString(1, ProjectName);
			statement.setString(2, TeamName);
			statement.setString(3, TeamLeader);
			statement.setString(4, FormDate);
			
			
			statement.executeUpdate();
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
	public static void delete(String TeamName) {
	
		String updateSQL = "DELETE FROM SCRUMTeams WHERE TeamName=?";
		
		
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

		String updateSQL = "SELECT * FROM SCRUMTeams";
		
		try {

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(updateSQL);
		
			while(result.next()) {
				ProjectName = result.getString(1);
				TeamName = result.getString(2);
				TeamLeader = result.getString(3);
				FormDate = result.getString(4);
			;
				System.out.println("ProjectName: " + ProjectName + "\tTeamName: " + TeamName + "\tTeamLeader: " + TeamLeader + "\tFormDate: " + FormDate);
			}
			
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
}
