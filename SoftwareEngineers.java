import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SoftwareEngineers {
	private static String EmployeeID;
	private static String FirstName;
	private static String LastName;
	private static String PhoneNumber;
	private static String Email;
	private static String HireDate;
	private static Connection conn = null;
	private static Statement stmnt = null;
	
	public SoftwareEngineers(Connection connection, Statement statement) {
		conn = connection;
		stmnt = statement;
	}
	
	public static void update(String EmployeeID , String FirstName, String LastName, String PhoneNumber, String Email, String HireDate) {
	String updateSQL = "UPDATE SoftwareEngineers SET StartDate=?, EndDate=? WHERE EmployeeID=?";
		
		try {
			
			PreparedStatement statement = conn.prepareStatement(updateSQL);
			statement.setString(1, FirstName );
			statement.setString(2, LastName);
			statement.setString(3, PhoneNumber);
			statement.setString(4, Email);
			statement.setString(5, HireDate);
			statement.setString(6, EmployeeID);
			statement.executeUpdate();
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
	}
	
	public static void insert(String EmployeeID , String FirstName, String LastName, String PhoneNumber, String Email, String HireDate) {

		String updateSQL = "INSERT INTO SoftwareEngineers (EmployeeID, FirstName, LastName, PhoneNumber, Email, HireDate) VALUES(?,?,?,?,?,?)";
		
		
		try {
			
			PreparedStatement statement = conn.prepareStatement(updateSQL);
			statement.setString(1, EmployeeID);
			statement.setString(2, FirstName);
			statement.setString(3, LastName);
			statement.setString(4, PhoneNumber);
			statement.setString(5, Email);
			statement.setString(6, HireDate);
			
			statement.executeUpdate();
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
	public static void delete(String EmployeeID) {
	
		String updateSQL = "DELETE FROM SoftwareEngineers WHERE EmployeeID=?";
		
		
		try {

			PreparedStatement statement = conn.prepareStatement(updateSQL);
			statement.setString(1, EmployeeID);
			statement.execute();
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}
	
	public static void List() {

		String updateSQL = "SELECT * FROM SoftwareEngineers";
		
		try {

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(updateSQL);
			
			while(result.next()) {
				EmployeeID = result.getString(1);
				FirstName = result.getString(2);
				LastName = result.getString(3);
				PhoneNumber = result.getString(4);
				Email = result.getString(5);
				HireDate = result.getString(6);
				System.out.println("EmployeeID: " + EmployeeID + "\tName: " + FirstName + " " + LastName + "\tPhoneNumber: " 
				+ PhoneNumber + "\tEmail: " + Email + "\tHireDate: " + HireDate);
			}
			
		
		}//end of try
		catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());ex.printStackTrace();
			}
		
	}

}
