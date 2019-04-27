import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserStories {
	private static Connection conn = null;
	private static Statement stmnt = null;
	private static String USID;
    private static String ProjectName;
    private static String Role;
    private static String Goal;
    private static String Benefit;

	 public UserStories(Connection connection, Statement statement) {
	    	conn = connection;
			stmnt = statement;
	    }
	 
	    
	    public static void update(String USID, String ProjectName, String Role, String Goal, String Benefit) {
			String updateSQL = "UPDATE UserStories SET ProjectName=?,Role=?,Goal=?,Benefit=? WHERE USID=?";
				
				try {
					
					PreparedStatement statement = conn.prepareStatement(updateSQL);
					statement.setString(1, ProjectName);
					statement.setString(2, Role);
					statement.setString(3, Goal);
					statement.setString(4, Benefit);
					statement.setString(5, USID);
					statement.executeUpdate();
				
				}//end of try
				catch(SQLException ex){
					System.out.println("SQLException: " + ex.getMessage());
					System.out.println("SQLState: " + ex.getSQLState());
					System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
					}
			}
		
		public static void insert(String USID, String ProjectName, String Role, String Goal, String Benefit) {

			String updateSQL = "INSERT INTO UserStories (USID,ProjectName,Role,Goal,Benefit) VALUES(?,?,?,?,?)";
			
			
			try {
				
				PreparedStatement statement = conn.prepareStatement(updateSQL);
				statement.setString(1, USID);
				statement.setString(2, ProjectName);
				statement.setString(3, Role);
				statement.setString(4, Goal);
				statement.setString(5, Benefit);
				statement.executeUpdate();
			
			}//end of try
			catch(SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
				}
			
		}
		public static void delete(String USID) {
		
			String updateSQL = "DELETE FROM UserStories WHERE USID=?";
			
			
			try {

				PreparedStatement statement = conn.prepareStatement(updateSQL);
				statement.setString(1, USID);
				statement.execute();
			
			}//end of try
			catch(SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
				}
			
		}
		
		public static void List() {

			String updateSQL = "SELECT * FROM UserStories ";
			
			try {

				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(updateSQL);
			
				while(result.next()) {
					USID = result.getString(1);
				    ProjectName = result.getString(2);
				    Role = result.getString(3);
				    Goal = result.getString(4);
				    Benefit = result.getString(5);
			
				
					System.out.println("USID: " + USID + "\tProjectName: " + ProjectName + "\tRole: " + Role + "\tGoal: " + Goal
							+ "\tBenefit: " + Benefit);
				}
				
			
			}//end of try
			catch(SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
				}
			
		}
}
